package emu.grasscutter.server.packet.send;

import emu.grasscutter.net.packet.*;
import emu.grasscutter.net.proto.QuestCreateEntityReq;
import emu.grasscutter.net.proto.QuestCreateEntityRsp;
import emu.grasscutter.net.proto.Retcode;

public class PacketQuestCreateEntityRsp extends BasePacket {

    public PacketQuestCreateEntityRsp(int entityId, QuestCreateEntityReq req) {
        super(PacketOpcodes.QuestCreateEntityRsp);

        this.setData(
                QuestCreateEntityRsp.newBuilder()
                        .setQuestId(req.getQuestId())
                        .setEntity(req.getEntity())
                        .setParentQuestId(req.getParentQuestId())
                        .setIsRewind(req.getIsRewind())
                        .setEntityId(entityId)
                        .setRetcode(entityId != -1 ? Retcode.RET_SUCC_VALUE : Retcode.RET_FAIL_VALUE));
    }
}
