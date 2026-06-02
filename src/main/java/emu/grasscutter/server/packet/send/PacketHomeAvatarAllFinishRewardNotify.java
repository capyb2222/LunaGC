package emu.grasscutter.server.packet.send;
import emu.grasscutter.game.player.Player;
import emu.grasscutter.net.packet.*;

public class PacketHomeAvatarAllFinishRewardNotify extends BasePacket {
    public PacketHomeAvatarAllFinishRewardNotify(Player player) {
        super(PacketOpcodes.HomeAvatarAllFinishRewardNotify);
    }
}
