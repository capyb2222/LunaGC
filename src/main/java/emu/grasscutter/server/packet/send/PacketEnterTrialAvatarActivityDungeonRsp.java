package emu.grasscutter.server.packet.send;

import emu.grasscutter.net.packet.*;
import emu.grasscutter.net.proto.EnterTrialAvatarActivityDungeonRsp;
import emu.grasscutter.net.proto.Retcode;

public class PacketEnterTrialAvatarActivityDungeonRsp extends BasePacket {

    public PacketEnterTrialAvatarActivityDungeonRsp(
            int activityId, int trialAvatarIndexId, boolean success) {
        this(
                activityId,
                trialAvatarIndexId,
                success
                        ? Retcode.RET_SUCC_VALUE
                        : Retcode.RET_FAIL_VALUE);
    }

    public PacketEnterTrialAvatarActivityDungeonRsp(
            int activityId, int trialAvatarIndexId, int retcodeVal) {
        super(PacketOpcodes.EnterTrialAvatarActivityDungeonRsp);
        this.setData(
                EnterTrialAvatarActivityDungeonRsp.newBuilder()
                        .setActivityId(activityId)
                        .setTrialAvatarIndexId(trialAvatarIndexId)
                        .setRetcode(retcodeVal));
    }
}
