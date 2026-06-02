package emu.grasscutter.server.packet.recv;

import emu.grasscutter.net.packet.*;
import emu.grasscutter.net.proto.ForgeStartReq;
import emu.grasscutter.server.game.GameSession;

@Opcodes(PacketOpcodes.ForgeStartReq)
public class HandlerForgeStartReq extends PacketHandler {

    @Override
    public void handle(GameSession session, byte[] header, byte[] payload) throws Exception {
        ForgeStartReq req =
                ForgeStartReq.parseFrom(payload);
        session.getPlayer().getForgingManager().handleForgeStartReq(req);
    }
}
