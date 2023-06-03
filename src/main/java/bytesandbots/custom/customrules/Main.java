package bytesandbots.custom.customrules;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.HashMap;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
public final class Main extends JavaPlugin {
	
	List<String> PunishedPlayers = new ArrayList<String>();
	LoginListener actions;
	
	String punishedPlayerFileName = "plugins/CustomRules/punishedPlayerNames.txt";
	HashMap<String, HashMap<String, Location>> homes = new HashMap<>();
	@Override
    public void onEnable() {
        // TODO Insert logic to be performed when the plugin is enabled
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
		
		
		actions = new LoginListener(PunishedPlayers);
	      
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
    				player.sendMessage(ChatColor.GOLD  + "YOU ARE NOW IN SURVIVAL YOU LAZY BUM, JUST PRESS!");
    			
    	}
    	else if (cmd.getName().equalsIgnoreCase("creative")) {
    		player.setGameMode(GameMode.CREATIVE);
    				player.sendMessage(ChatColor.GOLD  + "YOU ARE NOW IN CREATIVE YOU LAZY BUM, JUST PRESS!");
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
    		return true;
    	}
    	return false; 
    }
	

}
