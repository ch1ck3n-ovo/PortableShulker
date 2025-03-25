package tw.ch1ck3n.portableshulker.managers;

import lombok.Getter;
import org.bukkit.block.ShulkerBox;
import tw.ch1ck3n.portableshulker.utilities.ShulkerData;

import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

@Getter
public class ShulkerManager {

    private final ConcurrentHashMap<UUID, ShulkerData> datas;

    public ShulkerManager() {
        this.datas = new ConcurrentHashMap<>();
    }

    public void addShulkerData(UUID uuid, ShulkerBox shulkerBox, int slot) {
        if (this.getShulkerData(uuid) != null) return;
        this.datas.put(uuid, new ShulkerData(shulkerBox, slot));
    }

    public void removeShulkerData(UUID uuid) {
        this.datas.remove(uuid);
    }

    public ShulkerData getShulkerData(UUID uuid) {
        return this.datas.get(uuid);
    }

    public boolean hasShulkerData(UUID uuid) {
        return this.datas.get(uuid) != null;
    }

}
