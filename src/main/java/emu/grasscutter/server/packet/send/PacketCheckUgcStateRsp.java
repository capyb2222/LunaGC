package emu.grasscutter.server.packet.send;
import emu.grasscutter.net.packet.*;

public class PacketCheckUgcStateRsp extends BasePacket {
    public PacketCheckUgcStateRsp(Object... args) {
        super(PacketOpcodes.CheckUgcStateRsp);
    }
}
