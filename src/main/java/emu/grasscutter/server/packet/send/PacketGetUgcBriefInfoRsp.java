package emu.grasscutter.server.packet.send;

import emu.grasscutter.net.packet.*;
import emu.grasscutter.net.proto.GetUgcBriefInfoRsp;
import emu.grasscutter.net.proto.Retcode;
import emu.grasscutter.net.proto.UgcMusicBriefInfo;
import emu.grasscutter.net.proto.UgcType;

public class PacketGetUgcBriefInfoRsp extends BasePacket {

    public PacketGetUgcBriefInfoRsp(Retcode ret, UgcType unknownEnum1) {
        super(PacketOpcodes.GetUgcBriefInfoRsp);

        var proto = GetUgcBriefInfoRsp.newBuilder();

        proto.setRetcode(ret.getNumber()).setUgcType(unknownEnum1);

        this.setData(proto);
    }

    public PacketGetUgcBriefInfoRsp(UgcMusicBriefInfo briefInfo, UgcType ugcType) {
        super(PacketOpcodes.GetUgcBriefInfoRsp);

        var proto = GetUgcBriefInfoRsp.newBuilder();

        proto.setMusicBriefInfo(briefInfo).setUgcType(ugcType);

        this.setData(proto);
    }
}
