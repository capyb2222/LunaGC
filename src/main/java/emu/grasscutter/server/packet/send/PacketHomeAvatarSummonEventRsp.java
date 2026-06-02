package emu.grasscutter.server.packet.send;
import emu.grasscutter.game.home.suite.event.HomeAvatarSummonEvent;
import emu.grasscutter.net.packet.*;

public class PacketHomeAvatarSummonEventRsp extends BasePacket {
    public PacketHomeAvatarSummonEventRsp(HomeAvatarSummonEvent event) {
        super(PacketOpcodes.HomeAvatarSummonEventRsp);
    }
    public PacketHomeAvatarSummonEventRsp(int retcode) {
        super(PacketOpcodes.HomeAvatarSummonEventRsp);
    }
}
