package emu.grasscutter.server.packet.send;

import emu.grasscutter.net.packet.*;
import emu.grasscutter.net.proto.AddQuestContentProgressRsp;

public class PacketAddQuestContentProgressRsp extends BasePacket {

    public PacketAddQuestContentProgressRsp(int contentType) {
        super(PacketOpcodes.AddQuestContentProgressRsp);

        var proto = AddQuestContentProgressRsp.newBuilder();

        proto.setContentType(contentType);

        this.setData(proto);
    }
}
