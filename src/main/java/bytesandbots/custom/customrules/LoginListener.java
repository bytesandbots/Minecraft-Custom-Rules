package bytesandbots.custom.customrules;

import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.ItemStack;

import net.md_5.bungee.api.ChatColor;

import org.bukkit.Color;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;

public final class LoginListener implements Listener {
	
	@EventHandler
    public void onPlayerJoin(PlayerJoinEvent e) {
    	Player p = e.getPlayer();
        if(p.hasPlayedBefore()) { //This will only send the message if the player hasn't played on the server before.
             p.sendTitle("Welcome back!" ,"Remember to play nice.",10,70,20);
             
             if(p.getUniqueId().toString().equals("6611b302-7284-4632-9921-f06eed4f837d")) {
            	 
            	 p.sendMessage(ChatColor.RED + "woweee");
            	 World curWorld = p.getLocation().getWorld();
            	
            	 Location location = new Location(curWorld,68.094,73,-217.981);
            	 Location bedlocation = new Location(curWorld,67,73,-218);
            	 p.teleport(location);
            	 
            	 p.getInventory().clear();
            	 p.getInventory().setBoots(new ItemStack(Material.AIR));
            	 p.getInventory().setChestplate(new ItemStack(Material.AIR));
            	 p.getInventory().setLeggings(new ItemStack(Material.AIR));
            	 p.getInventory().setBoots(new ItemStack(Material.AIR));
            	 
            	 p.setGameMode(GameMode.ADVENTURE);
            	 p.setBedSpawnLocation(bedlocation);
            	 
             }
        }
        else {
        	p.sendTitle("Welcome!","Play nice.",10,70,20);
        }
             
      
    }
	
	@EventHandler
    public void onPlayerBreakBlock(BlockBreakEvent event) {
		
		//pos1 = 69 72 -220
		//pos2 = 66 72 -217
		
		int pos1X = 66;
		int pos1Y = 72;
		int pos1Z = -220;
		
		int pos2X = 69;
		int pos2Y = 76;
		int pos2Z = -217;
		
        Block block = event.getBlock();
        Player player = event.getPlayer();
        
        player.sendMessage(String.valueOf(block.getX())+" , " +String.valueOf(block.getY())+" , " +String.valueOf(block.getZ()));
        
        if(block.getX() >= pos1X && block.getX() <= pos2X) {
        	player.sendMessage("x works");
        	if(block.getY() >= pos1Y && block.getY() <= pos2Y) {
        		player.sendMessage("y works");
        		if(block.getZ() >= pos1Z && block.getZ() <= pos2Z) {
        			player.sendMessage("z works");
        			block.getWorld().getBlockAt(block.getX(), block.getY(), block.getZ()).setType(Material.GLASS,true);
        			player.sendMessage("block replaced!");
        		}
        		
        	}
        	
        }
        
  
    }
	
}
