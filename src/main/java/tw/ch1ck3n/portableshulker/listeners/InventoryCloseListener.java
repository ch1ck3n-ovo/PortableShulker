package tw.ch1ck3n.portableshulker.listeners;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.inventory.ItemStack;
import tw.ch1ck3n.portableshulker.PortableShulker;
import tw.ch1ck3n.portableshulker.utilities.ShulkerUtil;

public class InventoryCloseListener implements Listener {

    @EventHandler
    public void onInventoryClose(InventoryCloseEvent event) {

        if (!PortableShulker.getInstance().getShulkerManager().hasShulkerData(event.getPlayer().getUniqueId())) return;

        Player player = (Player) event.getPlayer();
        int slot = PortableShulker.getInstance().getShulkerManager().getShulkerData(player.getUniqueId()).getSlot();
        ItemStack stack = player.getInventory().getItem(slot);

        ShulkerUtil.closeShulkerBox(player, stack, event.getInventory());
        PortableShulker.getInstance().getShulkerManager().removeShulkerData(player.getUniqueId());
    }
}
