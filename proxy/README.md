# LunaGC HoYoPass redirect (mitmproxy)

The client patch redirects dispatch and the in-game browser, but **not** the HoYoPass /
account login API calls (`api-account-os.hoyoverse.com`, `hk4e-sdk-os.hoyoverse.com`,
ma-passport, the SDK static/config endpoints, etc.). This addon routes those to your local
LunaGC server so login completes.

> You still need the client **patch** — mitmproxy only moves HTTP(S) traffic; it cannot do
> the RSA key swap the patch performs. Use both together.

## Prerequisites
- mitmproxy installed (`mitmdump --version` — tested with 12.x).
- LunaGC running with the defaults: HTTP on `127.0.0.1:8088`, `useEncryption: false`.
  If you changed the port/scheme, edit the constants at the top of `lunagc_redirect.py`.

## 1. Generate + trust the mitmproxy CA (one time)
mitmproxy MITMs TLS, so its CA must be trusted by Windows or every HTTPS call will fail.

```powershell
# Run once to generate the CA into %USERPROFILE%\.mitmproxy\
mitmdump --version

# Install the CA into the machine's Trusted Root store (needs an elevated terminal)
certutil -addstore -f Root "$env:USERPROFILE\.mitmproxy\mitmproxy-ca-cert.cer"
```

> ⚠️ A trusted root CA lets mitmproxy decrypt **all** your machine's TLS traffic. Only keep
> it installed while you need it. To remove later:
> `certutil -delstore Root mitmproxy`

(Alternative GUI method: start mitmproxy, browse to `http://mitm.it`, follow the Windows steps.)

## 2. Start the proxy
From the repo root:

```powershell
mitmdump -s proxy/lunagc_redirect.py
```

Leave it running. Each redirected request prints a `[LunaGC]` line so you can confirm
HoYoPass calls are being caught.

## 3. Point Windows at the proxy
mitmproxy listens on `127.0.0.1:8080` by default. Enable the system proxy:

```powershell
# Turn ON
Set-ItemProperty 'HKCU:\Software\Microsoft\Windows\CurrentVersion\Internet Settings' ProxyServer '127.0.0.1:8080'
Set-ItemProperty 'HKCU:\Software\Microsoft\Windows\CurrentVersion\Internet Settings' ProxyEnable 1
```

```powershell
# Turn OFF (do this when you're done playing)
Set-ItemProperty 'HKCU:\Software\Microsoft\Windows\CurrentVersion\Internet Settings' ProxyEnable 0
```

(Or set it via Settings → Network & Internet → Proxy → Manual proxy → `127.0.0.1:8080`.)

## 4. Launch
Start LunaGC, then start the patched game and log in. Watch the mitmdump console: you should
see `[LunaGC]` redirect lines for `hk4e-sdk-os` / `api-account-os` as you log in.

## Notes & gotchas
- **Turn the system proxy off when you're done** — while it's on, all your machine's traffic
  goes through mitmproxy.
- `*.yuanshen.com` (dispatch) is deliberately **not** redirected here — the patch handles it
  in-client and null-routes it. Don't add it unless you're running without that patch.
- If login still fails, check the mitmdump log for the failing host and add its suffix to
  `REDIRECT_SUFFIXES` in `lunagc_redirect.py`.
- If you enabled `useEncryption: true` in LunaGC, set `LUNAGC_SCHEME = "https"` in the script.
