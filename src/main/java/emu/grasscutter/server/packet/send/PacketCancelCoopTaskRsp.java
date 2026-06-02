package emu.grasscutter.server.packet.send;

import emu.grasscutter.net.packet.*;
import emu.grasscutter.net.proto.CancelCoopTaskRsp;

public class PacketCancelCoopTaskRsp extends BasePacket {

    public PacketCancelCoopTaskRsp(int chapterId) {
        super(PacketOpcodes.SetCoopChapterViewedRsp);

        CancelCoopTaskRsp proto =
                CancelCoopTaskRsp.newBuilder().setChapterId(chapterId).build();

        this.setData(proto);
    }
}
