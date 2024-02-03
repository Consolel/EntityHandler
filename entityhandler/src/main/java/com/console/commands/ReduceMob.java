package com.console.commands;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.EntityType;
import com.console.EntityHandler;
public class ReduceMob implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(!(sender.hasPermission("EntityHandler.Admin"))) return false; 
        // check for 2 args
        if (args.length < 2) {
            sender.sendMessage("No Args!");
            return false;
        }
        // get entity enum from string arg1
        EntityType entityEnum; 
        try {
            entityEnum = EntityType.valueOf(args[0].toUpperCase());
        }
        catch (IllegalArgumentException e) {
            sender.sendMessage("Invalid Mob!");
            return false; 
        }
        // get percentage from arg2, and check if its valid
        int percentage = Integer.parseInt(args[1]);
        if (!(percentage >= 0 && percentage <= 100)) {
            sender.sendMessage("Number not in range 0-100!");
            return false;
        }
        // add it to the config!
        FileConfiguration config = EntityHandler.getPlugin(EntityHandler.class).getConfig();
        ConfigurationSection entityReductions = config.getConfigurationSection("EntityReductions");
        // remove entry if percentage is 0
        if(percentage == 0) {
            entityReductions.set(entityEnum.toString(), null);
        }
        else {
            entityReductions.set(entityEnum.toString(), percentage);
        }
        // save config!
        EntityHandler.getPlugin(EntityHandler.class).saveConfig(); 
        // send confirmation
        sender.sendMessage("§a" + args[0] + " reduction set to " + percentage);
        return true;
    }
}
