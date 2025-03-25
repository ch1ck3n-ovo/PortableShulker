package tw.ch1ck3n.portableshulker.utilities;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import tw.ch1ck3n.portableshulker.PortableShulker;

public class LogUtil {

    public static void log(String content) {
        Bukkit.getLogger().info(
                LogUtil.removeAllColorCodes(PortableShulker.PREFIX + " " + ChatColor.translateAlternateColorCodes('&', content))
        );
    }

    public static void warning(String content) {
        Bukkit.getLogger().warning(
                LogUtil.removeAllColorCodes(PortableShulker.PREFIX + " " + ChatColor.translateAlternateColorCodes('&', content))
        );
    }

    public static String format(String content) {
        return ChatColor.translateAlternateColorCodes('&', content);
    }

    private static String removeAllColorCodes(String in) {
        return ChatColor.translateAlternateColorCodes('&', in)
                .replaceAll("§0", "").replaceAll("§1", "").replaceAll("§2", "").replaceAll("§3", "")
                .replaceAll("§4", "").replaceAll("§5", "").replaceAll("§6", "").replaceAll("§7", "")
                .replaceAll("§8", "").replaceAll("§9", "").replaceAll("§a", "").replaceAll("§b", "")
                .replaceAll("§c", "").replaceAll("§d", "").replaceAll("§e", "").replaceAll("§f", "")
                .replaceAll("§k", "").replaceAll("§l", "").replaceAll("§m", "")
                .replaceAll("§n", "").replaceAll("§o", "").replaceAll("§r", "");
    }
}
