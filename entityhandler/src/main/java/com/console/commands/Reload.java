package com.console.commands;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import com.console.EntityHandler;
public class Reload implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(!(sender.hasPermission("EntityHandler.Admin"))) return false; 
        // reload config
        EntityHandler.getPlugin(EntityHandler.class).reloadConfig();
        sender.sendMessage("§4[EntityHandler]§f Reloaded!");
        return true;
    }
}