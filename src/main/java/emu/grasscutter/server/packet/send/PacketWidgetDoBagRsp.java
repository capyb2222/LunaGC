package emu.grasscutter.server.packet.send;

import emu.grasscutter.net.packet.*;
import emu.grasscutter.net.proto.WidgetDoBagRsp;

public class PacketWidgetDoBagRsp extends BasePacket {

    public PacketWidgetDoBagRsp(int materialId) {
        super(PacketOpcodes.WidgetDoBagRsp);

        WidgetDoBagRsp proto =
                WidgetDoBagRsp.newBuilder()
                        .setMaterialId(materialId)
                        .setRetcode(0)
                        .build();

        this.setData(proto);
    }

    public PacketWidgetDoBagRsp() {
        super(PacketOpcodes.WidgetDoBagRsp);

        WidgetDoBagRsp proto =
                WidgetDoBagRsp.newBuilder().build();

        this.setData(proto);
    }
}
