package tw.ch1ck3n.portableshulker;

import lombok.Getter;
import org.bukkit.event.HandlerList;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;
import tw.ch1ck3n.portableshulker.commands.PortableShulkerCommandExecutor;
import tw.ch1ck3n.portableshulker.commands.PortableShulkerTabCompleter;
import tw.ch1ck3n.portableshulker.listeners.InventoryClickListener;
import tw.ch1ck3n.portableshulker.listeners.InventoryCloseListener;
import tw.ch1ck3n.portableshulker.listeners.PlayerInteractListener;
import tw.ch1ck3n.portableshulker.managers.ShulkerManager;
import tw.ch1ck3n.portableshulker.utilities.ConfigUtil;
import tw.ch1ck3n.portableshulker.utilities.LogUtil;

@Getter
public final class PortableShulker extends JavaPlugin {

    @Getter
    private static PortableShulker instance;

    public static final String PREFIX = "&7[&aPortableShulker&7]&r";

    private ShulkerManager shulkerManager;

    private ConfigUtil configUtil;

    @Override
    public void onEnable() {

        instance = this;
        this.shulkerManager = new ShulkerManager();

        this.initialize();
    }

    @Override
    public void onDisable() {

        HandlerList.unregisterAll(this);
    }

    private void initialize() {

        LogUtil.log("");
        LogUtil.log(" > --------------------------------------------- <");
        LogUtil.log("");
        LogUtil.log("           " + this.getDescription().getName() + " [" + this.getDescription().getVersion() + "]");  // 11 spaces
        LogUtil.log("");

        this.setupConfig();

        LogUtil.log("");

        this.loadConfig();

        LogUtil.log("");

        this.registerCommands();

        LogUtil.log("");

        this.registerListeners(this.getServer().getPluginManager());

        LogUtil.log("");
        LogUtil.log(" > --------------------------------------------- <");
        LogUtil.log("");
    }

    private void setupConfig() {

        LogUtil.log("  > Saving default config");

        this.saveDefaultConfig();

        LogUtil.log("    ...default config saved");
    }

    private void loadConfig() {

        LogUtil.log("  > Loading config");

        this.configUtil = new ConfigUtil();

        LogUtil.log("    ...config loaded");
    }

    private void registerCommands() {

        LogUtil.log("  > Registering commands");

        this.getCommand("portableshulker").setExecutor(new PortableShulkerCommandExecutor());

        this.getCommand("portableshulker").setTabCompleter(new PortableShulkerTabCompleter());

        LogUtil.log("    ...registered " + 1 + " command(s)");
    }

    private void registerListeners(PluginManager pluginManager) {

        LogUtil.log("  > Registering listeners");

        pluginManager.registerEvents(new InventoryClickListener(), this);
        pluginManager.registerEvents(new InventoryCloseListener(), this);
        pluginManager.registerEvents(new PlayerInteractListener(), this);

        LogUtil.log("    ...registered " + 3 + " listener(s)");
    }
}
