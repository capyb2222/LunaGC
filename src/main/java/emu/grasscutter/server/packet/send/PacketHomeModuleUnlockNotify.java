package emu.grasscutter.server.packet.send;
import emu.grasscutter.net.packet.*;

public class PacketHomeModuleUnlockNotify extends BasePacket {
    public PacketHomeModuleUnlockNotify(int targetModuleId) {
        super(PacketOpcodes.HomeModuleUnlockNotify);
    }
}
