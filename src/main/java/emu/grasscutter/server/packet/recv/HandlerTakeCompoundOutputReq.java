package emu.grasscutter.server.packet.recv;

import emu.grasscutter.net.packet.*;
import emu.grasscutter.net.proto.TakeCompoundOutputReq;
import emu.grasscutter.server.game.GameSession;

@Opcodes(PacketOpcodes.TakeCompoundOutputReq)
public class HandlerTakeCompoundOutputReq extends PacketHandler {
    @Override
    public void handle(GameSession session, byte[] header, byte[] payload) throws Exception {
        var req = TakeCompoundOutputReq.parseFrom(payload);
        session.getPlayer().getCookingCompoundManager().handleTakeCompoundOutputReq(req);
    }
}
