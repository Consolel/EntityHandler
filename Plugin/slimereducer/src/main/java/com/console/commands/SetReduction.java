package com.console.commands;
import com.console.files.CustomConfig;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.entity.Slime;
public class SetReduction implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        int value = Integer.parseInt(args[0]);
        CustomConfig.get().set("Reduction", value);
        sender.sendMessage("§4[SlimeReducer]§f Reduction set to " + value + "%!");
        Player p = (Player) sender;
        for(Entity e : p.getWorld().getEntities()){ 
            if(e instanceof Slime) {
                e.remove();
            }
        }
        return true;
    }
}