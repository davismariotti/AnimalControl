package info.gomeow.animalcontrol;

import org.bukkit.entity.Animals;
import org.bukkit.entity.LivingEntity;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.CreatureSpawnEvent;

public class ControlListener implements Listener {

    private final AnimalControl plugin;

    public ControlListener(AnimalControl animalControl) {
        plugin = animalControl;
    }

    @EventHandler
    public void onSpawn(CreatureSpawnEvent event) {
        LivingEntity entity = event.getEntity();
        if(entity instanceof Animals) {
            Animals animal = (Animals) entity;
            plugin.createData(animal.getUniqueId());
        }
    }

}