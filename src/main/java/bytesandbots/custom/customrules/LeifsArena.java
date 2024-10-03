package bytesandbots.custom.customrules;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.Plugin;

public class LeifsArena {
	public int wave = 1;
	public Plugin plugin;
	public int spawned = 1;
	public boolean modestart = false;
	public Map<String,ItemStack[]> ArenaInventories = new HashMap<String,ItemStack[]>();
	public Map<String,GameMode> ArenaGamemodes = new HashMap<String,GameMode>();
	
	Player player;
	
	public LeifsArena(Plugin P) {
		plugin = P;
	}
	
	public void stopGame(Player p) {
		p.getInventory().setContents(ArenaInventories.get(p.getUniqueId().toString()));
		p.setGameMode(ArenaGamemodes.get(p.getUniqueId().toString()));
		ArenaInventories.remove(p.getUniqueId().toString());
		ArenaGamemodes.remove(p.getUniqueId().toString());
		p.sendMessage("Sorry, you died because of lack of skill.");
		modestart = false;
	}
	public void win(Player p) {
		wave = 1;
		p.getInventory().setContents(ArenaInventories.get(p.getUniqueId().toString()));
		p.setGameMode(ArenaGamemodes.get(p.getUniqueId().toString()));
		ArenaInventories.remove(p.getUniqueId().toString());
		ArenaGamemodes.remove(p.getUniqueId().toString());
		World curWorld = player.getLocation().getWorld();
		Location winLoc = new Location(curWorld, 0, 75, -212);
		p.teleport(winLoc);
		p.sendMessage("Congratulations!");
		modestart = false;
		//0, 75, -212
	}
	public void startGame(Player p) {
		player = p;
		modestart = true;
		p.sendMessage("Prepare for " + ChatColor.YELLOW + "" + ChatColor.BOLD + "BATTLE!");
		spawnWave(player);
		//inventory
		//Copy onPlayerMove for original arena
		
		if(!ArenaInventories.containsKey(p.getUniqueId().toString())) {
			ArenaGamemodes.put(p.getUniqueId().toString(), p.getGameMode());
			ArenaInventories.put(p.getUniqueId().toString(), p.getInventory().getContents());
			p.getInventory().clear();
			p.getInventory().setBoots(new ItemStack(Material.IRON_BOOTS));
			p.getInventory().setChestplate(new ItemStack(Material.IRON_CHESTPLATE));
	      	p.getInventory().setLeggings(new ItemStack(Material.IRON_LEGGINGS));
	        p.getInventory().setHelmet(new ItemStack(Material.IRON_HELMET)); 
	       	p.getInventory().setItemInMainHand(new ItemStack(Material.IRON_SWORD));
		}
		
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
			case 4:
				win(p);
				break;
			default:
				break;
		}
	}
}