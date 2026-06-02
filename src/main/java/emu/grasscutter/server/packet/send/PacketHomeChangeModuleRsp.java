package emu.grasscutter.server.packet.send;
import emu.grasscutter.net.packet.*;

public class PacketHomeChangeModuleRsp extends BasePacket {
    public PacketHomeChangeModuleRsp(int targetModuleId) {
        super(PacketOpcodes.HomeChangeModuleRsp);
    }
    public PacketHomeChangeModuleRsp() {
        super(PacketOpcodes.HomeChangeModuleRsp);
    }
}
