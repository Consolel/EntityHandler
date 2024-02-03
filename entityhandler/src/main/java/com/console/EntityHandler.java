package com.console;
import com.console.commands.EntityList;
import com.console.commands.Info;
import com.console.commands.ReduceMob;
import com.console.commands.Reload;
import com.console.listeners.SpawnListener;
import java.util.logging.Logger;
import org.bukkit.plugin.java.JavaPlugin;
public class EntityHandler extends JavaPlugin {
  private static final Logger log = Logger.getLogger("EntityHandler");
  public void onEnable() {
    // load default config if one doesnt exist already
    saveDefaultConfig(); 
    // check if plugin enabled
    if(getConfig().getBoolean("IsEnabled") == false) {
      this.setEnabled(false);
      return;
    }
    // Hooks
    getCommand("EntityList").setExecutor(new EntityList());
    getCommand("Info").setExecutor(new Info());
    getCommand("ReduceMob").setExecutor(new ReduceMob());
    getCommand("Reload").setExecutor(new Reload());
    getServer().getPluginManager().registerEvents(new SpawnListener(), this);
    // end
    log.info("[EntityHandler] Loaded!");
  }
}