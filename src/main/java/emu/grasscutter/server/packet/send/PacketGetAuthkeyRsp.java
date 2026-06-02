package emu.grasscutter.server.packet.send;

import emu.grasscutter.net.packet.*;
import emu.grasscutter.net.proto.GetAuthkeyRsp;
import emu.grasscutter.net.proto.Retcode;

public class PacketGetAuthkeyRsp extends BasePacket {

    public PacketGetAuthkeyRsp() {
        super(PacketOpcodes.GetAuthkeyRsp);

        GetAuthkeyRsp proto =
                GetAuthkeyRsp.newBuilder()
                        .setRetcode(Retcode.RET_SVR_ERROR_VALUE)
                        .build();

        this.setData(proto);
    }
}
