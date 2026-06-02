// package emu.grasscutter.server.packet.send;
//
// import emu.grasscutter.net.packet.BasePacket;
// import emu.grasscutter.net.packet.PacketOpcodes;
// import emu.grasscutter.net.proto.MusicGameCreateBeatmapRsp;
// import emu.grasscutter.net.proto.MusicGameCreateBeatmapRsp;
//
// public class PacketMusicGameCreateBeatmapRsp extends BasePacket {
//
//	public PacketMusicGameCreateBeatmapRsp(long musicShareId,
// MusicGameUnknown1Enum unknownEnum1) {
//		super(PacketOpcodes.MusicGameCreateBeatmapRsp);
//
//        var proto = MusicGameCreateBeatmapRsp.newBuilder();
//
//        proto.setMusicShareId(musicShareId)
//            .setUnknownEnum1(unknownEnum1);
//
//        this.setData(proto);
//	}
// }
