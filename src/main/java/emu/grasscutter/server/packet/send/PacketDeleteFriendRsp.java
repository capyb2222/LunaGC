package emu.grasscutter.server.packet.send;
import emu.grasscutter.net.packet.*;

public class PacketDeleteFriendRsp extends BasePacket {
    public PacketDeleteFriendRsp(int targetUid) {
        super(PacketOpcodes.DeleteFriendRsp);
    }
}
