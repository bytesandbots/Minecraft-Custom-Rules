package bytesandbots.custom.customrules;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.entity.Zombie;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.plugin.Plugin;

public class LeifsArena implements Listener {
	public int wave = 1;
	public Plugin plugin;
	public int spawned;
	
	Player player;
	
	public LeifsArena(Plugin P) {
		plugin = P;
		
	}
	
	@EventHandler
	public void onEntityDamage(EntityDamageByEntityEvent event) {
		if(event.getEntity() instanceof Zombie && event.getEntity().getCustomName() != null) {
			if(event.getEntity().isDead()) {
				spawned --;
				
				if(spawned <= 0) {
					wave ++;
					
					spawnWave(player);
				}
			}
		}
	}
	
	public void startGame(Player p) {
		player = p;
		p.sendMessage("Prepare for " + ChatColor.YELLOW + "" + ChatColor.BOLD + "BATTLE!");
		spawnWave(player);
	}
	public void spawnWave(Player p) {
		switch(wave) {
			case 1:
				p.sendMessage("Wave 1");
				new LeifsCustomMobs().robotZombie(p, p.getLocation());
				new LeifsCustomMobs().robotZombie(p, p.getLocation());
				new LeifsCustomMobs().robotZombie(p, p.getLocation());
				new LeifsCustomMobs().robotZombie(p, p.getLocation());
				break;
			case 2:
				p.sendMessage("Wave 2");
				new LeifsCustomMobs().robotZombie(p, p.getLocation());
				new LeifsCustomMobs().robotZombie(p, p.getLocation());
				new LeifsCustomMobs().robotZombie(p, p.getLocation());
				new LeifsCustomMobs().robotZombie(p, p.getLocation());
				break;
			case 3:
				p.sendMessage("Wave 3");
				new LeifsCustomMobs().robotZombie(p, p.getLocation());
				new LeifsCustomMobs().robotZombie(p, p.getLocation());
				new LeifsCustomMobs().robotZombie(p, p.getLocation());
				new LeifsCustomMobs().robotZombie(p, p.getLocation());
				break;
				
			default:
				break;
		}
	}
}