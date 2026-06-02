package emu.grasscutter.server.packet.send;
import emu.grasscutter.net.packet.*;

public class PacketHomeChangeBgmRsp extends BasePacket {
    public PacketHomeChangeBgmRsp() {
        super(PacketOpcodes.HomeChangeBgmRsp);
    }
}
