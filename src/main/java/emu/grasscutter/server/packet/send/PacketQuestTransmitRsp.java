package emu.grasscutter.server.packet.send;

import emu.grasscutter.net.packet.*;
import emu.grasscutter.net.proto.QuestTransmitReq;
import emu.grasscutter.net.proto.QuestTransmitRsp;
import emu.grasscutter.net.proto.Retcode;

public class PacketQuestTransmitRsp extends BasePacket {

    public PacketQuestTransmitRsp(boolean result, QuestTransmitReq req) {
        super(PacketOpcodes.QuestTransmitRsp);
        this.setData(
                QuestTransmitRsp.newBuilder()
                        .setQuestId(req.getQuestId())
                        .setPointId(req.getPointId())
                        .setRetcode(result ? Retcode.RET_SUCC_VALUE : Retcode.RET_FAIL_VALUE));
    }
}
