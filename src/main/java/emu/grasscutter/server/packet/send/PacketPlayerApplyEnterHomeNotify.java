package emu.grasscutter.server.packet.send;
import emu.grasscutter.game.player.Player;
import emu.grasscutter.net.packet.*;

public class PacketPlayerApplyEnterHomeNotify extends BasePacket {
    public PacketPlayerApplyEnterHomeNotify(Player requester) {
        super(PacketOpcodes.PlayerApplyEnterHomeNotify);
    }
}
