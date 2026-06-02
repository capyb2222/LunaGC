package emu.grasscutter.server.packet.send;

import emu.grasscutter.net.packet.*;
import emu.grasscutter.net.proto.QuestDestroyEntityReq;
import emu.grasscutter.net.proto.QuestDestroyEntityRsp;
import emu.grasscutter.net.proto.Retcode;

public class PacketQuestDestroyEntityRsp extends BasePacket {

    public PacketQuestDestroyEntityRsp(boolean success, QuestDestroyEntityReq req) {
        super(PacketOpcodes.QuestDestroyEntityRsp);

        this.setData(
                QuestDestroyEntityRsp.newBuilder()
                        .setQuestId(req.getQuestId())
                        .setEntityId(req.getEntityId())
                        .setSceneId(req.getSceneId())
                        .setRetcode(success ? Retcode.RET_SUCC_VALUE : Retcode.RET_FAIL_VALUE));
    }
}
