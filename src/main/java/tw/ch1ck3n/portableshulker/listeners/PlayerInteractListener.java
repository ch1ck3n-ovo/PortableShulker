package tw.ch1ck3n.portableshulker.listeners;

import org.bukkit.block.ShulkerBox;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import tw.ch1ck3n.portableshulker.PortableShulker;
import tw.ch1ck3n.portableshulker.enums.ClickType;
import tw.ch1ck3n.portableshulker.enums.SneakType;
import tw.ch1ck3n.portableshulker.utilities.LogUtil;
import tw.ch1ck3n.portableshulker.utilities.ShulkerUtil;

public class PlayerInteractListener implements Listener {

    @EventHandler
    public void onPlayerInteract(PlayerInteractEvent event) {

        if (!event.hasItem() || !ShulkerUtil.isShulkerBox(event.getItem())) return;

        SneakType sneakType = PortableShulker.getInstance().getConfigUtil().SHULKER_USE_SNEAK;
        if (SneakType.isNull(sneakType)) {
            LogUtil.warning(PortableShulker.getInstance().getConfigUtil().MESSAGE_INVALID_SETTING);
            return;
        }

        ClickType clickType = PortableShulker.getInstance().getConfigUtil().SHULKER_USE_BUTTON;
        if (ClickType.isNull(clickType)) {
            LogUtil.warning(PortableShulker.getInstance().getConfigUtil().MESSAGE_INVALID_SETTING);
            return;
        }

        Action action = event.getAction();
        Player player = event.getPlayer();
        ShulkerBox shulkerBox = ShulkerUtil.toShulkerBox(event.getItem());
        boolean sneaking = player.isSneaking();

        if (ShulkerUtil.shouldOpenShulkerBox(sneakType, sneaking) &&
                ShulkerUtil.shouldOpenShulkerBox(clickType, action)) {
            event.setCancelled(true);
            ShulkerUtil.openShulkerBox(player, shulkerBox);
            PortableShulker.getInstance().getShulkerManager().addShulkerData(
                    player.getUniqueId(), shulkerBox, player.getInventory().getHeldItemSlot());
        }
    }
}
