package bytesandbots.custom.customrules;

import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockFromToEvent;
import org.bukkit.event.block.BlockPistonExtendEvent;
import org.bukkit.event.block.BlockPistonRetractEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.event.player.PlayerInteractAtEntityEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.Merchant;
import org.bukkit.inventory.MerchantRecipe;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.plugin.Plugin;
import org.bukkit.potion.PotionEffect;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.entity.Villager;
import org.bukkit.entity.Villager.Profession;
import org.bukkit.event.EventHandler;

public final class LoginListener implements Listener {
	
	public List<String> punishedPlayers = new ArrayList<String>();
	public boolean canOPbreak;
	public List<Block> blocksToRegenerate = new ArrayList<Block>();
	public List<Material> matToRegenerate = new ArrayList<Material>();
	
	public List<String> arenaPlayers = new ArrayList<String>();
	
	public Map<String,Map<EntityType,Integer>> killCount = new HashMap<String,Map<EntityType,Integer>>();
	
	public Map<String,ItemStack[]> PVPInventories = new HashMap<String,ItemStack[]>();
	public Plugin plugin;
	public LoginListener(List<String> ListOfUUIDs, Plugin p) {
		plugin = p;
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
	public boolean brokeButtons(Block block) {
		int specialButtonsX = 80;
		int specialButtonsX2 = 82;

		int specialButtonsY = 67;
		int specialButtonsY2 = 65;
		//int specialButtonsZ = -242;
		int specialButtonsZ2 = -241;
		
		
		if(block.getX() <= specialButtonsX2 && block.getX() >= specialButtonsX  ) {
            
            if(block.getZ() == specialButtonsZ2  ) {
            	if(block.getY() <= specialButtonsY && block.getY() >= specialButtonsY2 ) {
            	
            		if(!canOPbreak ) {
	        			return true;
        			}
            	}
            }
	        	
	        		 
        }
		
		
		
        return false;
		
	}
	public boolean brokePrison(Block block) {
		int pos1X = 66;
		int pos1Y = 72;
		int pos1Z = -220;
		
		int pos2X = 69;
		int pos2Y = 76;
		int pos2Z = -217;
		
        //player.sendMessage(String.valueOf(block.getX())+" , " +String.valueOf(block.getY())+" , " +String.valueOf(block.getZ()));
        
        if(block.getX() >= pos1X && block.getX() <= pos2X) {
        	//player.sendMessage("x works");
        	if(block.getY() >= pos1Y && block.getY() <= pos2Y) {
        		//player.sendMessage("y works");
        		if(block.getZ() >= pos1Z && block.getZ() <= pos2Z) {
        			//player.sendMessage("z works");
        			//block.getWorld().getBlockAt(block.getX(), block.getY(), block.getZ()).setType(Material.GLASS,true);
        			if(!canOPbreak ) {
        				return true;
        			}
        			//player.sendMessage("Please don't break this");
        		}
        		
        	}
        	
        }
        return false;
		
	}
	
	
	//82 66 -242
	//80 66 -242
	@EventHandler
    public void onPlayerInteract(PlayerInteractEvent event) {
		int specialButtonsX = 80;
		int specialButtonsX2 = 82;

		int specialButtonsY = 66;
		int specialButtonsZ = -241;
		
		if (event.getAction() == Action.RIGHT_CLICK_BLOCK) {
			Block clicked = event.getClickedBlock();
			if (clicked != null) {
				if (clicked.getType().name().endsWith("NOTE BLOCK")) {
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
	
	@EventHandler  
	public void onPistonEvent(BlockPistonExtendEvent event)
	{      
		//Player player = event.getPlayer();
		
		for (Block block : event.getBlocks())
		{
		        
		        event.setCancelled(brokePrison(block));
		        event.setCancelled(brokeButtons(block));
		}
		
       
	}  
	@EventHandler  
	public void onPistonEvent(BlockPistonRetractEvent event)
	{      
		for (Block block : event.getBlocks())
		{
		        
		        event.setCancelled(brokePrison(block));
		        event.setCancelled(brokeButtons(block));
		}
	}
	
	@EventHandler
	public void onBlockBreak(BlockBreakEvent event) {
        Player player = event.getPlayer();
        
        if(player.isOp())
        {
        	return;
        	
        }
        
        Block block = event.getBlock();
        
        event.setCancelled(brokePrison(block));
        event.setCancelled(brokeButtons(block));
        
        //village coords
        if(block.getX() >= -50 && block.getX() <= 100) {
        	if(block.getY() <= 118 && block.getY() >= 76) {
        		if(block.getZ() >= 590 && block.getZ() <= 665) {
        			event.setCancelled(true);
        			return;
        		}
        		
        	}
        }
        		
        			

        
        //cave coords
        
        if(block.getX() >= 52 && block.getX() <= 131) {
        	if(block.getY() <= 86 && block.getY() >= 25) {
        		if(block.getZ() >= 74 && block.getZ() <= 128) {
        			
        			int delay = -1;
        	        
        	        if (block.getType() == Material.LIME_STAINED_GLASS) {
        	            delay = 5;
        	        }
        	        else if (block.getType() == Material.MAGENTA_STAINED_GLASS) {
        	            delay = 6;
        	        }
        	        else if (block.getType() == Material.RED_STAINED_GLASS) {
        	            delay = 7;
        	        }
        	        else if (block.getType() == Material.WHITE_STAINED_GLASS) {
        	            delay = 8;
        	        }
        	        else if (block.getType() == Material.ORANGE_STAINED_GLASS) {
        	            delay = 9;
        	        }
        	        else if (block.getType() == Material.IRON_ORE) {
        	            delay = 10;
        	        }
        	        else if (block.getType() == Material.DIAMOND_ORE) {
        	            delay = 11;
        	        }
        	        else {
        	        	event.setCancelled(true);
            			return;
        	        	
        	        }
        	        if(delay > -1) {
        	        	blocksToRegenerate.add(block);
        	        	matToRegenerate.add(block.getType());
        		        Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(plugin, new Runnable() {
        		            public void run() {
        		               Block b = blocksToRegenerate.get(0);
        		               b.setType(matToRegenerate.get(0));
        		               blocksToRegenerate.remove(0);
        		               matToRegenerate.remove(0);
        		            }
        		        }, delay);
        	        
        	        }   
        		}
        		
        	}
        	
        }
             
        
    }
	@EventHandler
	public void onBlockPlace(BlockPlaceEvent event)
	{
		Player player = event.getPlayer();
        
        if(player.isOp())
        {
        	return;
        	
        }
        
		Block block = event.getBlockPlaced();
		event.setCancelled(brokePrison(block));
        event.setCancelled(brokeButtons(block));
        
        
        //village
        if(block.getX() >= -43 && block.getX() <= 83) {
        	if(block.getY() <= 118 && block.getY() >= 76) {
        		if(block.getZ() >= 584 && block.getZ() <= 658) {
        			event.setCancelled(true);
        			return;
        		}
        		
        	}
        }
        		
        			

        
        
        //cavern
        if(block.getX() >= 52 && block.getX() <= 131) {
        	if(block.getY() <= 86 && block.getY() >= 25) {
        		if(block.getZ() >= 74 && block.getZ() <= 128) {
        			
        	
        	        event.setCancelled(true);
        	        
        		}
        		
        	}
        	
        }
        
	}
	
	@EventHandler
	public void onWaterPassThrough(BlockFromToEvent event){
		
		 Block block = event.getToBlock();
	        //Player player = event.getPlayer();
	        
	        event.setCancelled(brokePrison(block));
	        event.setCancelled(brokeButtons(block));
	        
	        
	        Block block2 = event.getBlock();
	        //Player player = event.getPlayer();
	        
	        event.setCancelled(brokePrison(block2));
	        event.setCancelled(brokeButtons(block2));
	        
	}
	
	@EventHandler
    public void onPlayerBreakBlock(BlockBreakEvent event) {
		Player player = event.getPlayer();
        
        if(player.isOp())
        {
        	return;
        	
        }
        
        Block block = event.getBlock();
        //Player player = event.getPlayer();
        
        event.setCancelled(brokePrison(block));
        event.setCancelled(brokeButtons(block));
        
        
        if(block.getX() >= -50 && block.getX() <= 100) {
        	if(block.getY() <= 118 && block.getY() >= 76) {
        		if(block.getZ() >= 590 && block.getZ() <= 665) {
        			event.setCancelled(true);
        			return;
        		}
        		
        	}
        }
        
        
  
    }
	
	@EventHandler
	public void onMove(PlayerMoveEvent event) {
	  //Location from = event.getFrom();
	  Location to = event.getTo();
	  
	  Player p = event.getPlayer();
	  if(to.getBlockX() > 85 && to.getBlockX()< 124) {
		  if(to.getBlockY() > 63 && to.getBlockY() < 76)
		  {
			  if(to.getBlockZ() <= -257 && to.getBlockZ() >= -300) {
				  
				  if(!arenaPlayers.contains(p.getUniqueId().toString())) {
					  
			
				  p.sendMessage("you entered the arena, break a leg");
				  World curWorld = p.getLocation().getWorld();
			       	 Location bedlocation = new Location(curWorld,103,65,-257);
			       	 ItemStack[] oldInventory = p.getInventory().getContents();
			       	PVPInventories.put(p.getUniqueId().toString(), oldInventory);
			       	
			       	 p.getInventory().clear();
			       	 p.getInventory().setBoots(new ItemStack(Material.IRON_BOOTS));
			       	 p.getInventory().setChestplate(new ItemStack(Material.IRON_CHESTPLATE));
			       	 p.getInventory().setLeggings(new ItemStack(Material.IRON_LEGGINGS));
			       	 p.getInventory().setHelmet(new ItemStack(Material.IRON_HELMET)); 
			       	 p.getInventory().setItemInMainHand(new ItemStack(Material.IRON_SWORD));
			       	 
			       	 p.setGameMode(GameMode.SURVIVAL);
			       	p.setBedSpawnLocation(bedlocation,true);
			       	ItemStack bef=new ItemStack(Material.COOKED_BEEF,10);
    				p.getInventory().addItem(bef);
    				
    				for (PotionEffect effect : p.getActivePotionEffects()) {
    			        p.removePotionEffect(effect.getType());
    				}
    				
			       	arenaPlayers.add(p.getUniqueId().toString());
				  }
			  }
			  else {
				  	if(arenaPlayers.contains(p.getUniqueId().toString())) {
					  arenaPlayers.remove(p.getUniqueId().toString());
					  p.getInventory().clear();
					  p.getInventory().setContents(PVPInventories.get(p.getUniqueId().toString()));
					  PVPInventories.remove(p.getUniqueId().toString());
				  	}
				  }
			
			  }
		  else {
			  if(arenaPlayers.contains(p.getUniqueId().toString())) {
				  arenaPlayers.remove(p.getUniqueId().toString());
				  p.getInventory().clear();
				  p.getInventory().setContents(PVPInventories.get(p.getUniqueId().toString()));
				  PVPInventories.remove(p.getUniqueId().toString());
			  }
			  
		  }
			  
		  }
	  else {
		  if(arenaPlayers.contains(p.getUniqueId().toString())) {
			  arenaPlayers.remove(p.getUniqueId().toString());
			  p.getInventory().clear();
			  p.getInventory().setContents(PVPInventories.get(p.getUniqueId().toString()));
			  PVPInventories.remove(p.getUniqueId().toString());
		  }
	  }
		  
	  }
	@EventHandler
	public void onEntityDamage(EntityDamageByEntityEvent event) {
		if (event.getEntity() instanceof Villager && event.getEntity().getCustomName() != null) {
			event.setCancelled(true);
			
		}
	}
	

	@EventHandler

    public void onVillagerClick(PlayerInteractAtEntityEvent event) {
		if (event.isCancelled()) return;
        event.setCancelled(true);
        if (!(event.getRightClicked() instanceof Villager)) return;
        
        
        Villager villager = (Villager) event.getRightClicked();
        if (!villager.isAdult()) return;
        
       
        Player player = event.getPlayer();
        if (villager.isTrading()) return;
        
    

        String customName = villager.getCustomName();
        if (customName == null){
           
            	customName = "Trader";
            	
         
        }

    //custom merchant ------------
        Merchant merchant = Bukkit.createMerchant(customName);
        List<MerchantRecipe> merchantRecipes = new ArrayList<MerchantRecipe>();

        
        //weaponsmith
		if(villager.getProfession()==Profession.WEAPONSMITH) {
			
			
			//Reciepe 1
			ItemStack sellingItem = new ItemStack(Material.IRON_SWORD, 1);
			MerchantRecipe newRecipe = new MerchantRecipe(sellingItem, 32);
		
			ItemStack buyItem1 = new ItemStack(Material.COBBLESTONE, 64);
		    newRecipe.addIngredient(buyItem1);
		    merchantRecipes.add(newRecipe);	
		    
		    //Reciepe 2

		    sellingItem = new ItemStack(Material.DIAMOND, 3);
		    newRecipe = new MerchantRecipe(sellingItem, 7);
		    
		    buyItem1 = new ItemStack(Material.IRON_INGOT, 32);
		    newRecipe.addIngredient(buyItem1);
		    merchantRecipes.add(newRecipe);
		    
		    
		  //apply
		    merchant.setRecipes(merchantRecipes);
	        villager.setRecipes(merchantRecipes);
		}
		
		else {

			//Reciepe 1
	        ItemStack sellingItem = new ItemStack(Material.COOKED_BEEF, 10);
	        MerchantRecipe newRecipe = new MerchantRecipe(sellingItem, 7);
	
	        ItemStack buyItem1 = new ItemStack(Material.IRON_INGOT, 7);
	        newRecipe.addIngredient(buyItem1);
	        merchantRecipes.add(newRecipe);
	        
	        
	        //Reciepe 2
	        sellingItem = new ItemStack(Material.COOKED_CHICKEN,10);
	        newRecipe = new MerchantRecipe(sellingItem, 7);
	
	        buyItem1 = new ItemStack(Material.COBBLESTONE, 32);
	        newRecipe.addIngredient(buyItem1);
	        merchantRecipes.add(newRecipe);
	        
	        
	        
	      //apply
	        merchant.setRecipes(merchantRecipes);
	        villager.setRecipes(merchantRecipes);
		}   

        player.openMerchant(merchant, true);
    }
	
	
	
	
	
	@EventHandler
	  public void onDeath(EntityDeathEvent e){
	    Entity entity = e.getEntity();
	    Entity killer = e.getEntity().getKiller();
	  
	    if (killer instanceof Player){
	    	if(entity.getType().equals(EntityType.ZOMBIE)) {
	    		Map<EntityType,Integer>kills = new HashMap<EntityType,Integer>();
    			int count = 1;
    			
	    		if(killCount.containsKey(killer.getUniqueId().toString())) {
	    			kills = killCount.get(killer.getUniqueId().toString());
	    		
	    			if(kills.containsKey(entity.getType())){
	    				count = kills.get(entity.getType());
	    				count += 1;
	    				
	    			}
	    			
	    		}
	    		kills.put(entity.getType(), count);
	    		killCount.put(killer.getUniqueId().toString(), kills);
	    		
	    	}
	      //your code
	    }
	  }
	
	
	
	
}
