package emu.grasscutter.server.packet.recv;

import emu.grasscutter.Grasscutter;
import emu.grasscutter.net.packet.*;
import emu.grasscutter.net.proto.CancelCoopTaskReq;
import emu.grasscutter.server.game.GameSession;
import emu.grasscutter.server.packet.send.PacketCancelCoopTaskRsp;

@Opcodes(PacketOpcodes.CancelCoopTaskReq)
public class HandlerCancelCoopTaskReq extends PacketHandler {

    @Override
    public void handle(GameSession session, byte[] header, byte[] payload) throws Exception {
        CancelCoopTaskReq req =
                CancelCoopTaskReq.parseFrom(payload);
        var chapterId = req.getChapterId();
        Grasscutter.getLogger().warn("Call to unimplemented packet CancelCoopTaskReq");
        // TODO: Actually cancel the quests.
        session.send(new PacketCancelCoopTaskRsp(chapterId));
    }
}
