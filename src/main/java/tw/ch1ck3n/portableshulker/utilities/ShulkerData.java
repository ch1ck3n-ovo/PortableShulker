package tw.ch1ck3n.portableshulker.utilities;

import lombok.Getter;
import org.bukkit.block.ShulkerBox;

@Getter
public class ShulkerData {

    private final ShulkerBox shulkerBox;
    private final int slot;

    public ShulkerData(ShulkerBox shulkerBox, int slot) {
        this.shulkerBox = shulkerBox;
        this.slot = slot;
    }
}
