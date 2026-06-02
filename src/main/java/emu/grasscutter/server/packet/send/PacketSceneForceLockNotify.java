package emu.grasscutter.server.packet.send;
import emu.grasscutter.net.packet.*;
import java.util.Collection;

public class PacketSceneForceLockNotify extends BasePacket {
    public PacketSceneForceLockNotify(Collection<Integer> locked) {
        super(PacketOpcodes.SceneForceLockNotify);
    }
    public PacketSceneForceLockNotify(int locked) {
        super(PacketOpcodes.SceneForceLockNotify);
    }
}
