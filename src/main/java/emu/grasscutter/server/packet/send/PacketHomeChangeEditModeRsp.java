package emu.grasscutter.server.packet.send;
import emu.grasscutter.net.packet.*;

public class PacketHomeChangeEditModeRsp extends BasePacket {
    public PacketHomeChangeEditModeRsp(boolean enterEditMode) {
        super(PacketOpcodes.HomeChangeEditModeRsp);
    }
    public PacketHomeChangeEditModeRsp(int retcode) {
        super(PacketOpcodes.HomeChangeEditModeRsp);
    }
}
