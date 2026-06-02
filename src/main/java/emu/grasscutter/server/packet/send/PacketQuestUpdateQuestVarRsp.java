package emu.grasscutter.server.packet.send;

import emu.grasscutter.net.packet.*;
import emu.grasscutter.net.proto.QuestUpdateQuestVarReq;
import emu.grasscutter.net.proto.QuestUpdateQuestVarRsp;
import emu.grasscutter.net.proto.Retcode;

@Opcodes(PacketOpcodes.QuestUpdateQuestVarReq)
public class PacketQuestUpdateQuestVarRsp extends BasePacket {

    public PacketQuestUpdateQuestVarRsp(QuestUpdateQuestVarReq req) {
        this(req, Retcode.RET_SUCC);
    }

    public PacketQuestUpdateQuestVarRsp(QuestUpdateQuestVarReq req, Retcode retcode) {
        super(PacketOpcodes.QuestUpdateQuestVarRsp);
        var rsp =
                QuestUpdateQuestVarRsp.newBuilder()
                        .setQuestId(req.getQuestId())
                        .setParentQuestId(req.getParentQuestId())
                        .setRetcode(retcode.getNumber())
                        .build();
        this.setData(rsp);
    }
}
