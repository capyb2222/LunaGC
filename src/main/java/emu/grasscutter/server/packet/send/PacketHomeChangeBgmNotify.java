package emu.grasscutter.server.packet.send;
import emu.grasscutter.net.packet.*;

public class PacketHomeChangeBgmNotify extends BasePacket {
    public PacketHomeChangeBgmNotify(int homeBgmId) {
        super(PacketOpcodes.HomeChangeBgmNotify);
    }
}
