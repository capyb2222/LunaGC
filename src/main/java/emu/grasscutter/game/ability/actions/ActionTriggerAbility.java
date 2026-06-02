package emu.grasscutter.game.ability.actions;

import com.google.protobuf.ByteString;
import emu.grasscutter.data.binout.AbilityModifier.AbilityModifierAction;
import emu.grasscutter.game.ability.Ability;
import emu.grasscutter.game.player.Player;
import emu.grasscutter.game.entity.GameEntity;
import emu.grasscutter.Grasscutter;

@AbilityAction(AbilityModifierAction.Type.TriggerAbility)
public final class ActionTriggerAbility extends AbilityActionHandler {
    @Override
    public boolean execute(
            Ability ability, AbilityModifierAction action, ByteString abilityData, GameEntity target) {
        Grasscutter.getLogger().debug("[Ability] TriggerAbility: {}", action.abilityName);
        
        // Access the player's AbilityManager using the host method.
        var player = ability.getPlayerOwner();
        if (player == null) {
            Grasscutter.getLogger().error("No player owner found for ability {}", ability);
            return false;
        }
        
        // Add the ability (specified by action.abilityName) to the target entity.
        player.getWorld().getHost().getAbilityManager().addAbilityToEntity(target, action.abilityName);
        
        return true;
    }
}
