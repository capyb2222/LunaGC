package emu.grasscutter.server.packet.send;

import emu.grasscutter.game.player.Player;
import emu.grasscutter.net.packet.*;
import emu.grasscutter.net.proto.HomeResource;
import emu.grasscutter.net.proto.HomeResourceTakeFetterExpRsp;

public class PacketHomeResourceTakeFetterExpRsp extends BasePacket {
    public PacketHomeResourceTakeFetterExpRsp(Player player) {
        super(PacketOpcodes.HomeResourceTakeFetterExpRsp);

        var home = player.getHome();

        home.takeHomeFetter(player);

        var fetterExp =
                HomeResource.newBuilder()
                        .setNextRefreshTime(home.getNextUpdateTime())
                        .setStoreLimit(home.getMaxFetter(home.getLevel()))
                        .setStoreValue(0)
                        .build();

        var proto =
                HomeResourceTakeFetterExpRsp.newBuilder()
                        .setFetterExp(fetterExp)
                        .build();

        this.setData(proto);
    }
}
