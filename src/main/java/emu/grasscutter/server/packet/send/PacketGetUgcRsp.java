package emu.grasscutter.server.packet.send;

import emu.grasscutter.net.packet.*;
import emu.grasscutter.net.proto.GetUgcReq;
import emu.grasscutter.net.proto.GetUgcRsp;
import emu.grasscutter.net.proto.Retcode;
import emu.grasscutter.net.proto.UgcMusicBriefInfo;
import emu.grasscutter.net.proto.UgcMusicRecord;

public class PacketGetUgcRsp extends BasePacket {

    public PacketGetUgcRsp(UgcMusicBriefInfo briefInfo, UgcMusicRecord musicRecord, GetUgcReq req) {
        super(PacketOpcodes.GetUgcRsp);

        var proto = GetUgcRsp.newBuilder();

        proto
                .setUgcGuid(briefInfo.getUgcGuid())
                .setUgcType(req.getUgcType())
                .setUgcRecordUsageValue(req.getUgcRecordUsageValue())
                .setMusicRecord(musicRecord)
                .setMusicBriefInfo(briefInfo);

        this.setData(proto);
    }

    public PacketGetUgcRsp(Retcode errorCode, GetUgcReq req) {
        super(PacketOpcodes.GetUgcRsp);

        var proto = GetUgcRsp.newBuilder();

        proto
                .setUgcGuid(req.getUgcGuid())
                .setUgcType(req.getUgcType())
                .setUgcRecordUsageValue(req.getUgcRecordUsageValue())
                .setRetcode(errorCode.getNumber());

        this.setData(proto);
    }
}
