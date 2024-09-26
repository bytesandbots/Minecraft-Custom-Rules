package bytesandbots.custom.customrules;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

public class LeifsArena {
	public int wave = 1;
	public Plugin plugin;
	public int spawned = 1;
	public boolean modestart = false;
	public List<String> inventory = new ArrayList<String>();
	
	Player player;
	
	public LeifsArena(Plugin P) {
		plugin = P;
	}
	
	public void stopGame(Player p) {
		p.sendMessage("Sorry, you died because of lack of skill.");
		modestart = false;
	}
	
	public void startGame(Player p) {
		player = p;
		modestart = true;
		p.sendMessage("Prepare for " + ChatColor.YELLOW + "" + ChatColor.BOLD + "BATTLE!");
		spawnWave(player);
		//inventory
		//Copy onPlayerMove for original arena
	}
	public void spawnWave(Player p) {
		if(modestart == false) {
			return;
		}
		
		switch(wave) {
			case 1:
				p.sendMessage("Wave 1");
				spawned = 1;
				new LeifsCustomMobs().robotZombie(p, p.getLocation());
				break;
			case 2:
				p.sendMessage("Wave 2");
				spawned = 1;
				new LeifsCustomMobs().wrestlerZombie(p, p.getLocation());
				break;
			case 3:
				p.sendMessage("Wave 3");
				spawned = 1;
				new LeifsCustomMobs().woolZombie(p, p.getLocation());
				break;
				
			default:
				break;
		}
	}
}