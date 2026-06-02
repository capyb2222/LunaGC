package emu.grasscutter.server.packet.send;

import emu.grasscutter.game.player.Player;
import emu.grasscutter.net.packet.*;
import emu.grasscutter.net.proto.*;
import java.util.List;

public class PacketGetWidgetSlotRsp extends BasePacket {

    public PacketGetWidgetSlotRsp(Player player) {
        super(PacketOpcodes.GetWidgetSlotRsp);

        GetWidgetSlotRsp.Builder proto =
                GetWidgetSlotRsp.newBuilder();

        if (player.getWidgetId()
                == 0) { // TODO: check this logic later, it was null-checking an int before which made it
            // dead code
            proto.addAllSlotList(List.of());
        } else {
            proto.addSlotList(
                    WidgetSlotData.newBuilder()
                            .setIsActive(true)
                            .setMaterialId(player.getWidgetId())
                            .build());

            proto.addSlotList(
                    WidgetSlotData.newBuilder()
                            .setTag(WidgetSlotTag.WIDGET_SLOT_WIDGET_SLOT_ATTACH_AVATAR)
                            .build());
        }

        GetWidgetSlotRsp protoData = proto.build();

        this.setData(protoData);
    }
}
