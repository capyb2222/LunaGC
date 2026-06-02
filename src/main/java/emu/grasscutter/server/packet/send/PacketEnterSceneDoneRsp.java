package emu.grasscutter.server.packet.send;

import emu.grasscutter.game.player.Player;
import emu.grasscutter.net.packet.*;
import emu.grasscutter.net.proto.EnterSceneDoneRsp;

public class PacketEnterSceneDoneRsp extends BasePacket {

    public PacketEnterSceneDoneRsp(Player player) {
        super(PacketOpcodes.EnterSceneDoneRsp);

        int maskedToken = (player.getEnterSceneToken() ^ 49009) - 34315;

        EnterSceneDoneRsp p =
                EnterSceneDoneRsp.newBuilder().setEnterSceneToken(maskedToken).build();

        this.setData(p);
    }
}