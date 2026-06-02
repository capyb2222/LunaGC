package emu.grasscutter.server.packet.send;

import emu.grasscutter.net.packet.*;
import emu.grasscutter.net.proto.TowerFloorRecordChangeNotify;
import emu.grasscutter.net.proto.TowerFloorRecord;
import emu.grasscutter.net.proto.TowerLevelRecord;

public class PacketTowerFloorRecordChangeNotify extends BasePacket {

    public PacketTowerFloorRecordChangeNotify(int floorId, int stars, boolean canEnterScheduleFloor) {
        super(PacketOpcodes.TowerFloorRecordChangeNotify);

        TowerFloorRecordChangeNotify proto =
                TowerFloorRecordChangeNotify.newBuilder()
                        .addTowerFloorRecordList(
                                TowerFloorRecord.newBuilder()
                                        .setFloorId(floorId)
                                        .setFloorStarRewardProgress(stars)
                                        .addPassedLevelRecordList(
                                                TowerLevelRecord.newBuilder()
                                                        .setLevelId(1)
                                                        //.addSatisfiedCondList(1)
                                                        //.addSatisfiedCondList(2)
                                                        //.addSatisfiedCondList(3)
                                                        .build())
                                        .build())
                        .setIsFinishedEntranceFloor(canEnterScheduleFloor)
                        .build();

        this.setData(proto);
    }
}
