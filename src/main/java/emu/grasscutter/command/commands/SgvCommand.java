package emu.grasscutter.command.commands;

import static emu.grasscutter.config.Configuration.GAME_OPTIONS;

import emu.grasscutter.command.*;
import emu.grasscutter.server.packet.send.*;
import emu.grasscutter.game.player.Player;
import emu.grasscutter.server.packet.send.PacketPlayerEnterSceneInfoNotify;
import java.util.*;
import emu.grasscutter.game.ability.AbilityManager;
import emu.grasscutter.net.proto.AbilitySyncStateInfo;
import emu.grasscutter.net.proto.AvatarEnterSceneInfo;
import emu.grasscutter.net.proto.MPLevelEntityInfo;
import emu.grasscutter.net.proto.PlayerEnterSceneInfoNotify;
import emu.grasscutter.net.proto.TeamEnterSceneInfo;
import emu.grasscutter.data.GameData;
import emu.grasscutter.data.binout.*;
import emu.grasscutter.data.binout.AbilityModifier.AbilityModifierAction;
import emu.grasscutter.game.ability.actions.*;
import emu.grasscutter.game.ability.mixins.*;
import emu.grasscutter.game.entity.EntityAvatar;
import emu.grasscutter.game.entity.GameEntity;
import emu.grasscutter.game.player.*;
import emu.grasscutter.server.packet.send.PacketServerGlobalValueChangeNotify;
import emu.grasscutter.game.props.FightProperty;
import emu.grasscutter.server.event.player.PlayerUseSkillEvent;
import io.netty.util.concurrent.FastThreadLocalThread;
import emu.grasscutter.utils.Utils;
import java.util.concurrent.*;
import lombok.Getter;
import emu.grasscutter.game.props.*;
import java.util.List;

@Command(
        label = "sgv",
        aliases = {"serverglobalvalue"})
public final class SgvCommand implements CommandHandler {

    @Override
    public void execute(Player sender, Player targetPlayer, List<String> args) {
        var value = (float)Integer.parseInt(args.get(1));
        targetPlayer.sendPacket(new PacketServerGlobalValueChangeNotify(
                targetPlayer.getTeamManager().getEntity().getId(), args.get(0), value));
        CommandHandler.sendMessage(targetPlayer, String.valueOf(Utils.abilityHash(args.get(0))));
        CommandHandler.sendMessage(targetPlayer, "Changed Server Global Value for " + args.get(0));
        if(args.get(0).equalsIgnoreCase("SGV_PlayerTeam_Phlogiston") ){
            targetPlayer.setPhlogistonValue(value);
        }
    }
}