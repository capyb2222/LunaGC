package emu.grasscutter.server.packet.send;

import emu.grasscutter.net.packet.BasePacket;
import emu.grasscutter.net.packet.PacketOpcodes;
import java.util.Set;
import emu.grasscutter.net.proto.HomeAvatarTalkFinishInfo;
import emu.grasscutter.net.proto.HomeAvatarTalkRsp;

public class PacketHomeAvatarTalkRsp extends BasePacket {
    public PacketHomeAvatarTalkRsp(int avatarId, Set<Integer> talkIdSet) {
        super(PacketOpcodes.HomeAvatarTalkRsp);

        this.setData(
                HomeAvatarTalkRsp.newBuilder()
                        .setAvatarTalkInfo(
                                HomeAvatarTalkFinishInfo.newBuilder()
                                        .setAvatarId(avatarId)
                                        .addAllFinishTalkIdList(talkIdSet)
                                        .build()));
    }
}
