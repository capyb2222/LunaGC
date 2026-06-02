package emu.grasscutter.server.packet.send;

import emu.grasscutter.game.player.Player;
import emu.grasscutter.net.packet.*;
import emu.grasscutter.net.proto.*;

public class PacketPlayerHomeCompInfoNotify extends BasePacket {

    public PacketPlayerHomeCompInfoNotify(Player player) {
        super(PacketOpcodes.PlayerHomeCompInfoNotify);

        if (player.getRealmList() == null) {
            // Do not send
            return;
        }

        PlayerHomeCompInfoNotify proto =
                PlayerHomeCompInfoNotify.newBuilder()
                        .setCompInfo(
                                PlayerHomeCompInfo.newBuilder()
                                        .addAllJOMLELGNEOK(player.getRealmList())
                                        .addAllCGACCOHNMAI(player.getHomeRewardedLevels())
                                        .addAllKFAJFCEHAAG(player.getSeenRealmList())
                                        .setFriendEnterHomeOptionValue(player.getHome().getEnterHomeOption())
                                        .build())
                        .build();

        this.setData(proto);
    }
}
