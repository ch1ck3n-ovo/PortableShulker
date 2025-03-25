package tw.ch1ck3n.portableshulker.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;
import tw.ch1ck3n.portableshulker.PortableShulker;
import tw.ch1ck3n.portableshulker.utilities.LogUtil;

import java.util.ArrayList;
import java.util.List;

public class PortableShulkerTabCompleter implements TabCompleter {

    ArrayList<String> aliases = new ArrayList<>() {{
        add("portableshulker");
        add("ps");
    }};

    @Override
    public List<String> onTabComplete(CommandSender commandSender, Command command, String s, String[] strings) {

        List<String> list = new ArrayList<>();

        if (commandSender instanceof Player) if (!commandSender.hasPermission("portableshulker.admin")) return list;

//        if (commandSender instanceof Player) {
        if (aliases.contains(command.getName())) {
            if (strings.length == 1) {
                String[] subcommand = {"reload"};

                for (int i = 0; i < subcommand.length; i++) {
                    if (subcommand[i].startsWith(strings[0])) list.add(subcommand[i]);
                }
            }
        }
//        }

        return list;
    }
}
