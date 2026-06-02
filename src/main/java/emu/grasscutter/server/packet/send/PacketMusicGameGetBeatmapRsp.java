// package emu.grasscutter.server.packet.send;
//
// import emu.grasscutter.net.packet.BasePacket;
// import emu.grasscutter.net.packet.PacketOpcodes;
// import emu.grasscutter.net.proto.MusicBeatmap;
// import emu.grasscutter.net.proto.MusicBeatmap;
// import emu.grasscutter.net.proto.MusicBeatmap;
// import emu.grasscutter.net.proto.MusicBeatmap;
//
// public class PacketMusicGameGetBeatmapRsp extends BasePacket {
//
//    public PacketMusicGameGetBeatmapRsp(MusicBriefInfo briefInfo,
// MusicBeatmap musicRecord,
// MusicGameGetBeatmapReq req) {
//        super(PacketOpcodes.MusicGameGetBeatmapRsp);
//
//        var proto = MusicGameGetBeatmapRsp.newBuilder();
//
//        proto.setMusicBriefInfo(briefInfo)
//            .setMusicShareId(briefInfo.getMusicShareId())
//            .setMusicRecord(musicRecord)
//            .setUnknownEnum1(req.getUnknownEnum1())
//            .setReqType(req.getReqType())
//        ;
//
//
//        this.setData(proto);
//    }
// }
