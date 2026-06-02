package emu.grasscutter.game.ability.actions;

import com.google.protobuf.ByteString;
import emu.grasscutter.Grasscutter;
import emu.grasscutter.data.binout.AbilityModifier.AbilityModifierAction;
import emu.grasscutter.game.ability.Ability;
import emu.grasscutter.game.avatar.Avatar;
import emu.grasscutter.game.props.EntityIdType;
import emu.grasscutter.game.props.FightProperty;
import emu.grasscutter.game.managers.stamina.Consumption;
import emu.grasscutter.game.managers.stamina.ConsumptionType;
import emu.grasscutter.server.game.GameSession;
import emu.grasscutter.game.managers.stamina.StaminaManager;
import emu.grasscutter.net.proto._ChangeHpDebtsReason;
import emu.grasscutter.net.proto._ChangeHpDebtsReason;
import emu.grasscutter.server.packet.send.PacketEntityFightPropChangeReasonNotify;
import emu.grasscutter.server.packet.send.PacketEntityFightPropUpdateNotify;
import emu.grasscutter.game.entity.*;
import emu.grasscutter.game.quest.enums.QuestContent;

@AbilityAction(AbilityModifierAction.Type.AvatarSkillStart)
public class ActionAvatarSkillStart extends AbilityActionHandler {
    @Override
    public boolean execute(
            Ability ability, AbilityModifierAction action, ByteString abilityData, GameEntity target) {
        var owner = ability.getOwner();
        float costStaminaRatio = action.costStaminaRatio.get(ability);
        Grasscutter.getLogger().info("Ratio: {}", costStaminaRatio);

        
        if (costStaminaRatio != 1.0f && costStaminaRatio != 0.0f) {
            var player = ability.getPlayerOwner();
            if (player != null) {
                StaminaManager staminaManager = player.getStaminaManager();
                GameSession session = player.getSession();

                // Convert the RATIO to INTERNAL stamina value (displayed value × 100)
                int staminaCost = (int) (costStaminaRatio * 100); // e.g., 20.0 → 2000 internal stamina

                // Subtract stamina directly (negative value for cost)
                Consumption consumption = new Consumption(
                    ConsumptionType.FIGHT, 
                    -Math.abs(staminaCost) // Ensure negative value
                );

                staminaManager.updateStaminaRelative(session, consumption, true);
                staminaManager.staminaRecoverDelay = 0;

                // Log for debugging
                Grasscutter.getLogger().info(
                    "Skill Stamina Cost: Displayed={}, Internal={}",
                    costStaminaRatio, staminaCost
                );
            }
        }
    
       if (action.skillID == 11065) {
            Avatar avatar = ability.getPlayerOwner().getCurrentAvatar();
            avatar.clearSpecialEnergy();
        }
        if (owner instanceof EntityAvatar avatar) {
            avatar
                    .getPlayer()
                    .getQuestManager()
                    .queueEvent(QuestContent.QUEST_CONTENT_SKILL, action.skillID);
        } else {
            Grasscutter.getLogger()
                    .warn("AvatarSkillStart not implemented for other entities than EntityAvatar right now");
            return false;
        }

        return true;
    }
}

