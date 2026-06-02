package emu.grasscutter.server.packet.send;
import emu.grasscutter.net.packet.*;

public class PacketShowClientGuideNotify extends BasePacket {
    public PacketShowClientGuideNotify(String guideName) {
        super(PacketOpcodes.ShowClientGuideNotify);
    }
}
