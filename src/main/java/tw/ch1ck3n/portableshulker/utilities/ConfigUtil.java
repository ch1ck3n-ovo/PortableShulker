package tw.ch1ck3n.portableshulker.utilities;

import tw.ch1ck3n.portableshulker.PortableShulker;
import tw.ch1ck3n.portableshulker.enums.ClickType;
import tw.ch1ck3n.portableshulker.enums.SneakType;

public class ConfigUtil {

    public ClickType SHULKER_USE_BUTTON;

    public SneakType SHULKER_USE_SNEAK;

    public String MESSAGE_INVALID_SETTING;

    public String MESSAGE_PLUGIN_RELOADING;

    public String MESSAGE_PLUGIN_RELOADED;

    public ConfigUtil() {
        this.loadConfig();
    }

    public void loadConfig() {
        PortableShulker.getInstance().reloadConfig();
        this.SHULKER_USE_BUTTON = ClickType.get(PortableShulker.getInstance().getConfig().getString("shulker-use-button"));
        this.SHULKER_USE_SNEAK = SneakType.get(PortableShulker.getInstance().getConfig().getString("shulker-use-sneak"));
        this.MESSAGE_INVALID_SETTING = PortableShulker.getInstance().getConfig().getString("message-invalid-setting");
        this.MESSAGE_PLUGIN_RELOADING = PortableShulker.getInstance().getConfig().getString("message-plugin-reloading");
        this.MESSAGE_PLUGIN_RELOADED = PortableShulker.getInstance().getConfig().getString("message-plugin-reloaded");
    }
}
