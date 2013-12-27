package info.gomeow.animalcontrol;

import org.bukkit.plugin.java.JavaPlugin;

import java.util.HashMap;
import java.util.UUID;

public class AnimalControl extends JavaPlugin{

    private final HashMap<UUID, EntityData> data = new HashMap<UUID, EntityData>();

    public void onEnable() {
        getServer().getPluginManager().registerEvents(new ControlListener(this), this);
        saveDefaultConfig();
        startTask();
    }

    public EntityData getEntityData(UUID uuid) {
        return data.get(uuid);
    }

    public void createData(UUID uuid) {
        data.put(uuid, new EntityData());
    }

    public void startTask() {
        ControlTask task = new ControlTask(this);
        task.runTaskTimer(this, 0L, 3600L);
    }
}
