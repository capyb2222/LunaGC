package emu.grasscutter.server.packet.recv;

import emu.grasscutter.net.packet.*;
import emu.grasscutter.net.proto.TakeAchievementGoalRewardReq;
import emu.grasscutter.server.game.GameSession;

@Opcodes(PacketOpcodes.TakeAchievementGoalRewardReq)
public class HandlerTakeAchievementGoalRewardReq extends PacketHandler {
    @Override
    public void handle(GameSession session, byte[] header, byte[] payload) throws Exception {
        var req =
                TakeAchievementGoalRewardReq.parseFrom(payload);
        session.getPlayer().getAchievements().takeGoalReward(req.getIdListList());
    }
}
