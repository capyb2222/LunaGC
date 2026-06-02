package emu.grasscutter.server.packet.send;
import emu.grasscutter.game.friends.Friendship;
import emu.grasscutter.net.packet.*;

public class PacketAskAddFriendNotify extends BasePacket {
    public PacketAskAddFriendNotify(Friendship friendship) {
        super(PacketOpcodes.AskAddFriendNotify);
    }
}
