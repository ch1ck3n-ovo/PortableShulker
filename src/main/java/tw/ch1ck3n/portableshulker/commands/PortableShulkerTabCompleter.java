package tw.ch1ck3n.portableshulker.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;
import org.checkerframework.checker.nullness.qual.NonNull;

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

        if (aliases.contains(command.getName())) {
            if (strings.length == 1) {
                String subcommand = "reload";
                
                if (subcommand.startsWith(strings[0])) list.add(subcommand);
            }
        }

        return list;
    }
}
