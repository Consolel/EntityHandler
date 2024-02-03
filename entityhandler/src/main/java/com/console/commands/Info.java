package com.console.commands;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
public class Info implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        // send a nice little sound!
        if(sender instanceof Player) {
            Player player = (Player) sender;
            player.playSound(player.getLocation(), Sound.UI_BUTTON_CLICK, 5, 5);
        }
        sender.sendMessage("§4Thanks for using my Plugin! §fDiscord -> discord.gg/geM5US4FFd \n§a[EntityHandler] V1.2 by Console :)");
        return true; 
    }
}