package emu.grasscutter.server.packet.send;
import emu.grasscutter.net.packet.*;
import java.util.Set;

public class PacketDungeonWayPointNotify extends BasePacket {
    public PacketDungeonWayPointNotify(boolean added, Set<Integer> activePointIds) {
        super(PacketOpcodes.DungeonWayPointNotify);
    }
}
