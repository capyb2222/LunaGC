package emu.grasscutter.server.packet.send;

import emu.grasscutter.game.player.Player;
import emu.grasscutter.game.props.PlayerProperty;
import emu.grasscutter.net.packet.*;
import emu.grasscutter.net.proto.BuyResinRsp;

public class PacketBuyResinRsp extends BasePacket {
    public PacketBuyResinRsp(Player player, int ret) {
        super(PacketOpcodes.BuyResinRsp);

        this.setData(
                BuyResinRsp.newBuilder()
                        .setCurValue(player.getProperty(PlayerProperty.PROP_PLAYER_RESIN))
                        .setRetcode(ret)
                        .build());
    }
}
