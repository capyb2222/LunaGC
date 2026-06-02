package emu.grasscutter.server.packet.send;
import emu.grasscutter.net.packet.*;

public class PacketBackMyWorldRsp extends BasePacket {
    public PacketBackMyWorldRsp(int retcode) {
        super(PacketOpcodes.BackMyWorldRsp);
    }
}
