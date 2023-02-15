package bytesandbots.custom.customrules;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public final class Main extends JavaPlugin {
	
	List<String> PunishedPlayers = new ArrayList<String>();
	LoginListener actions;
	
	@Override
    public void onEnable() {
        // TODO Insert logic to be performed when the plugin is enabled
		try {
		      File myObj = new File("/plugins/CustomRules/punishedPlayerNames.txt");
		      Scanner myReader = new Scanner(myObj);
		      while (myReader.hasNextLine()) {
		        String data = myReader.nextLine();
		        PunishedPlayers.add(data);
		      }
		      myReader.close();
		      
		      
		      
		    } catch (FileNotFoundException e) {
		      System.out.println("An error occurred. with reading the file punishedPlayerNames.txt . Maybe it's not there? Creating a new file");
		      try {
		          File myObj = new File("/plugins/CustomRules/punishedPlayerNames.txt");
		          if (myObj.createNewFile()) {
		            System.out.println("File created: " + myObj.getName());
		          } else {
		            System.out.println("File already exists.");
		          }
		        } catch (IOException ed) {
		          System.out.println("An error occurred. Probably Server permissions. idk");
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
    
    public void WriteToFile() {
    	try {
		      FileWriter myWriter = new FileWriter("/plugins/CustomRules/punishedPlayerNames.txt");
		      for (String playerUUID : PunishedPlayers) {
		    	  myWriter.write(playerUUID+"\n");
		    

		      }
		      	
		      myWriter.close();
		      System.out.println("Successfully saved names.");
		    } 
		catch (IOException e) {
		      System.out.println("An error writting to file occurred.");
		      e.printStackTrace();
		    }
    	
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
    	
    	
    	if (cmd.getName().equalsIgnoreCase("hello")) { // If the player typed /basic then do the following, note: If you only registered this executor for one command, you don't need this
    		// doSomething
    		return true;
    	}
    	else if(cmd.getName().equalsIgnoreCase("punish")) {
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
    				
    				player.sendMessage("Need a name. ex. /punish <playername>");
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
    				
    				player.sendMessage("Need a name. ex. /unpunish <playername>");
    			}
    			
    		}
    		else {
    			
    			player.sendMessage("Only OP can set this command :(");
    		}
    		
    	}
    	
    	else if (cmd.getName().equalsIgnoreCase("hello2")) {
    		if (!(sender instanceof Player)) {
    			sender.sendMessage("This command can only be run by a player.");
    		} else {
    			player.sendTitle("Hello!", "This is a secret",10,70,20);
    			// do something
    		}
    		return true;
    	}
    	
    	return false; 
    }
	

}
