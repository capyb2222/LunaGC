package emu.grasscutter.server.packet.send;
import emu.grasscutter.net.packet.*;

public class PacketDungeonPlayerDieRsp extends BasePacket {
    public PacketDungeonPlayerDieRsp(Object... args) {
        super(PacketOpcodes.DungeonPlayerDieRsp);
    }
}
