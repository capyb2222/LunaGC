package emu.grasscutter.game.ability.mixins;

import com.google.protobuf.ByteString;
import emu.grasscutter.data.binout.AbilityMixinData;
import emu.grasscutter.game.entity.GameEntity;
import emu.grasscutter.game.ability.Ability;

public abstract class AbilityMixinHandler {

    public abstract boolean execute(
            Ability ability, AbilityMixinData mixinData, ByteString abilityData,  GameEntity target);
            protected GameEntity getTarget(Ability ability, GameEntity entity, String target) {
                return switch (target) {
                    default -> throw new RuntimeException("Unknown target type: " + target);
                    case "Self" -> entity;
                    case "Team" -> ability.getPlayerOwner().getTeamManager().getEntity();
                    case "OriginOwner" -> ability.getPlayerOwner().getTeamManager().getCurrentAvatarEntity();
                    case "Owner" -> ability.getOwner();
                    case "Applier" -> entity; // TODO: Validate.
                    case "CurLocalAvatar" -> ability
                            .getPlayerOwner()
                            .getTeamManager()
                            .getCurrentAvatarEntity(); // TODO: Validate.
                    case "CasterOriginOwner" -> null; // TODO: Figure out.
                };
            }
        }
        
