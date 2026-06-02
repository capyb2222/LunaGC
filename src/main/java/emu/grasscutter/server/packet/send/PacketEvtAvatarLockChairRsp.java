package emu.grasscutter.server.packet.send;

import emu.grasscutter.game.entity.EntityAvatar;
import emu.grasscutter.net.packet.*;
import emu.grasscutter.net.proto.EvtAvatarLockChairReq;
import emu.grasscutter.net.proto.EvtAvatarLockChairRsp;
import emu.grasscutter.net.proto.Retcode;

public class PacketEvtAvatarLockChairRsp extends BasePacket {
    public PacketEvtAvatarLockChairRsp(
            int clientSequence, EntityAvatar entityAvatar, EvtAvatarLockChairReq lockChairReq) {
        super(PacketOpcodes.EvtAvatarLockChairRsp);

        EvtAvatarLockChairRsp p =
                EvtAvatarLockChairRsp.newBuilder()
                        .setRetcode(Retcode.RET_SUCC_VALUE)
                        .setEntityId(entityAvatar.getId())
                        .setPosition(lockChairReq.getPosition())
                        .setChairId(lockChairReq.getChairId())
                        .build();

        this.setData(p);
    }
}
