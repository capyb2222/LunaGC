package emu.grasscutter.server.packet.send;
import emu.grasscutter.net.packet.*;

public class PacketFireworkSetRsp extends BasePacket {
    public PacketFireworkSetRsp() {
        super(PacketOpcodes.ReformFireworksRsp);
    }
}
