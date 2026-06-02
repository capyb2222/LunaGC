package emu.grasscutter.server.packet.send;
import emu.grasscutter.net.packet.*;

public class PacketDungeonSlipRevivePointActivateRsp extends BasePacket {
    public PacketDungeonSlipRevivePointActivateRsp(boolean success, int pointId) {
        super(PacketOpcodes.DungeonSlipRevivePointActivateRsp);
    }
}
