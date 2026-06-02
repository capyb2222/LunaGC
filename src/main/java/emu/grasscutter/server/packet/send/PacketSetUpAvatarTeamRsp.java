package emu.grasscutter.server.packet.send;

import emu.grasscutter.game.player.*;
import emu.grasscutter.net.packet.*;
import emu.grasscutter.net.proto.SetUpAvatarTeamRsp;

public class PacketSetUpAvatarTeamRsp extends BasePacket {

    public PacketSetUpAvatarTeamRsp(Player player, int teamId, TeamInfo teamInfo) {
        super(PacketOpcodes.SetUpAvatarTeamRsp);

        int maskedTeamId = (teamId + 19529) ^ 63709;
        long maskedCurAvatarGuid = (player.getTeamManager().getCurrentCharacterGuid() + 41090L) ^ 1583L;
        int maskedRetcode = (0 - 51228) ^ 9379;

        SetUpAvatarTeamRsp.Builder proto =
                SetUpAvatarTeamRsp.newBuilder()
                        .setTeamId(maskedTeamId)
                        .setCurAvatarGuid(maskedCurAvatarGuid)
                        .setRetcode(maskedRetcode);

        for (int avatarId : teamInfo.getAvatars()) {
            // avatar_team_guid_list is not masked according to the proto
            proto.addAvatarTeamGuidList(player.getAvatars().getAvatarById(avatarId).getGuid());
        }

        this.setData(proto);
    }
}