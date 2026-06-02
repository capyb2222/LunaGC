package emu.grasscutter.server.packet.send;

import emu.grasscutter.net.packet.*;
import emu.grasscutter.net.proto.AvatarChangeCostumeRsp;
import emu.grasscutter.net.proto.Retcode;

public class PacketAvatarChangeCostumeRsp extends BasePacket {

    public PacketAvatarChangeCostumeRsp(long avatarGuid, int costumeId) {
        super(PacketOpcodes.AvatarChangeCostumeRsp);

        AvatarChangeCostumeRsp proto =
                AvatarChangeCostumeRsp.newBuilder()
                        .setAvatarGuid(avatarGuid)
                        .setCostumeId(costumeId)
                        .build();

        this.setData(proto);
    }

    public PacketAvatarChangeCostumeRsp() {
        super(PacketOpcodes.AvatarChangeCostumeRsp);

        AvatarChangeCostumeRsp proto =
                AvatarChangeCostumeRsp.newBuilder()
                        .setRetcode(Retcode.RET_SVR_ERROR_VALUE)
                        .build();

        this.setData(proto);
    }
}
