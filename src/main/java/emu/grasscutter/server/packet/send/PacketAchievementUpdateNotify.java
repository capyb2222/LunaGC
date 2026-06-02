package emu.grasscutter.server.packet.send;

import emu.grasscutter.game.achievement.Achievement;
import emu.grasscutter.net.packet.*;
import emu.grasscutter.net.proto.AchievementUpdateNotify;
import java.util.List;

public class PacketAchievementUpdateNotify extends BasePacket {
    public PacketAchievementUpdateNotify(List<Achievement> achievements) {
        super(PacketOpcodes.AchievementUpdateNotify);

        var notify =
                AchievementUpdateNotify.newBuilder()
                        .addAllAchievementList(achievements.stream().map(Achievement::toProto).toList())
                        .build();

        this.setData(notify);
    }
}
