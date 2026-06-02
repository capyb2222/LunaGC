package emu.grasscutter.server.packet.send;
import emu.grasscutter.net.packet.*;

public class PacketSkipPlayerGameTimeRsp extends BasePacket {
    public PacketSkipPlayerGameTimeRsp(byte[] payload) {
        super(PacketOpcodes.SkipPlayerGameTimeRsp);
    }
    public PacketSkipPlayerGameTimeRsp() {
        super(PacketOpcodes.SkipPlayerGameTimeRsp);
    }
}
