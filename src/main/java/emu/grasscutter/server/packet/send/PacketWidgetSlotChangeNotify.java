package emu.grasscutter.server.packet.send;

import emu.grasscutter.net.packet.*;
import emu.grasscutter.net.proto.*;

public class PacketWidgetSlotChangeNotify extends BasePacket {

    public PacketWidgetSlotChangeNotify(
            WidgetSlotChangeNotify proto) {
        super(PacketOpcodes.WidgetSlotChangeNotify);

        this.setData(proto);
    }

    public PacketWidgetSlotChangeNotify(WidgetSlotOp op) {
        super(PacketOpcodes.WidgetSlotChangeNotify);

        WidgetSlotChangeNotify proto =
                WidgetSlotChangeNotify.newBuilder()
                        .setOp(op)
                        .setSlot(WidgetSlotData.newBuilder().setIsActive(true).build())
                        .build();

        this.setData(proto);
    }

    public PacketWidgetSlotChangeNotify(int materialId) {
        super(PacketOpcodes.WidgetSlotChangeNotify);

        WidgetSlotChangeNotify proto =
                WidgetSlotChangeNotify.newBuilder()
                        .setSlot(
                                WidgetSlotData.newBuilder()
                                        .setIsActive(true)
                                        .setMaterialId(materialId)
                                        .build())
                        .build();

        this.setData(proto);
    }
}
