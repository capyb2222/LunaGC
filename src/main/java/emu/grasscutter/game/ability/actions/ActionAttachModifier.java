package emu.grasscutter.game.ability.actions;

import com.google.protobuf.ByteString;
import emu.grasscutter.Grasscutter;
import emu.grasscutter.game.props.FightProperty;
import emu.grasscutter.data.binout.AbilityModifier.AbilityModifierAction;
import emu.grasscutter.game.ability.Ability;
import emu.grasscutter.game.ability.AbilityManager;
import emu.grasscutter.net.proto.ChangHpReason;
import emu.grasscutter.net.proto.PropChangeReason;
import emu.grasscutter.server.packet.send.PacketEntityFightPropChangeReasonNotify;
import emu.grasscutter.server.packet.send.PacketEntityFightPropUpdateNotify;
import emu.grasscutter.game.ability.AbilityModifierController;
import emu.grasscutter.game.entity.GameEntity;

@AbilityAction(AbilityModifierAction.Type.AttachModifier)
public final class ActionAttachModifier extends AbilityActionHandler {

    @Override
    public boolean execute(Ability ability, AbilityModifierAction action, ByteString abilityData, GameEntity target) {
        String modifierName = action.modifierName;

        // Log for debugging purposes
        Grasscutter.getLogger().debug("[Ability] AttachModifier: {}", modifierName);

        // Retrieve the modifier data using the modifier name
        var modifierData = ability.getData().modifiers.get(action.modifierName);

        if (modifierData == null) {
            Grasscutter.getLogger().debug("Modifier {} not found", modifierName);
            return false;
        }

        // Create a new AbilityModifierController with the modifier data
        AbilityModifierController modifierController = new AbilityModifierController(ability, ability.getData(), modifierData);

        // Attach the modifier to the ability's list of modifiers
        ability.getModifiers().put(modifierName, modifierController);

        // Return true to indicate that the modifier was successfully attached
        return true;
    }
}
