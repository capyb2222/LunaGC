package emu.grasscutter.server.packet.send;

import emu.grasscutter.game.tower.*;
import emu.grasscutter.net.packet.*;
import emu.grasscutter.net.proto.TowerAllDataRsp;
import emu.grasscutter.net.proto.TowerCurLevelRecord;
import emu.grasscutter.net.proto.TowerFloorRecord;
import emu.grasscutter.net.proto.TowerLevelRecord;
import emu.grasscutter.utils.helpers.DateHelper;
import java.util.*;
import java.util.stream.*;

public class PacketTowerAllDataRsp extends BasePacket {

    public PacketTowerAllDataRsp(TowerSystem towerScheduleManager, TowerManager towerManager) {
        super(PacketOpcodes.TowerAllDataRsp);

        var recordList =
                towerManager.getRecordMap().values().stream()
                        .map(
                                rec ->
                                        TowerFloorRecord.newBuilder()
                                                .setFloorId(rec.getFloorId())
                                                .setFloorStarRewardProgress(rec.getFloorStarRewardProgress())
                                                .putAllPassedLevelMap(rec.getPassedLevelMap())
                                                .addAllPassedLevelRecordList(
                                                        buildFromPassedLevelMap(rec.getPassedLevelMap()))
                                                .build())
                        .toList();

        var openTimeMap =
                towerScheduleManager.getScheduleFloors().stream()
                        .collect(
                                Collectors.toMap(
                                        x -> x,
                                        y ->
                                                DateHelper.getUnixTime(
                                                        towerScheduleManager.getTowerScheduleConfig().getScheduleStartTime())));

        TowerAllDataRsp proto =
                TowerAllDataRsp.newBuilder()
                        .setTowerScheduleId(towerScheduleManager.getCurrentTowerScheduleData().getScheduleId())
                        .addAllTowerFloorRecordList(recordList)
                        //.setCurLevelRecord(TowerCurLevelRecord.newBuilder().setIsEmpty(true))
                        //.setScheduleStartTime(
                        //        DateHelper.getUnixTime(
                        //                towerScheduleManager.getTowerScheduleConfig().getScheduleStartTime()))
                        .setNextScheduleChangeTime(
                                DateHelper.getUnixTime(
                                        towerScheduleManager.getTowerScheduleConfig().getNextScheduleChangeTime()))
                        //.putAllFloorOpenTimeMap(openTimeMap)
                        .setIsFinishedEntranceFloor(towerManager.canEnterScheduleFloor())
                        .build();

        this.setData(proto);
    }

    private List<TowerLevelRecord> buildFromPassedLevelMap(
            Map<Integer, Integer> map) {
        return map.entrySet().stream()
                .map(
                        item ->
                                TowerLevelRecord.newBuilder()
                                        .setLevelId(item.getKey())
                                        //.addAllSatisfiedCondList(
                                        //        IntStream.range(1, item.getValue() + 1).boxed().toList())
                                        .build())
                .toList();
    }
}
