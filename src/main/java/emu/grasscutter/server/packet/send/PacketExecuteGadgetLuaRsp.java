package emu.grasscutter.server.packet.send;
import emu.grasscutter.net.packet.*;

public class PacketExecuteGadgetLuaRsp extends BasePacket {
    public PacketExecuteGadgetLuaRsp(int result) {
        super(PacketOpcodes.ExecuteGadgetLuaRsp);
    }
}
