// package emu.grasscutter.server.packet.send;
//
// import emu.grasscutter.net.packet.BasePacket;
// import emu.grasscutter.net.packet.PacketOpcodes;
// import emu.grasscutter.net.proto.MusicBriefInfo;
// import emu.grasscutter.net.proto.MusicBriefInfo;
// import emu.grasscutter.net.proto.MusicBriefInfo;
//
// public class PacketMusicGameSearchBeatmapRsp extends BasePacket {
//
//	public PacketMusicGameSearchBeatmapRsp(int ret,
// MusicGameUnknown1Enum unknownEnum1) {
//		super(PacketOpcodes.MusicGameSearchBeatmapRsp);
//
//        var proto = MusicGameSearchBeatmapRsp.newBuilder();
//
//        proto.setRetcode(ret)
//            .setUnknownEnum1(unknownEnum1);
//
//        this.setData(proto);
//	}
//
//    public PacketMusicGameSearchBeatmapRsp(MusicBriefInfo briefInfo,
// MusicGameUnknown1Enum unknownEnum1) {
//        super(PacketOpcodes.MusicGameSearchBeatmapRsp);
//
//        var proto = MusicGameSearchBeatmapRsp.newBuilder();
//
//        proto.setMusicBriefInfo(briefInfo)
//            .setUnknownEnum1(unknownEnum1);
//
//        this.setData(proto);
//    }
//
//
// }
