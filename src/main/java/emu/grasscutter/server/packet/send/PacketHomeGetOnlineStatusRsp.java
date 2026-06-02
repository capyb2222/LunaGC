package emu.grasscutter.server.packet.send;
import emu.grasscutter.net.packet.*;

public class PacketHomeGetOnlineStatusRsp extends BasePacket {
    public PacketHomeGetOnlineStatusRsp(Object... args) {
        super(PacketOpcodes.HomeGetOnlineStatusRsp);
    }
}
