package emu.grasscutter.server.packet.send;
import emu.grasscutter.net.packet.*;

public class PacketWindy extends BasePacket {
    public PacketWindy(String givenPath) {
        super(PacketOpcodes.WindSeedType1Notify);
    }
}
