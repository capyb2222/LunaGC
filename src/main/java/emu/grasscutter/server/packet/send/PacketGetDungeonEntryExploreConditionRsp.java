package emu.grasscutter.server.packet.send;
import emu.grasscutter.net.packet.*;

public class PacketGetDungeonEntryExploreConditionRsp extends BasePacket {
    public PacketGetDungeonEntryExploreConditionRsp(int dungeonId) {
        super(PacketOpcodes.GetDungeonEntryExploreConditionRsp);
    }
}
