package emu.grasscutter.server.packet.send;

import emu.grasscutter.game.achievement.Achievement;
import emu.grasscutter.game.player.Player;
import emu.grasscutter.net.packet.*;
import emu.grasscutter.net.proto.AchievementAllDataNotify;

public class PacketAchievementAllDataNotify extends BasePacket {
    public PacketAchievementAllDataNotify(Player player) {
        super(PacketOpcodes.AchievementAllDataNotify);

        var achievements = player.getAchievements();
        var notify =
                AchievementAllDataNotify.newBuilder()
                        .addAllAchievementList(
                                achievements.getAchievementList().values().stream()
                                        .map(Achievement::toProto)
                                        .toList())
                        .addAllRewardTakenGoalIdList(achievements.getTakenGoalRewardIdList())
                        .build();

        this.setData(notify);
    }
}
