package emu.grasscutter.server.packet.send;
import emu.grasscutter.net.packet.*;

public class PacketHomeAvatarSummonFinishRsp extends BasePacket {
    public PacketHomeAvatarSummonFinishRsp(int eventId) {
        super(PacketOpcodes.HomeAvatarSummonFinishRsp);
    }
}
