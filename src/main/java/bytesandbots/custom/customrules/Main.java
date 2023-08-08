package bytesandbots.custom.customrules;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.HashMap;

import org.apache.commons.codec.DecoderException;
import org.apache.commons.codec.binary.Hex;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.entity.Villager;
import org.bukkit.entity.Villager.Profession;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.Merchant;
import org.bukkit.inventory.MerchantRecipe;
import org.bukkit.inventory.PlayerInventory;
public final class Main extends JavaPlugin {
	
	List<String> PunishedPlayers = new ArrayList<String>();
	List<String> currentMMOPlayers = new ArrayList<String>();

	HashMap<String,String> MMOPlayerList = new HashMap<>();
	HashMap<String,String> CreativePlayerList = new HashMap<>();
	
	LoginListener actions;
	
	String punishedPlayerFileName = "plugins/CustomRules/punishedPlayerNames.txt";
	String mmoPlayerFileName = "plugins/CustomRules/MMOPlayerInventory.txt";
	String creativePlayerFileName = "plugins/CustomRules/CreativePlayerInventory.txt";
	String pestControlQuests = "plugins/CustomRules/pestControlQuests.txt";
	
	HashMap<String, HashMap<String, Location>> homes = new HashMap<>();
	HashMap<String,Integer> pestQuests = new HashMap<String,Integer>();
	@Override
    public void onEnable() {
        // TODO Insert logic to be performed when the plugin is enabled
		try {
		      File myObj = new File(pestControlQuests);
		      Scanner myReader = new Scanner(myObj);
		      while (myReader.hasNextLine()) {
		        String data = myReader.nextLine();
		        String[] arrOfStr = data.split(",", 2);
		        pestQuests.put(arrOfStr[0],Integer.parseInt(arrOfStr[1]));
		      }
		      myReader.close();
		      
		      
		      
		    } catch (FileNotFoundException e) {
		      //System.out.println("An error occurred. with reading the file punishedPlayerNames.txt . Maybe it's not there? Creating a new file");
		      try {
		          File myObj = new File(pestControlQuests);
		          if (myObj.createNewFile()) {
		            //System.out.println("File created: " + myObj.getName());
		          } else {
		            //System.out.println("File already exists.");
		          }
		        } catch (IOException ed) {
		          //System.out.println("An error occurred. Probably Server permissions. idk");
		          ed.printStackTrace();
		        }
		      e.printStackTrace();
		}
		
		
		try {
		      File myObj = new File(punishedPlayerFileName);
		      Scanner myReader = new Scanner(myObj);
		      while (myReader.hasNextLine()) {
		        String data = myReader.nextLine();
		        PunishedPlayers.add(data);
		      }
		      myReader.close();
		      
		      
		      
		    } catch (FileNotFoundException e) {
		      //System.out.println("An error occurred. with reading the file punishedPlayerNames.txt . Maybe it's not there? Creating a new file");
		      try {
		          File myObj = new File(punishedPlayerFileName);
		          if (myObj.createNewFile()) {
		            //System.out.println("File created: " + myObj.getName());
		          } else {
		            //System.out.println("File already exists.");
		          }
		        } catch (IOException ed) {
		          //System.out.println("An error occurred. Probably Server permissions. idk");
		          ed.printStackTrace();
		        }
		      e.printStackTrace();
		}
		
		try {
		      File myObj = new File(mmoPlayerFileName);
		      Scanner myReader = new Scanner(myObj);
		      while (myReader.hasNextLine()) {
		        String data = myReader.nextLine();
		        String[] arrOfStr = data.split(",", 2);
		        MMOPlayerList.put(arrOfStr[0], arrOfStr[1]);
		      }
		      myReader.close();
		      
		      
		      
		    } catch (FileNotFoundException e) {
		      //System.out.println("An error occurred. with reading the file punishedPlayerNames.txt . Maybe it's not there? Creating a new file");
		      try {
		          File myObj = new File(mmoPlayerFileName);
		          if (myObj.createNewFile()) {
		            //System.out.println("File created: " + myObj.getName());
		          } else {
		            //System.out.println("File already exists.");
		          }
		        } catch (IOException ed) {
		          //System.out.println("An error occurred. Probably Server permissions. idk");
		          ed.printStackTrace();
		        }
		      e.printStackTrace();
		}
		
		try {
		      File myObj = new File(creativePlayerFileName);
		      Scanner myReader = new Scanner(myObj);
		      while (myReader.hasNextLine()) {
		        String data = myReader.nextLine();
		        String[] arrOfStr = data.split(",", 2);
		        CreativePlayerList.put(arrOfStr[0], arrOfStr[1]);
		      }
		      myReader.close();
		      
		      
		      
		    } catch (FileNotFoundException e) {
		      //System.out.println("An error occurred. with reading the file punishedPlayerNames.txt . Maybe it's not there? Creating a new file");
		      try {
		          File myObj = new File(creativePlayerFileName);
		          if (myObj.createNewFile()) {
		            //System.out.println("File created: " + myObj.getName());
		          } else {
		            //System.out.println("File already exists.");
		          }
		        } catch (IOException ed) {
		          //System.out.println("An error occurred. Probably Server permissions. idk");
		          ed.printStackTrace();
		        }
		      e.printStackTrace();
		}
		actions = new LoginListener(PunishedPlayers,this);
		
	      
	    getServer().getPluginManager().registerEvents(actions , this);

		
    }
    
	
    @Override
    public void onDisable() {
        // TODO Insert logic to be performed when the plugin is disabled
    }
    
    public void WriteToFile() {
    	try {
		      FileWriter myWriter = new FileWriter(punishedPlayerFileName);
		      for (String playerUUID : PunishedPlayers) {
		    	  myWriter.write(playerUUID+"\n");
		    

		      }
		      	
		      myWriter.close();
		      //System.out.println("Successfully saved names.");
		    } 
		catch (IOException e) {
		      //System.out.println("An error writing to file occurred.");
		      e.printStackTrace();
		    }
    	
    }
    public void saveCreativePlayers() {
    	try {
		      FileWriter myWriter = new FileWriter(creativePlayerFileName);
		      for (Map.Entry<String, String> player : CreativePlayerList.entrySet()) {
		    	  String uuid = player.getKey();
		    	  String inventory = player.getValue();
		    	  
		    	  
		    	  
		    	  myWriter.write(uuid+","+inventory +"\n");
		    

		      }
		      	
		      myWriter.close();
		      //System.out.println("Successfully saved names.");
		    } 
		catch (IOException e) {
		      //System.out.println("An error writing to file occurred.");
		      e.printStackTrace();
		    }
    	
    }
    
    public void saveMMOPlayers() {
    	try {
		      FileWriter myWriter = new FileWriter(mmoPlayerFileName);
		      for (Map.Entry<String, String> player : MMOPlayerList.entrySet()) {
		    	  String uuid = player.getKey();
		    	  String inventory = player.getValue();
		    	  
		    	  
		    	  
		    	  myWriter.write(uuid+","+inventory +"\n");
		    

		      }
		      	
		      myWriter.close();
		      //System.out.println("Successfully saved names.");
		    } 
		catch (IOException e) {
		      //System.out.println("An error writing to file occurred.");
		      e.printStackTrace();
		    }
    	
    }
    
    public String RemovePlayertoPunishList(String name) {
    	Player p = Bukkit.getPlayer(name);
    	if(p == null) {
    		
    		return "Problem finding player";
    	}
    	String uuid = p.getUniqueId().toString();
    	if(PunishedPlayers.contains(uuid)) {
    		PunishedPlayers.remove(uuid);
    		actions.unPunish(p);
    		WriteToFile();
    		return "Player: "+name+" Removed";
    	}
    	
    	return "Player: "+name+" is not punished";

    	
    	
    }
    
    
    public String AddPlayertoPunishList(String name) {
    	Player p = Bukkit.getPlayer(name);
    	if(p == null) {
    		
    		return "Problem finding player";
    	}
    	String uuid = p.getUniqueId().toString();
    	if(!PunishedPlayers.contains(uuid)) {
    		PunishedPlayers.add(uuid);
    		actions.Punish(p);
    		
    		WriteToFile();
    		
    		return "Done";
    	}
    	else {
    		return "Player "+name+" is already punished";
    		
    	}
    	
    	
    	
    }
    
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
     
    	Player player = (Player) sender;
    	if (cmd.getName().equalsIgnoreCase("mmo")) {
    		if(!currentMMOPlayers.contains(player.getUniqueId().toString()) ) {
    			currentMMOPlayers.add(player.getUniqueId().toString());
	    		World curWorld=player.getLocation().getWorld();
	             Location location = new Location (curWorld,43,88,623);
	             player.teleport(location);
	             saveCreativeInventory(player);
	             loadMMOInventory(player); 
    		}
    		else {
    			player.sendMessage("You are already on MMO mode. If you want to leave type /unmmo .");
    			
    		}
             
    	}
    	else if (cmd.getName().equalsIgnoreCase("unmmo")) {
    		
    		if(!currentMMOPlayers.contains(player.getUniqueId().toString()) ) {
    			player.sendMessage("You are not in MMO mode. Type /mmo to start.");
    		}
    		else {
    			currentMMOPlayers.remove(player.getUniqueId().toString());
    			World curWorld=player.getLocation().getWorld();
                Location location = new Location (curWorld,67,65,-256);
                player.teleport(location);
	             saveMMOInventory(player);
	             loadCreativeInventory(player); 
    			
    		}	
    		
    	}
    		
    	
    	if(currentMMOPlayers.contains(player.getUniqueId().toString())) {
    		
    		return false;
    	}
    	
    	
    	
 
    	if(cmd.getName().equalsIgnoreCase("punish")) {
    		if (player.isOp()) {
    		    // Do something
    			if(args.length == 1) {
	    			String playerName = args[0];
	    			String response =  AddPlayertoPunishList(playerName);
	    			player.sendMessage(response);
    			}
    			else if(args.length > 1) {
    				player.sendMessage("Too many arguments. ex. /punish <playername>");
    				
    			}
    			else if(args.length < 1) {
    				
    				//player.sendMessage("Need a name. ex. /punish <playername>");
    				String playerName = player.getName();
	    			String response =  AddPlayertoPunishList(playerName);
	    			player.sendMessage(response);
    			}
    			
    		}
    		else {
    			
    			player.sendMessage("Only OP can set this command :(");
    		}
    		
    	}
    	else if(cmd.getName().equalsIgnoreCase("unpunish")) {
    		if (player.isOp()) {
    		    // Do something
    			if(args.length == 1) {
	    			String playerName = args[0];
	    			String response =  RemovePlayertoPunishList(playerName);
	    			player.sendMessage(response);
    			}
    			else if(args.length > 1) {
    				player.sendMessage("Too many arguments. ex. /unpunish <playername>");
    				
    			}
    			else if(args.length < 1) {
    				
    				//player.sendMessage("Need a name. ex. /unpunish <playername>");
    				String playerName = player.getName();
	    			String response =  RemovePlayertoPunishList(playerName);
	    			player.sendMessage(response);
    			}
    			
    		}
    		else {
    			
    			player.sendMessage("Only OP can set this command :(");
    		}
    		
    	}
    	

    	else if( cmd.getName().equalsIgnoreCase("breakable")) {
    		if(player.isOp()) {
    			actions.canOPbreak = !actions.canOPbreak;
    			if(actions.canOPbreak) {
    				player.sendMessage("You can break stuff");
    				
    			}
    			else {
    				player.sendMessage("breaking stuff is now blocked");
    				
    			}
    			
    		}
    		
    		
    	}
    	
    	
    	else if (cmd.getName().equalsIgnoreCase("sethome")) {
    		if (args.length == 1) {
    			String homeName = args[0];
    			if (homes.containsKey(player.getUniqueId().toString())){
    				HashMap<String, Location> currenthomes = homes.get(player.getUniqueId().toString());
    				currenthomes.put(homeName, player.getLocation());
    				homes.put(player.getUniqueId().toString(), currenthomes);
    				player.sendMessage("You set a home");
    			}
    			else{
    				HashMap<String, Location> newhome = new HashMap<>();
    				newhome.put(homeName, player.getLocation());
    				homes.put(player.getUniqueId().toString(), newhome);
    				player.sendMessage("You set a home");
    			}
    		}
    		else {
    			player.sendMessage(ChatColor.RED + "You have not set a home name, please do /sethome <name>");
    		}
    		return true;
    	}
    	else if (cmd.getName().equalsIgnoreCase("homes")) {
    		if (args.length < 1) {
    			if (homes.containsKey(player.getUniqueId().toString())) {
    				player.sendMessage(ChatColor.YELLOW + "Homes: ");
    				for (Map.Entry<String, Location> allhomes : homes.get(player.getUniqueId().toString()).entrySet()) {
    					player.sendMessage(ChatColor.GOLD + allhomes.getKey());
    				}
    			}
    		}
    		return true;
    	}
    	else if (cmd.getName().equalsIgnoreCase("home")) {
    		if (args.length == 1) {
    			if (homes.containsKey(player.getUniqueId().toString())) {
    				HashMap<String, Location> gethomes = homes.get(player.getUniqueId().toString());
    				if (gethomes.containsKey(args[0])) {
    					player.teleport(gethomes.get(args[0]));
    					player.sendMessage(ChatColor.YELLOW + "Sent you to " + ChatColor.GOLD + args[0]);
    				}
    			}
    			else {
    				player.sendMessage(ChatColor.GOLD  + "Sorry, you have no homes!");
    			}
    		}
    	}
    	else if (cmd.getName().equalsIgnoreCase("survival")) {
    		player.setGameMode(GameMode.SURVIVAL);
    			
    	}
    	else if (cmd.getName().equalsIgnoreCase("creative")) {
    			player.setGameMode(GameMode.CREATIVE);
    			player.sendMessage(ChatColor.GOLD  + "Enjoy Creative.");
    			
    	
    		
    				
    	}
    	else if (cmd.getName().equalsIgnoreCase("Curryisdelicous")){
    				player.sendMessage("FOOD");
    				ItemStack mutton=new ItemStack(Material.COOKED_MUTTON,64);
    				player.getInventory().addItem(mutton);
    				return true;
    		
    	}
    	else if (cmd.getName().equalsIgnoreCase("hummus")){
    		player.sendMessage("CARROTS AND HUMMUS MUAHAHAHAHAHAHAHAHA");
    		player.addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE,Integer.MAX_VALUE,50));
    		player.addPotionEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE,Integer.MAX_VALUE,255));
    		player.addPotionEffect(new PotionEffect(PotionEffectType.REGENERATION,Integer.MAX_VALUE,255));
    		player.addPotionEffect(new PotionEffect(PotionEffectType.SPEED,500,255));
    		
    		return true;
    	}
    	else if (cmd.getName().equalsIgnoreCase("pvp")){
    		World curWorld = player.getLocation().getWorld();
          	 Location location = new Location(curWorld,103,65,-257);
          	 player.teleport(location);
          	 return true;
    	}
    	
    	
    		
    	
    	else if(cmd.getName().equalsIgnoreCase("createTrader")) {
    		if(player.isOp()) {
	    		Villager v = (Villager) player.getWorld().spawnEntity(player.getLocation(), EntityType.VILLAGER);
	    		String customName = "Custom Villager";
	    		if (args.length == 1) {
		    		 
	    			customName = args[0];
		             
	    		}
	    		
	    		
	    		if(args.length == 2) {
	    			Profession newProf = Profession.NONE;
	    			customName = args[0];
	    			switch(args[1]) {
		    			case "armorer":
		    				newProf = Profession.ARMORER;
		    				
			    		case "butcher":
		    				newProf = Profession.BUTCHER;
		    			
			    		case "cartographer":
							newProf = Profession.CARTOGRAPHER;
						
				    	case "cleric":
							newProf = Profession.CLERIC;
							
				    	case "farmer":
							newProf = Profession.FARMER;
						
				    	case "fisherman":
							newProf = Profession.FISHERMAN;
						
				    	case "fletcher":
							newProf = Profession.FLETCHER;
						
				    	case "leatherworker":
							newProf = Profession.LEATHERWORKER;
						
				    	case "librarian":
							newProf = Profession.LIBRARIAN;
						
				    	case "mason":
							newProf = Profession.MASON;
						
				    	case "nitwit":
							newProf = Profession.NITWIT;
						
				    	case "shepherd":
							newProf = Profession.SHEPHERD;
						
				    	case "toolsmith":
							newProf = Profession.TOOLSMITH;
							
				    	case "weaponsmith":
							newProf = Profession.WEAPONSMITH;
						}
    	
    	
		    			v.setProfession(newProf);
	    		}
	    		
	    		v.setCustomName(customName);
	    		v.setAI(false);
	    		player.sendMessage("Villager created!");

	            
    		}
    		else {
    			player.sendMessage("only OP can summon a villager :(");
    		}
    		return true;
    		
    	}
    	
    	
    	
    	else if(cmd.getName().equalsIgnoreCase("pestcontrol")) {
    		Map<EntityType,Integer>kills = actions.killCount.get(player.getUniqueId().toString());
    		
    		Boolean completedAll = true;
    		for(Map.Entry<String, Integer> mob : pestQuests.entrySet()) {
    			EntityType mobToKill = EntityType.valueOf(mob.getKey().toUpperCase());
    			if(kills == null) {
    				completedAll = false;
    				player.sendMessage("Your new objective is to kill "+Integer.toString(mob.getValue()) + " " +mob.getKey().toString() );
    				break;
        			
        		}
    			
    			if(kills.containsKey(mobToKill)) {
	    			int mobsKilled = kills.get(mobToKill);
	    			if(mobsKilled < mob.getValue()) {
	    				completedAll = false;
	    				int remaining = mobsKilled - mob.getValue();
	    				player.sendMessage("You still need to defeat "+Integer.toString(remaining) + " " +mob.getKey().toString() );
	    				break;
	    			}
    			}
    			else {
    				completedAll = false;
    				player.sendMessage("Your new objective is to kill "+Integer.toString(mob.getValue()) + " " +mob.getKey().toString() );
    				break;
    			}
    			
    		}
    		if(completedAll) {
    			player.sendMessage("Congrats! You are done! Check back tommorow");
    			
    		}
    		return true;
    		
    	}
    	
    	return false; 
    }

public void loadCreativeInventory(Player p) {
   	 p.getInventory().clear();
      	 p.getInventory().setBoots(new ItemStack(Material.AIR));
      	 p.getInventory().setChestplate(new ItemStack(Material.AIR));
      	 p.getInventory().setLeggings(new ItemStack(Material.AIR));
      	 p.getInventory().setHelmet(new ItemStack(Material.AIR)); 
      	 p.setGameMode(GameMode.CREATIVE);
      	 
      	if(!CreativePlayerList.containsKey(p.getUniqueId().toString())) {
      		
      		 return;
      	 }
      	 
      	 String unSerializedString = CreativePlayerList.get(p.getUniqueId().toString());
      	String[] inventory = {};
      	 
      	 
      	ByteArrayInputStream in = null;
   	try {
   		in = new ByteArrayInputStream(Hex.decodeHex(unSerializedString.toCharArray()));
   	} catch (DecoderException e1) {
   		// TODO Auto-generated catch block
   		e1.printStackTrace();
   	}
   	
       try {
   		inventory = (String[]) new ObjectInputStream(in).readObject();
   	} catch (ClassNotFoundException e) {
   		// TODO Auto-generated catch block
   		e.printStackTrace();
   	} catch (IOException e) {
   		// TODO Auto-generated catch block
   		e.printStackTrace();
   	}
       
       try {
       	p.getInventory().setContents(InventorySerialization.itemStackArrayFromBase64(inventory[0]));
       	p.getInventory().setArmorContents(InventorySerialization.itemStackArrayFromBase64(inventory[1]));
   		
   	} catch (IOException e) {
   		// TODO Auto-generated catch block
   		e.printStackTrace();
   	}
       
   	 
    }
    
 public void loadMMOInventory(Player p) {
	 p.getInventory().clear();
   	 p.getInventory().setBoots(new ItemStack(Material.AIR));
   	 p.getInventory().setChestplate(new ItemStack(Material.AIR));
   	 p.getInventory().setLeggings(new ItemStack(Material.AIR));
   	 p.getInventory().setHelmet(new ItemStack(Material.AIR)); 
   	 p.setGameMode(GameMode.SURVIVAL);
   	 
   	 if(!MMOPlayerList.containsKey(p.getUniqueId().toString())) {
   		 return;
   	 }
   	 
   	 String unSerializedString = MMOPlayerList.get(p.getUniqueId().toString());
   	String[] inventory = {};
   	 
   	 
   	ByteArrayInputStream in = null;
	try {
		in = new ByteArrayInputStream(Hex.decodeHex(unSerializedString.toCharArray()));
	} catch (DecoderException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}
	
    try {
		inventory = (String[]) new ObjectInputStream(in).readObject();
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
    
    try {
    	p.getInventory().setContents(InventorySerialization.itemStackArrayFromBase64(inventory[0]));
    	p.getInventory().setArmorContents(InventorySerialization.itemStackArrayFromBase64(inventory[1]));
		
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
    
	 
 }
    
    
 public void saveCreativeInventory(Player p) {
    	
    	String[] serializedInventory = InventorySerialization.playerInventoryToBase64(p.getInventory());
    	ByteArrayOutputStream out = new ByteArrayOutputStream();
        try {
			new ObjectOutputStream(out).writeObject(serializedInventory);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

        // your string
        String bpString = new String(Hex.encodeHex(out.toByteArray()));
        
        CreativePlayerList.put(p.getUniqueId().toString(),bpString);
    	
    	saveMMOPlayers();
    	
    }
    
    public void saveMMOInventory(Player p) {
    	
    	String[] serializedInventory = InventorySerialization.playerInventoryToBase64(p.getInventory());
    	ByteArrayOutputStream out = new ByteArrayOutputStream();
        try {
			new ObjectOutputStream(out).writeObject(serializedInventory);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

        // your string
        String bpString = new String(Hex.encodeHex(out.toByteArray()));
        
    	MMOPlayerList.put(p.getUniqueId().toString(),bpString);
    		
    
    	saveMMOPlayers();
    	
    }

}
