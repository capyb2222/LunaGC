package emu.grasscutter.server.packet.send;

import emu.grasscutter.net.packet.*;
import emu.grasscutter.net.proto.*;

public class PacketWidgetCoolDownNotify extends BasePacket {

    public PacketWidgetCoolDownNotify(int id, long coolDownTime, boolean isSuccess) {
        super(PacketOpcodes.WidgetCoolDownNotify);

        WidgetCoolDownNotify proto =
                WidgetCoolDownNotify.newBuilder()
                        .addGroupCoolDownDataList(
                                WidgetCoolDownData.newBuilder()
                                        .setId(id)
                                        .setCoolDownTime(coolDownTime)
                                        .setIsSuccess(isSuccess)
                                        .build())
                        .build();

        this.setData(proto);
    }
}
