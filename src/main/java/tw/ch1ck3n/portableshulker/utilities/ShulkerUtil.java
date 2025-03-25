package tw.ch1ck3n.portableshulker.utilities;

import lombok.Getter;
import org.bukkit.Sound;
import org.bukkit.block.ShulkerBox;
import org.bukkit.entity.Player;
import org.bukkit.event.block.Action;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.BlockStateMeta;
import tw.ch1ck3n.portableshulker.enums.ClickType;
import tw.ch1ck3n.portableshulker.enums.SneakType;

@Getter
public class ShulkerUtil {

    public static boolean isShulkerBox(ItemStack stack) {
        return stack.getType().name().contains("SHULKER_BOX");
    }

    public static ShulkerBox toShulkerBox(ItemStack stack) {
        return (ShulkerBox) (((BlockStateMeta) stack.getItemMeta()).getBlockState());
    }

    public static void openShulkerBox(Player player, ShulkerBox shulkerBox) {
        player.openInventory(shulkerBox.getInventory());
        ShulkerUtil.playOpenShulkerBoxSound(player);
    }

    private static void playOpenShulkerBoxSound(Player player) {
        player.getWorld().playSound(player.getLocation(), Sound.BLOCK_SHULKER_BOX_OPEN, .1F, 1.0F);
    }

    public static void closeShulkerBox(Player player, ItemStack stack, Inventory inventory) {
        ShulkerUtil.saveShulkerBox(stack, inventory);
        ShulkerUtil.playCloseShulkerBoxSound(player);
    }

    private static void saveShulkerBox(ItemStack stack, Inventory inventory) {

        BlockStateMeta blockStateMeta = (BlockStateMeta) stack.getItemMeta();
        ShulkerBox shulkerBox = ShulkerUtil.toShulkerBox(stack);

        shulkerBox.getInventory().setContents(inventory.getContents());
        blockStateMeta.setBlockState(shulkerBox);
        stack.setItemMeta(blockStateMeta);
    }

    private static void playCloseShulkerBoxSound(Player player) {
        player.getWorld().playSound(player.getLocation(), Sound.BLOCK_SHULKER_BOX_CLOSE, .1F, 1.0F);
    }

    public static boolean shouldOpenShulkerBox(ClickType clickType, Action action) {
        return switch (clickType) {
            case LEFT_CLICK_ALL -> action == Action.LEFT_CLICK_AIR || action == Action.LEFT_CLICK_BLOCK;
            case RIGHT_CLICK_ALL -> action == Action.RIGHT_CLICK_AIR || action == Action.RIGHT_CLICK_BLOCK;
            case LEFT_CLICK_AIR, LEFT_CLICK_BLOCK, RIGHT_CLICK_AIR, RIGHT_CLICK_BLOCK ->
                    action == Action.valueOf(clickType.name());
            default -> false;
        };
    }

    public static boolean shouldOpenShulkerBox(SneakType sneakType, boolean sneaking) {
        return switch (sneakType) {
            case NO_SNEAK -> !sneaking;
            case ONLY_SNEAK -> sneaking;
            default -> false;
        };
    }
}
