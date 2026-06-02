package emu.grasscutter.server.packet.send;

import emu.grasscutter.net.packet.*;
import emu.grasscutter.net.proto.UnlockedFurnitureSuiteDataNotify;
import java.util.Set;

public class PacketUnlockedFurnitureSuiteDataNotify extends BasePacket {

    public PacketUnlockedFurnitureSuiteDataNotify(Set<Integer> unlockList) {
        super(PacketOpcodes.UnlockedFurnitureSuiteDataNotify);

        var proto =
                UnlockedFurnitureSuiteDataNotify.newBuilder();

        proto.addAllFurnitureSuiteIdList(unlockList);
        proto.setIsAll(true);

        this.setData(proto);
    }
}
