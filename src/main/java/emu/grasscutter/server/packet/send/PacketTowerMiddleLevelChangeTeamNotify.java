package emu.grasscutter.server.packet.send;
import emu.grasscutter.net.packet.*;

public class PacketTowerMiddleLevelChangeTeamNotify extends BasePacket {
    public PacketTowerMiddleLevelChangeTeamNotify() {
        super(PacketOpcodes.TowerMiddleLevelChangeTeamNotify);
    }
}
