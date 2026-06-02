"""
mitmproxy addon — redirect Genshin HoYoPass / SDK login traffic to a local LunaGC server.

The client patch (patch/) already redirects dispatch (query_cur_region) and the in-game
browser *inside* the client, and null-routes *.yuanshen.com. What it does NOT redirect is
the HoYoPass / account login API calls (ma-passport, shield login, combo granter, the
account risk check, and the supporting static/config endpoints). This addon catches those
and points them at LunaGC, which already serves every one of those paths.

    Run:   mitmdump -s proxy/lunagc_redirect.py
    Then:  set the Windows system proxy to 127.0.0.1:8080 and trust the mitmproxy CA cert.

See proxy/README.md for the full setup (cert install, system proxy, caveats).
"""

import logging
import os

from mitmproxy import http

logger = logging.getLogger("lunagc")

# Also write redirect events to proxy/redirect.log so they're visible even when
# mitmdump runs headless (its console output isn't captured when detached).
_LOG_FILE = os.path.join(os.path.dirname(os.path.abspath(__file__)), "redirect.log")
_file_handler = logging.FileHandler(_LOG_FILE, encoding="utf-8")
_file_handler.setFormatter(logging.Formatter("%(asctime)s %(message)s"))
logger.addHandler(_file_handler)
logger.setLevel(logging.INFO)

# --- Where LunaGC's HTTP dispatch server listens ---------------------------------
# These match the LunaGC defaults (config: http.bindPort = 8088, useEncryption = false)
# and the value hardcoded in the client patch (http.rs -> http://127.0.0.1:8088).
LUNAGC_HOST = "127.0.0.1"
LUNAGC_PORT = 8088
LUNAGC_SCHEME = "http"  # set to "https" only if you enabled useEncryption in LunaGC

# --- Domains to redirect ----------------------------------------------------------
# Everything HoYoPass / SDK / account / webstatic lives under these two suffixes.
# *.yuanshen.com (dispatch) is intentionally LEFT OUT: the client patch handles it
# in-client and also null-routes it via getaddrinfo, so redirecting it here would
# fight the patch. Add it only if you run WITHOUT the patch's dispatch redirect.
REDIRECT_SUFFIXES = (
    "hoyoverse.com",
    "mihoyo.com",
)


def _should_redirect(host: str) -> bool:
    host = (host or "").lower()
    return any(host == suffix or host.endswith("." + suffix) for suffix in REDIRECT_SUFFIXES)


def request(flow: http.HTTPFlow) -> None:
    host = flow.request.pretty_host
    if not _should_redirect(host):
        return  # leave all other traffic (incl. *.yuanshen.com) untouched

    logger.info(
        "[LunaGC] %s %s://%s%s -> %s://%s:%d",
        flow.request.method,
        flow.request.scheme,
        host,
        flow.request.path,
        LUNAGC_SCHEME,
        LUNAGC_HOST,
        LUNAGC_PORT,
    )

    # Reroute the upstream connection. The Host header is left as the original domain
    # on purpose — LunaGC (Javalin) routes purely on path, and keeping it makes the
    # mitmproxy log readable and avoids any host-based assumptions.
    flow.request.scheme = LUNAGC_SCHEME
    flow.request.host = LUNAGC_HOST
    flow.request.port = LUNAGC_PORT
