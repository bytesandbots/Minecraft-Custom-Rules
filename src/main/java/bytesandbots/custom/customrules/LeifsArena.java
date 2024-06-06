package bytesandbots.custom.customrules;

import org.bukkit.ChatColor;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.plugin.Plugin;

public class LeifsArena implements Listener {
	public int wave = 1;
	public Plugin plugin;
	public int spawned = 4;
	
	Player player;
	
	public LeifsArena(Plugin P) {
		plugin = P;
	}
	
	@EventHandler
	  public void onDeath(EntityDeathEvent e){
	    Entity entity = e.getEntity();
	    Entity killer = e.getEntity().getKiller();
	    
	    if(entity.getCustomName() != null) {
	    	spawned --;
	    	
	    	if(spawned <= 0) {
	    		wave ++;
	    		spawnWave(player);
	    	}
	    }
	    
	    
	    
	    
	  
	    /*if (killer instanceof Player){
	    	EntityType[] enemies = {EntityType.ZOMBIE,
	    							EntityType.SKELETON,
	    							EntityType.SPIDER,
	    							EntityType.CREEPER
	    							};
	    	String[] specials = {"Reaper Fanatic","Reaper BloodEater"};
	    	if(entity.getCustomName() != null) {
	    		//System.out.println("Special Kill");
		    	for(String specialEnemy : specials) {
		    		String sName = ChatColor.stripColor(entity.getCustomName());
		    		
		    		if(sName.contains(specialEnemy)) {
		    			//System.out.println(sName);
		    			Map<String,Integer>kills = new HashMap<String,Integer>();
		    			int count = 1;
		    			
			    		if(namedKillCount.containsKey(killer.getUniqueId().toString())) {
			    			kills = namedKillCount.get(killer.getUniqueId().toString());
			    			//System.out.println("Enemy found in dictionary");
			    			if(kills.containsKey(entity.getCustomName())){
			    				count = kills.get(entity.getCustomName());
			    				count += 1;
			    				
			    			}
			    			
			    		}
			    		kills.put(sName, count);
			    		//System.out.println("Ded " + sName + " : " + kills.toString());
			    		
			    		namedKillCount.put(killer.getUniqueId().toString(), kills);
			    		
			    		
		    			
		    			
		    		}
		    		
		    	}
	    	}
	    	//continue
	    	else {
	    		//System.out.println("Non Special Kill");
		    	for(EntityType enemy : enemies) {
			    	if(entity.getType().equals(enemy)) {
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
			    		//System.out.println("Ded " + entity.getType().toString() + " : " + kills.toString());
			    		
			    		killCount.put(killer.getUniqueId().toString(), kills);
			    		
			    	}
		    	}
	    	}
	      //your code
	    }*/
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