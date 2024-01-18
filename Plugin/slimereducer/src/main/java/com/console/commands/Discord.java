package com.console.commands;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
public class Discord implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        sender.sendMessage("§4Thanks for using my Plugin! \n§fDiscord -> discord.gg/geM5US4FFd");
        return true; 
    }
}
