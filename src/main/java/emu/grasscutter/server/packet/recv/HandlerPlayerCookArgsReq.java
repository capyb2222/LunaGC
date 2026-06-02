package emu.grasscutter.server.packet.recv;

import emu.grasscutter.net.packet.*;
import emu.grasscutter.net.proto.PlayerCookArgsReq;
import emu.grasscutter.server.game.GameSession;

@Opcodes(PacketOpcodes.PlayerCookArgsReq)
public class HandlerPlayerCookArgsReq extends PacketHandler {
    @Override
    public void handle(GameSession session, byte[] header, byte[] payload) throws Exception {
        PlayerCookArgsReq req =
                PlayerCookArgsReq.parseFrom(payload);
        session.getPlayer().getCookingManager().handleCookArgsReq(req);
    }
}
