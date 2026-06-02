package emu.grasscutter.server.packet.send;

import emu.grasscutter.net.packet.*;
import emu.grasscutter.net.proto.SetWidgetSlotRsp;

public class PacketSetWidgetSlotRsp extends BasePacket {

    public PacketSetWidgetSlotRsp(int materialId) {
        super(PacketOpcodes.SetWidgetSlotRsp);

        SetWidgetSlotRsp proto =
                SetWidgetSlotRsp.newBuilder().setMaterialId(materialId).build();

        this.setData(proto);
    }
}
