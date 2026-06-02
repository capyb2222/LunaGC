package emu.grasscutter.server.packet.send;

import emu.grasscutter.net.packet.*;
import emu.grasscutter.net.proto.ActivityTakeWatcherRewardRsp;

public class PacketActivityTakeWatcherRewardRsp extends BasePacket {

    public PacketActivityTakeWatcherRewardRsp(int activityId, int watcherId) {
        super(PacketOpcodes.ActivityTakeWatcherRewardRsp);

        var proto = ActivityTakeWatcherRewardRsp.newBuilder();

        proto.setActivityId(activityId).setWatcherId(watcherId);

        this.setData(proto);
    }
}
