package emu.grasscutter.game.dungeons.dungeon_results;

import emu.grasscutter.data.excels.dungeon.DungeonData;
import emu.grasscutter.game.dungeons.DungeonEndStats;
import emu.grasscutter.game.dungeons.challenge.WorldChallenge;
import emu.grasscutter.game.tower.TowerManager;
import emu.grasscutter.net.proto.*;
import emu.grasscutter.net.proto.TowerLevelEndNotify;

public class TowerResult extends BaseDungeonResult {
    WorldChallenge challenge;
    boolean canJump;
    boolean hasNextLevel;
    int nextFloorId;
    int currentStars;

    public TowerResult(
            DungeonData dungeonData,
            DungeonEndStats dungeonStats,
            TowerManager towerManager,
            WorldChallenge challenge,
            int currentStars) {
        super(dungeonData, dungeonStats);
        this.challenge = challenge;
        this.canJump = towerManager.hasNextFloor();
        this.hasNextLevel = towerManager.hasNextLevel();
        this.nextFloorId = hasNextLevel ? 0 : towerManager.getNextFloorId();
        this.currentStars = currentStars;
    }

    @Override
    protected void onProto(DungeonSettleNotify.Builder builder) {
        // ContinueStateType enum removed in 6.6; use raw int: 0=cannot, 1=next level, 2=next floor
        int continueStatus = 0;
        if (challenge.isSuccess()) {
            if (hasNextLevel) {
                continueStatus = 1;
            } else if (canJump) {
                continueStatus = 2;
            }
        }

        var towerLevelEndNotify =
                TowerLevelEndNotify.newBuilder()
                        .setIsSuccess(challenge.isSuccess())
                        .addRewardItemList(
                                ItemParam.newBuilder().setItemId(201).setCount(1000));

        for (int i = 1; i <= currentStars; i++) {
            towerLevelEndNotify.addFinishedStarCondList(i);
        }

        builder.setTowerLevelEndNotify(towerLevelEndNotify.build());
    }
}
