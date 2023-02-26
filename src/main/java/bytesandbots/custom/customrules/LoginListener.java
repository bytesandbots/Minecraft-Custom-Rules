package bytesandbots.custom.customrules;

import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.ItemStack;

import net.md_5.bungee.api.ChatColor;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;

public final class LoginListener implements Listener {
	
	public List<String> punishedPlayers = new ArrayList<String>();
	
	public LoginListener(List<String> ListOfUUIDs) {
		punishedPlayers.clear();
		for (String uuid : ListOfUUIDs) {
			punishedPlayers.add(uuid);
		}
	}
	public void unPunish(Player p) {
		
		p.sendMessage(ChatColor.GREEN + "Nice. You are now free. No more messing around.");
      	 World curWorld = p.getLocation().getWorld();
      	 Location location = new Location(curWorld,97,69,-238);
      	 Location bedlocation = new Location(curWorld,97,69,-238);
      	 p.teleport(location);
      	 p.setGameMode(GameMode.CREATIVE);
      	 p.setBedSpawnLocation(bedlocation,true);
	}
	public void Punish(Player p) {
	
       	 
       	 p.sendMessage(ChatColor.RED + "Looks like you are punished.");
       	 World curWorld = p.getLocation().getWorld();
       	 Location location = new Location(curWorld,68.094,73,-217.981);
       	 Location bedlocation = new Location(curWorld,67,73,-218);
       	 p.teleport(location);
       	 p.getInventory().clear();
       	 p.getInventory().setBoots(new ItemStack(Material.AIR));
       	 p.getInventory().setChestplate(new ItemStack(Material.AIR));
       	 p.getInventory().setLeggings(new ItemStack(Material.AIR));
       	 p.getInventory().setHelmet(new ItemStack(Material.AIR)); 
       	 p.setGameMode(GameMode.ADVENTURE);
       	 p.setBedSpawnLocation(bedlocation,true);
       
	}
	
	
	
	@EventHandler
    public void onPlayerJoin(PlayerJoinEvent e) {
    	Player p = e.getPlayer();
        if(p.hasPlayedBefore()) { //This will only send the message if the player hasn't played on the server before.
             p.sendTitle("Welcome back!" ,"Remember to play nice.",10,70,20);
             
             if(punishedPlayers.contains(p.getUniqueId().toString()))//.equals("6611b302-7284-4632-9921-f06eed4f837d")) {
             {
            	Punish(p);
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
		
		
		int specialButtonsX = 80;
		int specialButtonsX2 = 82;

		int specialButtonsY = 66;
		int specialButtonsZ = -242;
		int specialButtonsZ2 = -241;
		
        Block block = event.getBlock();
        Player player = event.getPlayer();
        
        //player.sendMessage(String.valueOf(block.getX())+" , " +String.valueOf(block.getY())+" , " +String.valueOf(block.getZ()));
        
        if(block.getX() >= pos1X && block.getX() <= pos2X) {
        	//player.sendMessage("x works");
        	if(block.getY() >= pos1Y && block.getY() <= pos2Y) {
        		//player.sendMessage("y works");
        		if(block.getZ() >= pos1Z && block.getZ() <= pos2Z) {
        			//player.sendMessage("z works");
        			//block.getWorld().getBlockAt(block.getX(), block.getY(), block.getZ()).setType(Material.GLASS,true);
        			event.setCancelled(true);
        			//player.sendMessage("Please don't break this");
        		}
        		
        	}
        	
        }
        
        if(block.getX() == specialButtonsX || block.getX() == specialButtonsX2 ) {
            if(block.getZ() == specialButtonsZ || block.getZ() == specialButtonsZ2 ) {
	        	if(block.getY() == specialButtonsY ) {
	        		
	        		event.setCancelled(true);
	        	}
        	
            }
        }
        
  
    }
	//82 66 -242
	//80 66 -242
	@EventHandler
    public void onPlayerInteract(PlayerInteractEvent event) {
		int specialButtonsX = 80;
		int specialButtonsX2 = 82;

		int specialButtonsY = 66;
		int specialButtonsZ = -242;
		
		if (event.getAction() == Action.RIGHT_CLICK_BLOCK) {
			Block clicked = event.getClickedBlock();
			if (clicked != null) {
				if (clicked.getType().name().endsWith("_BUTTON")) {
					Player player = event.getPlayer();
			        if(clicked.getY() == specialButtonsY && clicked.getZ() == specialButtonsZ) {
			        	if(clicked.getX() == specialButtonsX2 ) {
			        		player.setGameMode(GameMode.SURVIVAL);
			        		player.sendMessage("You are now in Survival Mode!");
			        	}
			        	if(clicked.getX() == specialButtonsX ) {
			        		
			        		player.setGameMode(GameMode.CREATIVE);
			        		player.sendMessage("You are now in Creative Mode!");
			        	}
			        	
			        }
			        	
			        
					
					
					
                }
			}
		}
	}
	
}
