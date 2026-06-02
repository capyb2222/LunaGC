package emu.grasscutter.game.dungeons.dungeon_results;

import emu.grasscutter.data.excels.dungeon.DungeonData;
import emu.grasscutter.game.dungeons.DungeonEndStats;
import emu.grasscutter.net.proto.DungeonSettleNotify;
import emu.grasscutter.net.proto.TrialAvatarFirstPassDungeonNotify;

public class TrialAvatarDungeonResult extends BaseDungeonResult {
    int trialCharacterIndexId;

    public TrialAvatarDungeonResult(
            DungeonData dungeonData, DungeonEndStats dungeonStats, int trialCharacterIndexId) {
        super(dungeonData, dungeonStats);
        this.trialCharacterIndexId = trialCharacterIndexId;
    }

    @Override
    protected void onProto(DungeonSettleNotify.Builder builder) {
        if (dungeonStats.getDungeonResult()
                == DungeonEndReason.COMPLETED) { // TODO check if its the first pass(?)
            builder.setTrialAvatarFirstPassDungeonNotify(
                    TrialAvatarFirstPassDungeonNotify.newBuilder()
                            .setTrialAvatarIndexId(trialCharacterIndexId));
        }
    }
}
