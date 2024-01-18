package com.console.commands;
import com.console.files.CustomConfig;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
public class Reload implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        CustomConfig.reload();
        sender.sendMessage("§4[SlimeReducer]§f Reloaded!");
        return true;
    }
}