package emu.grasscutter.server.packet.send;
import emu.grasscutter.net.packet.*;

public class PacketHomePreChangeEditModeNotify extends BasePacket {
    public PacketHomePreChangeEditModeNotify(boolean isEnterEditMode) {
        super(PacketOpcodes.HomePreChangeEditModeNotify);
    }
}
