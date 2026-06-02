package emu.grasscutter.server.packet.send;
import emu.grasscutter.net.packet.*;
import java.util.Collection;

public class PacketSceneForceUnlockNotify extends BasePacket {
    public PacketSceneForceUnlockNotify(Collection<Integer> unlocked, boolean isAdd) {
        super(PacketOpcodes.SceneForceUnlockNotify);
    }
    public PacketSceneForceUnlockNotify(int unlocked, boolean isAdd) {
        super(PacketOpcodes.SceneForceUnlockNotify);
    }
}
