package emu.grasscutter.server.packet.recv;

import emu.grasscutter.net.packet.*;
import emu.grasscutter.net.proto.DelMailReq;
import emu.grasscutter.server.game.GameSession;

@Opcodes(PacketOpcodes.DelMailReq)
public class HandlerDelMailReq extends PacketHandler {

    @Override
    public void handle(GameSession session, byte[] header, byte[] payload) throws Exception {
        DelMailReq req = DelMailReq.parseFrom(payload);

        session.getPlayer().getMailHandler().deleteMail(req.getMailIdListList());
    }
}
