package emu.grasscutter.server.packet.send;
import emu.grasscutter.net.packet.*;

public class PacketGetProfilePictureDataRsp extends BasePacket {
    public PacketGetProfilePictureDataRsp(Object... args) {
        super(PacketOpcodes.GetProfilePictureDataRsp);
    }
}
