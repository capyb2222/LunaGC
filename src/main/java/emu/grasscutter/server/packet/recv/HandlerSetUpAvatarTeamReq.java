package emu.grasscutter.server.packet.recv;

import emu.grasscutter.net.packet.*;
import emu.grasscutter.net.proto.SetUpAvatarTeamReq;
import emu.grasscutter.server.game.GameSession;

@Opcodes(PacketOpcodes.SetUpAvatarTeamReq)
public class HandlerSetUpAvatarTeamReq extends PacketHandler {

    @Override
    public void handle(GameSession session, byte[] header, byte[] payload) throws Exception {
        SetUpAvatarTeamReq req = SetUpAvatarTeamReq.parseFrom(payload);

        int teamId = (req.getTeamId() ^ 63709) - 19529;
        long curAvatarGuid = (req.getCurAvatarGuid() ^ 1583L) - 41090L;

        session
                .getPlayer()
                .getTeamManager()
                .setupAvatarTeam(teamId, req.getAvatarTeamGuidListList());
    }
}