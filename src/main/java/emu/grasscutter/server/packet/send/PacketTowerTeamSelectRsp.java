package emu.grasscutter.server.packet.send;
import emu.grasscutter.net.packet.*;

public class PacketTowerTeamSelectRsp extends BasePacket {
    public PacketTowerTeamSelectRsp() {
        super(PacketOpcodes.TowerTeamSelectRsp);
    }
}
