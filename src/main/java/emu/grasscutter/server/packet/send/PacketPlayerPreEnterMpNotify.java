package emu.grasscutter.server.packet.send;

import emu.grasscutter.game.player.Player;
import emu.grasscutter.net.packet.*;
import emu.grasscutter.net.proto.PlayerPreEnterMpNotify;

// REMOVED IN 6.6: State

public class PacketPlayerPreEnterMpNotify extends BasePacket {
    public PacketPlayerPreEnterMpNotify(Player player) {
        super(PacketOpcodes.PlayerPreEnterMpNotify);

        this.setData(
                PlayerPreEnterMpNotify.newBuilder()
                        .setUid(player.getUid())
                        .setNickname(player.getNickname())
                        .setState(PlayerPreEnterMpNotify.State.START));
    }
}
