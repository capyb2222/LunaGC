package emu.grasscutter.server.packet.send;

import emu.grasscutter.net.packet.*;
import emu.grasscutter.net.proto.*;

public class PacketMusicGameSettleRsp extends BasePacket {

    public PacketMusicGameSettleRsp(int musicBasicId, long musicShareId, boolean isNewRecord) {
        super(PacketOpcodes.MusicGameSettleRsp);

        var proto = MusicGameSettleRsp.newBuilder();

        proto.setMusicBasicId(musicBasicId).setUgcGuid(musicShareId).setIsNewRecord(isNewRecord);

        this.setData(proto);
    }

    public PacketMusicGameSettleRsp(
            Retcode errorCode, FleurFairMusicGameSettleReq req) {
        super(PacketOpcodes.MusicGameSettleRsp);

        var proto =
                MusicGameSettleRsp.newBuilder()
                        .setRetcode(errorCode.getNumber())
                        .setMusicBasicId(req.getMusicBasicId());

        this.setData(proto);
    }
}
