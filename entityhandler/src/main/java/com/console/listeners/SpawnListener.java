package com.console.listeners;
import com.console.EntityHandler;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.event.Listener;
import org.bukkit.event.EventHandler;
import org.bukkit.event.entity.EntitySpawnEvent;
import org.bukkit.configuration.file.FileConfiguration;
public final class SpawnListener implements Listener {
    @EventHandler
    void EntitySpawnEvent(EntitySpawnEvent evt) {
        // load config section for mob reduction
        FileConfiguration config = EntityHandler.getPlugin(EntityHandler.class).getConfig();
        ConfigurationSection entityReductions = config.getConfigurationSection("EntityReductions");
        // get the entity string name
        Entity entity = evt.getEntity();
        EntityType entityType = entity.getType(); // get mob enum
        String entityString = entityType.toString(); // enum to string 
        // check if it translated properly, if it did, randomly decide based on percentage to deny spawn.
        if (entityReductions.get(entityString) != null) {
            final int percentage = entityReductions.getInt(entityString);
            final boolean hasPercent = percentage > (1 + (int) (Math.random() * 100));
            if (hasPercent) {
                entity.remove();
            }
        }
    }
}


/* debug code
* import java.util.logging.Logger;
* Logger log = Logger.getLogger("EntityHandler"); 
* log.info(entityType.toString());
*/