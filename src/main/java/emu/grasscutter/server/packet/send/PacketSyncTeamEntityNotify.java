package emu.grasscutter.server.packet.send;

import emu.grasscutter.game.player.Player;
import emu.grasscutter.net.packet.*;
import emu.grasscutter.utils.Utils;
import emu.grasscutter.net.proto.AbilityScalarValueEntry;
import emu.grasscutter.net.proto.AbilityString;
import emu.grasscutter.net.proto.AbilitySyncStateInfo;
import emu.grasscutter.net.proto.SyncTeamEntityNotify;
import emu.grasscutter.net.proto.TeamEntityInfo;

// REMOVED IN 6.6: AbilityScalarType

public class PacketSyncTeamEntityNotify extends BasePacket {

    public PacketSyncTeamEntityNotify(Player player) {
        super(PacketOpcodes.SyncTeamEntityNotify);

        AbilityScalarValueEntry scalarValue = AbilityScalarValueEntry.newBuilder()
                .setKey(AbilityString.newBuilder().setHash(Utils.abilityHash("SGV_PlayerTeam_Phlogiston"))
                        .setStr("SGV_PlayerTeam_Phlogiston")
                        .build())
                .setFloatValue(player.getPhlogistonValue())
                .build();
        AbilitySyncStateInfo phlogiston = AbilitySyncStateInfo.newBuilder().addSgvDynamicValueMap(scalarValue).build();

        SyncTeamEntityNotify.Builder proto =
                SyncTeamEntityNotify.newBuilder().setSceneId(player.getSceneId());

        if (player.getWorld().isMultiplayer()) {
            for (var p : player.getWorld()) {
                // Skip if same player
                if (player == p) {
                    continue;
                }

                // Set info
                TeamEntityInfo info =
                        TeamEntityInfo.newBuilder()
                                .setTeamEntityId(p.getTeamManager().getEntity().getId())
                                .setAuthorityPeerId(p.getPeerId())
                                .setTeamAbilityInfo(phlogiston)
                                .build();

                proto.addTeamEntityInfoList(info);
            }
        }

        this.setData(proto);
    }
}
