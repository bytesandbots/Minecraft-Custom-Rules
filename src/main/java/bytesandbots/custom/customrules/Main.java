package bytesandbots.custom.customrules;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.util.Vector;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
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
import org.bukkit.NamespacedKey;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Fireball;
import org.bukkit.entity.Player;
import org.bukkit.entity.Villager;
import org.bukkit.entity.Villager.Profession;
import org.bukkit.entity.Wither;
import org.bukkit.inventory.ItemStack;
public final class Main extends JavaPlugin {
	
	List<String> PunishedPlayers = new ArrayList<String>();
	List<String> currentMMOPlayers = new ArrayList<String>();

	HashMap<String,String> MMOPlayerList = new HashMap<>();
	HashMap<String,String> CreativePlayerList = new HashMap<>();
	
	LoginListener actions;
	LeifsArena arenamode;

	
	String punishedPlayerFileName = "plugins/CustomRules/punishedPlayerNames.txt";
	String mmoPlayerFileName = "plugins/CustomRules/MMOPlayerInventory.txt";
	String creativePlayerFileName = "plugins/CustomRules/CreativePlayerInventory.txt";
	String pestControlQuests = "plugins/CustomRules/pestControlQuests.txt";
	
	HashMap<String, HashMap<String, Location>> homes = new HashMap<>();
	HashMap<Integer,Map<String,Integer>> pestQuests = new HashMap<Integer,Map<String,Integer>>();
	HashMap<String,List<String>>invite = new HashMap<>();
	HashMap<String,List<String>>Groups = new HashMap<>();
	@Override
    public void onEnable() {
        // TODO Insert logic to be performed when the plugin is enabled
		try {
		      File myObj = new File(pestControlQuests);
		      Scanner myReader = new Scanner(myObj);
		      int i = 0;
		      while (myReader.hasNextLine()) {
		        String data = myReader.nextLine();
		        String[] arrOfStr = data.split(",", 2);
		        HashMap<String,Integer> detail = new HashMap<>();
		        detail.put(arrOfStr[0],Integer.parseInt(arrOfStr[1]));
		        pestQuests.put(i,detail);
		        i++;
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
		arenamode = new LeifsArena(this);
		actions = new LoginListener(PunishedPlayers,arenamode,this);
		
	      
	    getServer().getPluginManager().registerEvents(actions , this);
	    NamespacedKey nn = new NamespacedKey(this, "rum");
	    getServer().addRecipe(new Recipes().Rum(nn));
	    NamespacedKey key1 = new NamespacedKey(this, "titanium_sword");
	    getServer().addRecipe(new Recipes().Titanium_Sword(key1));
	    NamespacedKey key2 = new NamespacedKey(this, "aetherstone_sword");
	    getServer().addRecipe(new Recipes().Aetherstone_Sword(key2));
	    NamespacedKey key3 = new NamespacedKey(this, "bloodsteel_sword");
	    getServer().addRecipe(new Recipes().BloodSteel_Sword(key3));
	    NamespacedKey key4 = new NamespacedKey(this, "compacted_diamond");
	    getServer().addRecipe(new Recipes().compactedDiamond(key4));
	    NamespacedKey key5 = new NamespacedKey(this, "compacted_aetherstone");
	    getServer().addRecipe(new Recipes().compactedAetherstone(key5));
	    NamespacedKey key6 = new NamespacedKey(this, "compacted_bloodsteel");
	    getServer().addRecipe(new Recipes().compactedBloodsteel(key6));
	    NamespacedKey key7 = new NamespacedKey(this, "compacted_iron");
	    getServer().addRecipe(new Recipes().compactedIron(key7));
	    NamespacedKey key8 = new NamespacedKey(this, "compacted_koshil");
	    getServer().addRecipe(new Recipes().compactedKoshil(key8));
	    NamespacedKey key9 = new NamespacedKey(this, "compacted_titanium");
	    getServer().addRecipe(new Recipes().compactedTitanium(key9));
	    NamespacedKey key10 = new NamespacedKey(this, "holy_beacon");
	    getServer().addRecipe(new Recipes().HolyBeacon(key10));
	    NamespacedKey key11 = new NamespacedKey(this, "refined_diamond_sword");
	    getServer().addRecipe(new Recipes().RefinedDiamondSword(key11));
	    NamespacedKey key12 = new NamespacedKey(this, "obsidian_sword");
	    getServer().addRecipe(new Recipes().ObsidianSword(key12));
	    
	    NamespacedKey key13 = new NamespacedKey(this, "koshil_sword");
	    getServer().addRecipe(new Recipes().KoshilSword(key13));
	    NamespacedKey key14 = new NamespacedKey(this, "adamant_sword");
	    getServer().addRecipe(new Recipes().AdamantSword(key14));
	    
	    
	    NamespacedKey key15 = new NamespacedKey(this, "soulfury");
	    getServer().addRecipe(new Recipes().SoulFury(key15));
	    NamespacedKey key16 = new NamespacedKey(this, "soulstriker");
	    getServer().addRecipe(new Recipes().SoulStriker(key16));
	    NamespacedKey key17 = new NamespacedKey(this, "darkbane");
	    getServer().addRecipe(new Recipes().DarkBane(key17));
	    NamespacedKey key18 = new NamespacedKey(this, "reaper_scythe");
	    getServer().addRecipe(new Recipes().DarkBane(key18));
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
	             for (PotionEffect effect : player.getActivePotionEffects()) {
	                 player.removePotionEffect(effect.getType());
	             }
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
    	else if(cmd.getName().equalsIgnoreCase("fight")) {
    		if(args.length == 1) {
    			World curWorld = player.getLocation().getWorld();
    			Location arena = new Location(curWorld, 90, 65, -233);
    			player.teleport(arena);
    			player.setGameMode(GameMode.SURVIVAL);
    			
    			String Playerinvite = args[0];
    			Player other = Bukkit.getPlayer(Playerinvite);
    			other.teleport(arena);
    			other.setGameMode(GameMode.SURVIVAL);
    			return true;
    		}
    		return false;
					
    	}
    	//10, 65, -305: Coordinates of new arena
    	else if(cmd.getName().equalsIgnoreCase("arenamode")) {
    		World curWorld = player.getLocation().getWorld();
			Location arena = new Location(curWorld, 11, 60, -305);
			player.teleport(arena);
			player.setGameMode(GameMode.SURVIVAL);
			player.sendTitle("Welcome to the arena!", "(The new one.)", 10, 70, 20);
			arenamode.startGame(player);
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
    		//player.addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE,Integer.MAX_VALUE,50));
    		//player.addPotionEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE,Integer.MAX_VALUE,255));
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
    	else if (cmd.getName().equalsIgnoreCase("gohome")){
    		if(!player.isOp()) {
    			return false;
    			
    		}
    		World curWorld = player.getLocation().getWorld();
          	 Location location = new Location(curWorld,67,65,-256);
          	 player.teleport(location);
          	 return true;
    	}
    	else if (cmd.getName().equalsIgnoreCase("gommo")){
    		if(!player.isOp()) {
    			return false;
    			
    		}
    		World curWorld = player.getLocation().getWorld();
          	 Location location = new Location(curWorld,43,88,623);
          	 player.teleport(location);
          	 return true;
    	}
    	else if (cmd.getName().equalsIgnoreCase("test")){
    		if(!player.isOp()) {
    			return false;
    			
    		}
    		
    	
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
    		Map<String,Integer>SpecialKills = actions.namedKillCount.get(player.getUniqueId().toString());
    		
    		
    		Boolean completedAll = true;
    		for(Map.Entry<Integer, Map<String, Integer>> orderedEnemy : pestQuests.entrySet()) {
    			
    			for(Map.Entry<String, Integer> mob : orderedEnemy.getValue().entrySet()) {
    			
	    			boolean special = false;
	    			String[] specials = {"Reaper Fanatic","Reaper BloodEater"};
	    	    	for(String specialEnemy : specials) {
	    	    		if(mob.getKey().equals(specialEnemy)) {
	    	    			
	    	    			special = true;
	    	    		}
	    	    	}
	    	    	
	    	    	
	    	    	
	    	    	if(!special) {
	    	    		if(kills == null) {
	        				completedAll = false;
	        				System.out.println("nothing found");
	        				player.sendMessage("Your new objective is to kill "+Integer.toString(mob.getValue()) + " " +mob.getKey().toString() );
	        				return true;
	            			
	            		}
	    	    		EntityType mobToKill = EntityType.valueOf(mob.getKey().toUpperCase());
	    	    		if(kills.containsKey(mobToKill)) {
	    	    			int mobsKilled = kills.get(mobToKill);
	    	    			if(mobsKilled < mob.getValue()) {
	    	    				completedAll = false;
	    	    				int remaining = mob.getValue() - mobsKilled;
	    	    				player.sendMessage("You still need to defeat "+Integer.toString(remaining) + " " +mob.getKey().toString() );
	    	    				return true;
	    	    			}
	        			}
	        			else {
	        				completedAll = false;
	        				System.out.println("New Object non special");
	        				player.sendMessage("Your new objective is to kill "+Integer.toString(mob.getValue()) + " " +mob.getKey().toString() );
	        				return true;
	        			}
	    	    	}
	    	    	else {
	    	    		if(SpecialKills == null) {
	        				completedAll = false;
	        				player.sendMessage("Your new SPECIAL objective is to kill "+Integer.toString(mob.getValue()) + " " +mob.getKey().toString() );
	        				return true;
	            			
	            		}
	    	    		String mobToKill = mob.getKey();
	    	    		if(SpecialKills.containsKey(mobToKill)) {
	    	    			int mobsKilled = SpecialKills.get(mobToKill);
	    	    			if(mobsKilled < mob.getValue()) {
	    	    				completedAll = false;
	    	    				int remaining =mob.getValue() - mobsKilled;
	    	    				player.sendMessage("You still need to defeat SPECIAL "+Integer.toString(remaining) + " " +mob.getKey().toString() );
	    	    				return true;
	    	    			}
	        			}
	        			else {
	        				completedAll = false;
	        				System.out.println("New Object special");
	        				player.sendMessage("Your new objective is to kill SPECIAL "+Integer.toString(mob.getValue()) + " " +mob.getKey().toString() );
	        				return true;
	        			}
	    	    		
	    	    	}
	    	    	
	    	    	
	    		
	    			
	    			
	    			
	    		}
    			

    		}
    		if(completedAll) {
    			player.sendMessage("Congrats! You are done! Check back tommorow");
    			
    		}
    		return true;
    		
    	}
    	else if(cmd.getName().equalsIgnoreCase("group")) {
    		switch(args[0]) {
				case "invite":
					String Playerinvite = args[1];
					String UUID = Bukkit.getPlayer(Playerinvite).getUniqueId().toString();
					String Leader = player.getUniqueId().toString();
					List<String>NewGroup;
					
					if(invite.containsKey(Leader)) {
						NewGroup = invite.get(Leader);
						
					}
					else {
						NewGroup = new ArrayList<String>();
						
					}
					NewGroup.add(UUID);
					invite.put(Leader,NewGroup);
					
					player.sendMessage("Invitation Sent!");
					Bukkit.getPlayer(Playerinvite).sendMessage("You have been invited to join by "+player.getName());
					Bukkit.getPlayer(Playerinvite).sendMessage("Accept by typing in /group accept "+player.getName());
					break;
				case "leave":
					break;
				case "view":
					String LeaderName = args[1];
					String LeaderID = Bukkit.getPlayer(LeaderName).getUniqueId().toString();
					List<String>Members = Groups.get(LeaderID);
					int groupSize = Members.size() + 1;
					player.sendMessage("Group size: "+ String.valueOf(groupSize));
					player.sendMessage("Leader: " + LeaderName);
					
					for (int i = 0;i<Members.size();i++) {
						player.sendMessage(Bukkit.getPlayer(Members.get(i)).getDisplayName());
						
					}
					break;
				case "kick":
					break;
				case "accept":
					String LeaderNamen = args[1];
					
					String LeaderIDn = Bukkit.getPlayer(LeaderNamen).getUniqueId().toString();
					List<String>Group;
					if(Groups.containsKey(LeaderIDn)) {
						Group = invite.get(LeaderIDn);
						
					}
					else {
						Group = new ArrayList<String>();
						
					}
					String myUname = player.getUniqueId().toString();
					
					Group.add(myUname);
					
					
					
					invite.get(LeaderIDn).remove(myUname);
					
					
					Groups.put(LeaderIDn, Group);
					
					player.sendMessage("You have joined the team, good luck!");
					 Bukkit.getPlayer(LeaderNamen).sendMessage(player.getName()+" just joined your party");
					break;
					
    		}
    	}
    	else if(cmd.getName().equalsIgnoreCase("make")) {
    		if(player.isOp()) {
	    		if (args.length == 1) {
		    		switch(args[0]) {
		    			case "grim_reaper":
		    				final Wither nwither = new CustomZombies().grimReaper(player,player.getLocation());
		    				witherLogic(nwither);
	    				break;
		    			case "reaper_fanatic":
		    				new CustomZombies().reaperFanatic(player,player.getLocation());
		    				break;
		    			case "reaper_bloodeater":
		    				new CustomZombies().reaperbloodeater(player,player.getLocation());
		    				break;
		    			case "reaper_minion":
		    				new CustomZombies().reaperMinion(player,player.getLocation());
		    				break;
		    			case "reaper_deathreaper":
		    				new CustomZombies().deathReaper(player,player.getLocation());
		    				break;
		    			case "adamant":
		    				ItemStack item2 = new CustomItems().Adamant();
		    	    		player.getInventory().addItem(item2);
		    				break;
		    			case "aetherstone":
		    				ItemStack item3 = new CustomItems().Aetherstone();
		    	    		player.getInventory().addItem(item3);
		    				break;
		    			case "bloodsteel":
		    				ItemStack item4 = new CustomItems().Bloodsteel();
		    	    		player.getInventory().addItem(item4);
		    				break;
		    			case "koshil":
		    				ItemStack item5 = new CustomItems().Koshil();
		    	    		player.getInventory().addItem(item5);
		    				break;
		    			case "titanium":
		    				ItemStack item6 = new CustomItems().Titanium();
		    	    		player.getInventory().addItem(item6);
		    				break;
		    			case "scythe_blade_fragment":
		    				ItemStack item7 = new CustomItems().ScytheBladeFragment();
		    	    		player.getInventory().addItem(item7);
		    				break;
		    			case "scythe_handle":
		    				ItemStack item8 = new CustomItems().ScytheHandle();
		    	    		player.getInventory().addItem(item8);
		    				break;
		    			case "hell_catalyst":
		    				ItemStack item9 = new CustomItems().HellCatalyst();
		    	    		player.getInventory().addItem(item9);
		    				break;
		    			case "death_fragment":
		    				ItemStack item10 = new CustomItems().DeathFragment();
		    	    		player.getInventory().addItem(item10);
		    				break;
		    			case "bloodsteel_sword":
		    				ItemStack item11 = new CustomItems().BloodSteel_Sword();
		    				player.getInventory().addItem(item11);
		    				break;
		    			case "aetherstone_sword":
		    				ItemStack item12 = new CustomItems().AetherStone_Sword();
		    				player.getInventory().addItem(item12);
		    				break;
		    			case "darkbane":
		    				ItemStack item13 = new CustomItems().DarkBane();
		    				player.getInventory().addItem(item13);
		    				break;
		    			case "koshil_sword":
		    				ItemStack item14 = new CustomItems().KoshilSword();
		    				player.getInventory().addItem(item14);
		    			
		    				break;
		    			case "titanium_armor":
		    				ItemStack item15 = new CustomItems().TitaniumHelmet();
		    				player.getInventory().addItem(item15);
		    				ItemStack item16 = new CustomItems().TitaniumChestplate();
		    				player.getInventory().addItem(item16);
		    				ItemStack item17 = new CustomItems().TitaniumLeggings();
		    				player.getInventory().addItem(item17);
		    				ItemStack item18 = new CustomItems().TitaniumBoots();
		    				player.getInventory().addItem(item18);
		    			
		    				break;
		    			case "koshil_armor":
		    				ItemStack item19 = new CustomItems().Koshil_Helmet();
		    				player.getInventory().addItem(item19);
		    				ItemStack item20 = new CustomItems().Koshil_Chestplate();
		    				player.getInventory().addItem(item20);
		    				ItemStack item21 = new CustomItems().Koshil_Leggings();
		    				player.getInventory().addItem(item21);
		    				ItemStack item22 = new CustomItems().Koshil_Boots();
		    				player.getInventory().addItem(item22);
		    				break;
		    			
		    			case "reaper_scythe":
		    				ItemStack item23 = new CustomItems().ReaperScythe();
		    				player.getInventory().addItem(item23);
		    				
		    				break;
		    			case "refined_diamond_sword":
		    				ItemStack item24 = new CustomItems().RefinedDiamondSword();
		    				player.getInventory().addItem(item24);
		    				
		    				break;
		    			case "soulfury":
		    				ItemStack item25 = new CustomItems().Soulfury();
		    				player.getInventory().addItem(item25);
		    				break;
		    			case "soulstriker":
		    				ItemStack item26 = new CustomItems().SoulStriker();
		    				player.getInventory().addItem(item26);
		    				break;
		    			
		    		}
	    		}
	    		else {
	    			
	    			player.sendMessage("make <name of Zombie>");
	    		}
	    		return true;
    		}
    		return false;
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
    
	
	
	public void witherLogic(final Wither nwither) {
    	if(!nwither.isDead()) {
		    	int time = 8; //time given in hours
		        new BukkitRunnable() {
		            @Override
		            public void run() {
		            	if(nwither.getTarget() == null) {
		            		return;
		            		
		            	}
		            	if(nwither.getTarget() instanceof Player) {
		            		
			            	Player p = (Player) nwither.getTarget();
			            	
			            	if(p == null) {
			            		return;
			            		
			            	}
			            	Location loc = nwither.getEyeLocation();
			            	Vector direction = nwither.getLocation().getDirection();
			            	Location fireballLoc = loc.add(direction);
			            	
			            	Fireball fireball = p.getWorld().spawn(fireballLoc, Fireball.class);
			        		//nwither.getTarget()
			        		
			        		Vector vector = p.getLocation().add(0, 1, 0).toVector().subtract(nwither.getLocation().toVector().multiply(1.0));
			        		fireball.setVelocity(vector);
			        		
			        		if(nwither.isDead()) {
			        			this.cancel();
			        		}
		            	}
		            }
		        }.runTaskTimer(this, time, time);
		        int Ltime = 60; //time given in hours
		        new BukkitRunnable() {
		            @Override
		            public void run() {
		            	if(nwither.getTarget() == null) {
		            		return;
		            		
		            	}
		            	if(nwither.getTarget() instanceof Player) {
		            		
			            	Player p = (Player) nwither.getTarget();
			            	
			            	if(p == null) {
			            		return;
			            		
			            	}
			                p.getWorld().strikeLightning(p.getLocation());
			        		if(nwither.isDead()) {
			        			this.cancel();
			        		}
		            	}
		            }
		        }.runTaskTimer(this, Ltime, Ltime);
    		
    	}
    	
    }

}
