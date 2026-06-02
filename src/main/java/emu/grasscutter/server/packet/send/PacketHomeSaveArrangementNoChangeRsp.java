package emu.grasscutter.server.packet.send;

import emu.grasscutter.net.packet.*;
import emu.grasscutter.net.proto.HomeSaveArrangementNoChangeRsp;

public class PacketHomeSaveArrangementNoChangeRsp extends BasePacket {
    public PacketHomeSaveArrangementNoChangeRsp(int sceneId) {
        super(PacketOpcodes.HomeSaveArrangementNoChangeRsp);

        this.setData(
                HomeSaveArrangementNoChangeRsp.newBuilder()
                        .setSceneId(sceneId));
    }
}
