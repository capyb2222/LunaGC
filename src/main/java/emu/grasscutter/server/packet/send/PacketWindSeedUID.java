package emu.grasscutter.server.packet.send;
import emu.grasscutter.net.packet.*;

public class PacketWindSeedUID extends BasePacket {
    public PacketWindSeedUID() {
        super(PacketOpcodes.WindSeedType1Notify);
    }
}
