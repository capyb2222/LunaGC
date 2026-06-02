package emu.grasscutter.server.packet.send;

import emu.grasscutter.net.packet.*;
import emu.grasscutter.net.proto.ChangeAvatarRsp;
import emu.grasscutter.net.proto.Retcode;

public class PacketChangeAvatarRsp extends BasePacket {

    public PacketChangeAvatarRsp(long guid) {
        super(PacketOpcodes.ChangeAvatarRsp);

        ChangeAvatarRsp p =
                ChangeAvatarRsp.newBuilder()
                        //.setRetcode(Retcode.RET_SUCC_VALUE)
                        .setCurGuid(guid)
                        .build();

        this.setData(p);
    }
}
