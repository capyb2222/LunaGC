package emu.grasscutter.server.packet.recv;

import emu.grasscutter.net.packet.*;
import emu.grasscutter.net.proto.PlayerCookReq;
import emu.grasscutter.server.game.GameSession;

@Opcodes(PacketOpcodes.PlayerCookReq)
public class HandlerPlayerCookReq extends PacketHandler {
    @Override
    public void handle(GameSession session, byte[] header, byte[] payload) throws Exception {
        PlayerCookReq req =
                PlayerCookReq.parseFrom(payload);
        session.getPlayer().getCookingManager().handlePlayerCookReq(req);
    }
}
