package tw.ch1ck3n.portableshulker.listeners;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryType;
import tw.ch1ck3n.portableshulker.PortableShulker;

public class InventoryClickListener implements Listener {

    @EventHandler
    public void onInventoryClick(InventoryClickEvent event) {

        if (!PortableShulker.getInstance().getShulkerManager().hasShulkerData(event.getWhoClicked().getUniqueId())) return;

        Player player = (Player) event.getWhoClicked();
        int slot = PortableShulker.getInstance().getShulkerManager().getShulkerData(player.getUniqueId()).getSlot();

        if (event.getSlotType() == InventoryType.SlotType.QUICKBAR && slot == event.getSlot()) {
            event.setCancelled(true);
        }
    }
}
