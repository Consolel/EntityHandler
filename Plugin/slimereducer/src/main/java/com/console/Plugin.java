package com.console;
import org.bukkit.plugin.java.JavaPlugin;
import com.console.commands.Discord;
import com.console.commands.SlimeInfo;
import com.console.commands.Reload;
import com.console.commands.SetReduction;
import com.console.files.CustomConfig;
import com.console.listeners.SpawnListener;
import java.util.logging.Logger;
public class Plugin extends JavaPlugin
{
  private static final Logger LOGGER = Logger.getLogger("[SlimeReducer]");
  public void onEnable()
  {
    LOGGER.info("Loaded!");
    getConfig().options().copyDefaults();
    saveDefaultConfig();
    CustomConfig.setup();
    CustomConfig.get().addDefault("Reduction", 50);
    CustomConfig.get().options().copyDefaults(true);
    CustomConfig.save();
    getCommand("Discord").setExecutor(new Discord());
    getCommand("SlimeInfo").setExecutor(new SlimeInfo());
    getCommand("Reload").setExecutor(new Reload());
    getCommand("SetReduction").setExecutor(new SetReduction());
    getServer().getPluginManager().registerEvents(new SpawnListener(), this);
  }

  public void onDisable()
  {
    CustomConfig.save();
    LOGGER.info("Unloaded!");
  }
}
