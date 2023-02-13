package bytesandbots.custom.customrules;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public final class Main extends JavaPlugin {
	
	

	@Override
    public void onEnable() {
        // TODO Insert logic to be performed when the plugin is enabled

		getServer().getPluginManager().registerEvents(new LoginListener() , this);
    }
    
	
    @Override
    public void onDisable() {
        // TODO Insert logic to be performed when the plugin is disabled
    }
    
    
    
    
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
    	if (cmd.getName().equalsIgnoreCase("hello")) { // If the player typed /basic then do the following, note: If you only registered this executor for one command, you don't need this
    		// doSomething
    		return true;
    	}
    	
    	else if (cmd.getName().equalsIgnoreCase("hello2")) {
    		if (!(sender instanceof Player)) {
    			sender.sendMessage("This command can only be run by a player.");
    		} else {
    			
    			Player player = (Player) sender;
    			player.sendTitle("Hello!", "This is a secret",10,70,20);
    			// do something
    		}
    		return true;
    	}
    	
    	return false; 
    }
	

}
