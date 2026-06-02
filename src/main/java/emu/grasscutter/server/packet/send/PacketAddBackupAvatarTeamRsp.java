package emu.grasscutter.server.packet.send;

import emu.grasscutter.net.packet.*;
import emu.grasscutter.net.proto.AddBackupAvatarTeamRsp;
import emu.grasscutter.net.proto.Retcode;

public class PacketAddBackupAvatarTeamRsp extends BasePacket {
    public PacketAddBackupAvatarTeamRsp(Retcode retcode) {
        super(PacketOpcodes.AddBackupAvatarTeamRsp);

        AddBackupAvatarTeamRsp proto =
                AddBackupAvatarTeamRsp.newBuilder().setRetcode(retcode.getNumber()).build();

        this.setData(proto);
    }

    public PacketAddBackupAvatarTeamRsp() {
        this(Retcode.RET_SUCC);
    }
}
