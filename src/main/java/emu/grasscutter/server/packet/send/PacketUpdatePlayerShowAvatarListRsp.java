package emu.grasscutter.server.packet.send;

import emu.grasscutter.net.packet.*;
import emu.grasscutter.net.proto.UpdatePlayerShowAvatarListRsp;
import java.util.List;

public class PacketUpdatePlayerShowAvatarListRsp extends BasePacket {

    public PacketUpdatePlayerShowAvatarListRsp(boolean isShowAvatar, List<Integer> avatarIds) {
        super(PacketOpcodes.UpdatePlayerShowAvatarListRsp);

        UpdatePlayerShowAvatarListRsp proto =
                UpdatePlayerShowAvatarListRsp.newBuilder()
                        .setIsShowAvatar(isShowAvatar)
                        .addAllShowAvatarIdList(avatarIds)
                        .setRetcode(0)
                        .build();

        this.setData(proto);
    }
}
