package emu.grasscutter.server.packet.send;

import emu.grasscutter.net.packet.*;
import emu.grasscutter.net.proto.FleurFairMusicGameStartRsp;

public class PacketMusicGameStartRsp extends BasePacket {

    public PacketMusicGameStartRsp(int musicBasicId, long musicShareId) {
        super(PacketOpcodes.FleurFairMusicGameStartRsp);

        var proto = FleurFairMusicGameStartRsp.newBuilder();

        proto.setMusicBasicId(musicBasicId);

        this.setData(proto);
    }
}
