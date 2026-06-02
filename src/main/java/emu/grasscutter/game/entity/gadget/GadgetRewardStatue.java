package emu.grasscutter.game.entity.gadget;

import emu.grasscutter.game.dungeons.challenge.WorldChallenge;
import emu.grasscutter.game.entity.EntityGadget;
import emu.grasscutter.game.player.Player;
import emu.grasscutter.net.proto.GadgetInteractReq;
import emu.grasscutter.net.proto.InteractType;
import emu.grasscutter.net.proto.ResinCostType;
import emu.grasscutter.net.proto.SceneGadgetInfo;
import emu.grasscutter.server.packet.send.PacketGadgetInteractRsp;

public final class GadgetRewardStatue extends GadgetContent {

    public GadgetRewardStatue(EntityGadget gadget) {
        super(gadget);
    }

    public boolean onInteract(Player player, GadgetInteractReq req) {
        var dungeonManager = player.getScene().getDungeonManager();

        if (player.getScene().getChallenge() instanceof WorldChallenge) {
            var useCondensed =
                    req.getResinCostType() == ResinCostType.RESIN_COST_TYPE_CONDENSE;
            dungeonManager.getStatueDrops(player, useCondensed, getGadget().getGroupId());
        }

        player.sendPacket(
                new PacketGadgetInteractRsp(getGadget(), InteractType.INTERACT_OPEN_STATUE));

        return false;
    }

    public void onBuildProto(SceneGadgetInfo.Builder gadgetInfo) {}
}
