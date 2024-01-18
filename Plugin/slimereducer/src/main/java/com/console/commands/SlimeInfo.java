package com.console.commands;
import com.console.files.CustomConfig;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
public class SlimeInfo implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        sender.sendMessage("§4[SlimeReducer]§f Version 1.0 \nReduction Amount: " + CustomConfig.get().getInt("Reduction") + "\nMade by Console :)");
        return true;
    }
}