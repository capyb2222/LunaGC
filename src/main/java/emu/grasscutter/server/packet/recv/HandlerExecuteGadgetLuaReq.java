package emu.grasscutter.server.packet.recv;
import emu.grasscutter.net.packet.*;
import emu.grasscutter.server.game.GameSession;

@Opcodes(PacketOpcodes.ExecuteGadgetLuaReq)
public class HandlerExecuteGadgetLuaReq extends PacketHandler {
    @Override
    public void handle(GameSession session, byte[] header, byte[] payload) throws Exception {}
}
