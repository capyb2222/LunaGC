package emu.grasscutter.server.packet.send;
import emu.grasscutter.net.packet.*;

public class PacketDeleteFriendNotify extends BasePacket {
    public PacketDeleteFriendNotify(int targetUid) {
        super(PacketOpcodes.DeleteFriendNotify);
    }
}
