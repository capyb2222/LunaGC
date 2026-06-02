package emu.grasscutter.server.packet.recv;
import emu.grasscutter.net.packet.*;
import emu.grasscutter.server.game.GameSession;

@Opcodes(PacketOpcodes.HomeModuleSeenReq)
public class HandlerHomeModuleSeenReq extends PacketHandler {
    @Override
    public void handle(GameSession session, byte[] header, byte[] payload) throws Exception {}
}
