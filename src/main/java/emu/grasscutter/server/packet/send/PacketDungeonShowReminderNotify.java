package emu.grasscutter.server.packet.send;

import emu.grasscutter.net.packet.*;
import emu.grasscutter.net.proto.DungeonShowReminderNotify;

public class PacketDungeonShowReminderNotify extends BasePacket {

    public PacketDungeonShowReminderNotify(int reminderId) {
        super(PacketOpcodes.DungeonShowReminderNotify);

        var proto = DungeonShowReminderNotify.newBuilder();

        proto.setReminderId(reminderId);

        this.setData(proto);
    }
}
