package emu.grasscutter.server.packet.recv;

import emu.grasscutter.net.packet.*;
import emu.grasscutter.net.proto.GetInvestigationMonsterReq;
import emu.grasscutter.server.game.GameSession;
import emu.grasscutter.server.packet.send.PacketGetInvestigationMonsterRsp;

@Opcodes(PacketOpcodes.GetInvestigationMonsterReq)
public class HandlerGetInvestigationMonsterReq extends PacketHandler {

    @Override
    public void handle(GameSession session, byte[] header, byte[] payload) throws Exception {
        var req = GetInvestigationMonsterReq.parseFrom(payload);

        session.send(
                new PacketGetInvestigationMonsterRsp(
                        session.getPlayer(),
                        session.getServer().getWorldDataSystem(),
                        req.getCityIdListList()));
    }
}
