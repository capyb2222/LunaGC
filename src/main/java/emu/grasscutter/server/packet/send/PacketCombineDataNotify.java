package emu.grasscutter.server.packet.send;
import emu.grasscutter.net.packet.*;

public class PacketCombineDataNotify extends BasePacket {
    public PacketCombineDataNotify(Iterable<Integer> unlockedCombines) {
        super(PacketOpcodes.CombineDataNotify);
    }
}
