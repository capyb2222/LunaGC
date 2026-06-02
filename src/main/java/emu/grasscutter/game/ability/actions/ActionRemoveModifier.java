package emu.grasscutter.game.ability.actions;

import com.google.protobuf.ByteString;
import emu.grasscutter.Grasscutter;
import emu.grasscutter.game.props.FightProperty;
import emu.grasscutter.data.binout.AbilityModifier.AbilityModifierAction;
import emu.grasscutter.game.ability.Ability;
import emu.grasscutter.game.ability.AbilityManager;
import emu.grasscutter.net.proto.ChangHpReason;
import emu.grasscutter.net.proto.PropChangeReason;
import emu.grasscutter.net.proto.PropChangeReason;
import emu.grasscutter.server.packet.send.PacketEntityFightPropUpdateNotify;
import emu.grasscutter.server.packet.send.PacketEntityFightPropChangeReasonNotify;
import emu.grasscutter.game.entity.EntityAvatar;
import emu.grasscutter.game.ability.actions.ActionLoseHP;

import emu.grasscutter.net.proto.ChangeEnergyReason;
import emu.grasscutter.server.packet.send.PacketEntityFightPropChangeReasonNotify;
import emu.grasscutter.server.packet.send.PacketEntityFightPropUpdateNotify;
import emu.grasscutter.game.ability.AbilityModifierController;
import emu.grasscutter.game.entity.GameEntity;


@AbilityAction(AbilityModifierAction.Type.RemoveModifier)
public final class ActionRemoveModifier extends AbilityActionHandler {
    @Override
    public boolean execute(
            Ability ability, AbilityModifierAction action, ByteString abilityData, GameEntity target) {
        Grasscutter.getLogger().debug("[Ability] Removing Modifier: {}", action.modifierName);

        // Prüfen, ob der Modifier existiert
        if (!ability.getModifiers().containsKey(action.modifierName)) {
            Grasscutter.getLogger().debug("Modifier {} not found for removal", action.modifierName);
            return false;
        }

        // Modifier aus der Liste entfernen
        ability.getModifiers().remove(action.modifierName);
        Grasscutter.getLogger().debug("Modifier {} successfully removed", action.modifierName);

        return true;
    }
}
