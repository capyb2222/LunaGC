package emu.grasscutter.command.commands;

import emu.grasscutter.Grasscutter;
import emu.grasscutter.command.Command;
import emu.grasscutter.command.CommandHandler;
import emu.grasscutter.game.player.Player;
import emu.grasscutter.server.packet.send.PacketOpenStateChangeNotify;
import java.util.List;

@Command(label = "barrier", usage = "/br [on|off | 1|0]\n\sdescription: removes paimon barrier at will", aliases = {"br","pb"}, permission = "player.setprop", permissionTargeted = "player.setprop.others")
public final class BarrierCommand implements CommandHandler {

	@Override
	public void execute(Player sender, Player targetPlayer, List<String> args) {
		String state = "";
		
		if (targetPlayer == null) {
			targetPlayer = sender;
		}
		
		switch (args.size()) {
            case 1:
                state = args.get(0);
				break;
            default:
                CommandHandler.sendMessage(sender, "No state mentioned, assuming off");
				state = "off";
        }
		
		if (state.equals("on") || state.equals("1")) {
			targetPlayer.sendPacket(new PacketOpenStateChangeNotify(48,0));
			CommandHandler.sendMessage(sender, "Restored barrier");
		} else if (state.equals("off") || state.equals("0")) {
			targetPlayer.sendPacket(new PacketOpenStateChangeNotify(48,1));
			CommandHandler.sendMessage(sender, "Removed barrier");
		} else {
			targetPlayer.sendPacket(new PacketOpenStateChangeNotify(48,1));
			CommandHandler.sendMessage(sender, "No valid state mentioned, assuming off");
        }
	}
}