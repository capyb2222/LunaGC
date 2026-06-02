package emu.grasscutter.server.packet.send;
import emu.grasscutter.net.packet.*;

public class PacketDungeonEntryToBeExploreNotify extends BasePacket {
    public PacketDungeonEntryToBeExploreNotify() {
        super(PacketOpcodes.DungeonEntryToBeExploreNotify);
    }
}
