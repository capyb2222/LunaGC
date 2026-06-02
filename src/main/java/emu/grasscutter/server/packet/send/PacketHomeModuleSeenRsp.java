package emu.grasscutter.server.packet.send;
import emu.grasscutter.net.packet.*;

public class PacketHomeModuleSeenRsp extends BasePacket {
    public PacketHomeModuleSeenRsp(Object... args) {
        super(PacketOpcodes.HomeModuleSeenRsp);
    }
}
