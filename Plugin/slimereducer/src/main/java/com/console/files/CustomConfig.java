package com.console.files;
import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import java.io.File;
import java.io.IOException;
public class CustomConfig {
    private static File file;
    private static FileConfiguration customFile;
    public static void setup()
    {
        file = new File(Bukkit.getServer().getPluginManager().getPlugin("SlimeReducer").getDataFolder(), "config.yml");
        if (!file.exists())
        {
            try
            {
                file.createNewFile();
            }
            catch (IOException e)
            {
                System.out.println("[SlimeReducer] Could not create config file!");
            }
        }
        customFile = YamlConfiguration.loadConfiguration(file);
    }
 
    public static FileConfiguration get()
    {
        return customFile;
    }
 
    public static void save(){
        try
        {
            customFile.save(file);
        }
        catch (IOException e)
        {
            System.out.println("[SlimeReducer] Couldn't Save Config File!");
        }
    }
 
    public static void reload()
    {
        customFile = YamlConfiguration.loadConfiguration(file);
    }
 
}

