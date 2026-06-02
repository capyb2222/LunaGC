package emu.grasscutter.server.packet.send;
import emu.grasscutter.game.player.Player;
import emu.grasscutter.net.packet.*;

public class PacketSetPlayerHeadImageRsp extends BasePacket {
    public PacketSetPlayerHeadImageRsp(Player player) {
        super(PacketOpcodes.SetPlayerHeadImageRsp);
    }
}
