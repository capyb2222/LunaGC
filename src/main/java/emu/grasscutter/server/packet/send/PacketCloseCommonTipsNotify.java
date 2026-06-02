package emu.grasscutter.server.packet.send;
import emu.grasscutter.net.packet.*;

public class PacketCloseCommonTipsNotify extends BasePacket {
    public PacketCloseCommonTipsNotify() {
        super(PacketOpcodes.CloseCommonTipsNotify);
    }
}
