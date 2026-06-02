package emu.grasscutter.server.packet.send;

import emu.grasscutter.net.packet.*;
import emu.grasscutter.net.proto.*;
import java.util.List;

public class PacketTakeAchievementGoalRewardRsp extends BasePacket {
    public PacketTakeAchievementGoalRewardRsp() {
        super(PacketOpcodes.TakeAchievementGoalRewardRsp);
        this.setData(
                TakeAchievementGoalRewardRsp.newBuilder()
                        .setRetcode(Retcode.RET_REWARD_HAS_TAKEN_VALUE)
                        .build());
    }

    public PacketTakeAchievementGoalRewardRsp(
            List<Integer> ids, List<ItemParam> items) {
        super(PacketOpcodes.TakeAchievementGoalRewardRsp);

        var rsp =
                TakeAchievementGoalRewardRsp.newBuilder()
                        .addAllIdList(ids)
                        .addAllItemList(items)
                        .build();

        this.setData(rsp);
    }
}
