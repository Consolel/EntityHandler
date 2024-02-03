package com.console.commands;
import com.console.EntityHandler;
import java.util.HashMap;
import java.util.Iterator;
import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
/*
 * This code is heavily modified and added onto from the plugin
 * https://www.spigotmc.org/resources/entitylist.1378/
 * Made by https://www.spigotmc.org/resources/authors/siwecode.26331/
 */
public class EntityList implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(!(sender.hasPermission("EntityHandler.Admin"))) return false; 
        FileConfiguration config = EntityHandler.getPlugin(EntityHandler.class).getConfig();
        // if no param is passed get the world player is in.
        World world = null;
        if (args.length == 0) {
            if (sender instanceof Player) {
                Player player = (Player) sender;
                world = player.getWorld();
            }
            else {
                return false;
            }
        }

        // if param is passed, check if it works, if not send message.
        else {
            world = Bukkit.getWorld(args[0]);
            if(world == null) {
                return false;
            }
        }
        // hashmap for entities and their count
        HashMap<EntityType, Integer> entities = new HashMap<EntityType, Integer>();
        // iterator to go through the entities and add them to the hashmap
        Iterator<Entity> iterator = world.getEntities().iterator();
        while(iterator.hasNext()) {
            Entity entity = (Entity) iterator.next();
            // Check if this entity is on the map, if so increment
            if (entities.containsKey(entity.getType())) {
                entities.put(entity.getType(), entities.get(entity.getType()) + 1);
            } 
            // if not, add entry
            else {
                entities.put(entity.getType(), 1);
            }
        }
        // print the entitylist to the chat
        Iterator<EntityType> iterator2 = entities.keySet().iterator();
        sender.sendMessage("§4[EntityHandler] §fList: " + world.getName());
        while(iterator2.hasNext()) {
            // Get the next entity type in the iteration
            EntityType entityType = (EntityType) iterator2.next();
            // get the warning amount from config
            final int amount = config.getInt("WarningAmount");
            // Send the entity types and amount! if it's over configged amount, make it red!
            if(entities.get(entityType) >= amount) {
                sender.sendMessage("§4" + entityType.name() + ": " + entities.get(entityType));
            }
            // if under set amount, make it green.
            else {
                sender.sendMessage(entityType.name() + ": §a" + entities.get(entityType));
            }
        }
        return true;
    }
}


