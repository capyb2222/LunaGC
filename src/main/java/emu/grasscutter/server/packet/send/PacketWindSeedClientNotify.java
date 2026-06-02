package emu.grasscutter.server.packet.send;
import emu.grasscutter.net.packet.*;

public class PacketWindSeedClientNotify extends BasePacket {
    public PacketWindSeedClientNotify(String givenPath) {
        super(PacketOpcodes.WindSeedClientNotify);
    }
    public PacketWindSeedClientNotify(byte[] data) {
        super(PacketOpcodes.WindSeedClientNotify);
    }
}
