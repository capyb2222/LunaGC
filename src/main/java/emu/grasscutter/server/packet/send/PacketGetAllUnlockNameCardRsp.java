package emu.grasscutter.server.packet.send;
import emu.grasscutter.net.packet.*;

public class PacketGetAllUnlockNameCardRsp extends BasePacket {
    public PacketGetAllUnlockNameCardRsp(Object... args) {
        super(PacketOpcodes.GetAllUnlockNameCardRsp);
    }
}
