package tw.ch1ck3n.portableshulker.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import tw.ch1ck3n.portableshulker.PortableShulker;
import tw.ch1ck3n.portableshulker.utilities.LogUtil;

public class PortableShulkerCommandExecutor implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {

        if (commandSender instanceof Player && !commandSender.hasPermission("portableshulker.admin")) return true;

        PortableShulker instance = PortableShulker.getInstance();
        boolean isPlayer = commandSender instanceof Player;
        if (strings.length == 1) {
            if (strings[0].equals("reload")) {
                if (isPlayer) commandSender.sendMessage(
                        LogUtil.format(PortableShulker.PREFIX + " " + instance.getConfigUtil().MESSAGE_PLUGIN_RELOADING));

                PortableShulker.getInstance().onDisable();
                PortableShulker.getInstance().onEnable();

                if (isPlayer) commandSender.sendMessage(
                        LogUtil.format(PortableShulker.PREFIX + " " + instance.getConfigUtil().MESSAGE_PLUGIN_RELOADED));
            }
        }
        return true;
    }
}
