package emu.grasscutter.server.packet.send;
import emu.grasscutter.game.player.Player;
import emu.grasscutter.net.packet.*;

public class PacketHomeAllUnlockedBgmIdListNotify extends BasePacket {
    public PacketHomeAllUnlockedBgmIdListNotify(Player player) {
        super(PacketOpcodes.HomeAllUnlockedBgmIdListNotify);
    }
}
