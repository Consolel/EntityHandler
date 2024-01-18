package com.console.listeners;
import com.console.files.CustomConfig;
import org.bukkit.entity.Slime;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntitySpawnEvent;
public class SpawnListener implements Listener {
    @EventHandler
    public void EntitySpawnEvent(EntitySpawnEvent evt) {
        int percentage = CustomConfig.get().getInt("Reduction");
        if(evt.getEntity() instanceof Slime && percentage > (1 + (int) (Math.random() * 100)))  {
            evt.getEntity().remove();
        }
    }
}
