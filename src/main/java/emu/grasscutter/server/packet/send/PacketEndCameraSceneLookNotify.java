package emu.grasscutter.server.packet.send;
import emu.grasscutter.net.packet.*;

public class PacketEndCameraSceneLookNotify extends BasePacket {
    public PacketEndCameraSceneLookNotify() {
        super(PacketOpcodes.EndCameraSceneLookNotify);
    }
}
