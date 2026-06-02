package emu.grasscutter.server.packet.send;
import emu.grasscutter.net.packet.*;

public class PacketDungeonWayPointActivateRsp extends BasePacket {
    public PacketDungeonWayPointActivateRsp(boolean success, int pointId) {
        super(PacketOpcodes.DungeonWayPointActivateRsp);
    }
}
