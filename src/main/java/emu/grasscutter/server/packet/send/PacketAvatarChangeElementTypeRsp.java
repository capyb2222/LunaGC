package emu.grasscutter.server.packet.send;
import emu.grasscutter.net.packet.*;

public class PacketAvatarChangeElementTypeRsp extends BasePacket {
    public PacketAvatarChangeElementTypeRsp() {
        super(PacketOpcodes.AvatarChangeElementTypeRsp);
    }
    public PacketAvatarChangeElementTypeRsp(int retcode) {
        super(PacketOpcodes.AvatarChangeElementTypeRsp);
    }
}
