package info.gomeow.animalcontrol;

import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.entity.Animals;
import org.bukkit.entity.Entity;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.Random;
import java.util.UUID;


public class ControlTask extends BukkitRunnable {

    private final AnimalControl plugin;

    private final Random rand = new Random();

    public ControlTask(AnimalControl animalControl) {
        plugin = animalControl;
    }

    @Override
    public void run() {
        for (World world : Bukkit.getWorlds()) {
            for (Entity entity : world.getEntities()) {
                if (entity instanceof Animals) {
                    Animals animal = (Animals) entity;
                    UUID uuid = entity.getUniqueId();
                    EntityData data = plugin.getEntityData(uuid);
                    if (data.isDiseased()) {
                        animal.damage(1);
                    } else {
                        if (rand.nextInt(100) < 10) {
                            data.setDiseased(true);
                            animal.damage(1);
                        }
                    }
                }
            }
        }
    }
}
