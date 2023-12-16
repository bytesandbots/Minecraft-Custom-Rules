package bytesandbots.custom.customrules;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.attribute.Attribute;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.entity.Zombie;
import org.bukkit.inventory.ItemStack;

public class CustomZombies {
	public void reaperMinion(Player p, Location loc) {
		Zombie reaper = (Zombie) p.getWorld().spawnEntity(loc, EntityType.ZOMBIE);
		
		
		reaper.setCustomName(ChatColor.DARK_GREEN+"Reaper Minion");
		
		
		ItemStack weapon = new ItemStack(Material.STONE_HOE,1);
		ItemStack boots = new ItemStack(Material.LEATHER_BOOTS,1);
		ItemStack leggings = new ItemStack(Material.LEATHER_LEGGINGS,1);
		ItemStack chestplate = new ItemStack(Material.LEATHER_CHESTPLATE,1);
		ItemStack head = new ItemStack(Material.ZOMBIE_HEAD,1);
		reaper.getEquipment().setItemInMainHand(weapon);
		reaper.getEquipment().setBoots(boots);
		reaper.getEquipment().setLeggings(leggings);
		reaper.getEquipment().setChestplate(chestplate);
		reaper.getEquipment().setHelmet(head);
		
		reaper.getAttribute(Attribute.GENERIC_ATTACK_DAMAGE).setBaseValue(25f);
		reaper.getAttribute(Attribute.GENERIC_KNOCKBACK_RESISTANCE).setBaseValue(0.5f);
		reaper.getAttribute(Attribute.GENERIC_MOVEMENT_SPEED).setBaseValue(.5f);
		
		reaper.getAttribute(Attribute.GENERIC_MAX_HEALTH).setBaseValue(50f);
		
		
		reaper.setHealth(50);
		
	
		
	}
	
	public void deathReaper(Player p, Location loc) {
		Zombie reaper = (Zombie) p.getWorld().spawnEntity(loc, EntityType.ZOMBIE);
		
		
		reaper.setCustomName(ChatColor.DARK_RED+""+ChatColor.BOLD+"R"+ChatColor.RESET+""+ChatColor.DARK_RED+"eaper "+ChatColor.DARK_RED+""+ChatColor.BOLD+"D"+ChatColor.RESET+""+ChatColor.DARK_RED+"eathripper");
		
		
		ItemStack weapon = new ItemStack(Material.IRON_HOE,1);
		ItemStack boots = new ItemStack(Material.DIAMOND_BOOTS,1);
		ItemStack leggings = new ItemStack(Material.DIAMOND_LEGGINGS,1);
		ItemStack chestplate = new ItemStack(Material.NETHERITE_CHESTPLATE,1);
		ItemStack head = new ItemStack(Material.ZOMBIE_HEAD,1);
		reaper.getEquipment().setItemInMainHand(weapon);
		reaper.getEquipment().setBoots(boots);
		reaper.getEquipment().setLeggings(leggings);
		reaper.getEquipment().setChestplate(chestplate);
		reaper.getEquipment().setHelmet(head);
		
		reaper.getAttribute(Attribute.GENERIC_ATTACK_DAMAGE).setBaseValue(50f);
		reaper.getAttribute(Attribute.GENERIC_KNOCKBACK_RESISTANCE).setBaseValue(1f);
		reaper.getAttribute(Attribute.GENERIC_MOVEMENT_SPEED).setBaseValue(.6f);
		
		reaper.getAttribute(Attribute.GENERIC_MAX_HEALTH).setBaseValue(300f);
		
	
		reaper.setHealth(300);
	}
	
	
	public void reaperFanatic(Player p, Location loc) {
		Zombie reaper = (Zombie) p.getWorld().spawnEntity(loc, EntityType.ZOMBIE);
		ItemStack weapon = new ItemStack(Material.IRON_HOE,1);
		ItemStack boots = new ItemStack(Material.DIAMOND_BOOTS,1);
		ItemStack leggings = new ItemStack(Material.DIAMOND_LEGGINGS,1);
		ItemStack chestplate = new ItemStack(Material.IRON_CHESTPLATE,1);
		ItemStack head = new ItemStack(Material.ZOMBIE_HEAD,1);
		reaper.getEquipment().setItemInMainHand(weapon);
		reaper.getEquipment().setBoots(boots);
		reaper.getEquipment().setLeggings(leggings);
		reaper.getEquipment().setChestplate(chestplate);
		reaper.getEquipment().setHelmet(head);
		
		reaper.getAttribute(Attribute.GENERIC_ATTACK_DAMAGE).setBaseValue(14f);
		reaper.getAttribute(Attribute.GENERIC_MOVEMENT_SPEED).setBaseValue(.4f);
		reaper.getAttribute(Attribute.GENERIC_KNOCKBACK_RESISTANCE).setBaseValue(0.7f);
		reaper.getAttribute(Attribute.GENERIC_MAX_HEALTH).setBaseValue(100f);
		
		reaper.setHealth(100);
		reaper.setCustomName(ChatColor.DARK_PURPLE+""+ChatColor.BOLD+"R"+ChatColor.RESET+"eaper "+ChatColor.DARK_PURPLE+""+ChatColor.BOLD+"F"+ChatColor.RESET+"anatic");
		
		
	}
	public void reaperbloodeater(Player p, Location loc) {
		Zombie reaper = (Zombie) p.getWorld().spawnEntity(loc, EntityType.ZOMBIE);
		ItemStack weapon = new ItemStack(Material.DIAMOND_SHOVEL,1);
		ItemStack boots = new ItemStack(Material.DIAMOND_BOOTS,1);
		ItemStack leggings = new ItemStack(Material.DIAMOND_LEGGINGS,1);
		ItemStack chestplate = new ItemStack(Material.DIAMOND_CHESTPLATE,1);
		ItemStack head = new ItemStack(Material.ZOMBIE_HEAD,1);
		ItemStack offhand = new ItemStack(Material.DIAMOND_SHOVEL,1);
		reaper.getEquipment().setItemInMainHand(weapon);
		reaper.getEquipment().setBoots(boots);
		reaper.getEquipment().setLeggings(leggings);
		reaper.getEquipment().setChestplate(chestplate);
		reaper.getEquipment().setHelmet(head);
		reaper.getEquipment().setItemInOffHand(offhand);
		
		reaper.getAttribute(Attribute.GENERIC_ATTACK_DAMAGE).setBaseValue(20f);
		reaper.getAttribute(Attribute.GENERIC_MOVEMENT_SPEED).setBaseValue(.5f);
		reaper.getAttribute(Attribute.GENERIC_KNOCKBACK_RESISTANCE).setBaseValue(1f);
		reaper.getAttribute(Attribute.GENERIC_MAX_HEALTH).setBaseValue(250f);
		
		reaper.setHealth(250);
		reaper.setCustomName(ChatColor.DARK_PURPLE+""+ChatColor.BOLD+"R"+ChatColor.RESET+"eaper "+ChatColor.DARK_PURPLE+""+ChatColor.BOLD+"B"+ChatColor.RESET+"loodEater");
		
	}
}
