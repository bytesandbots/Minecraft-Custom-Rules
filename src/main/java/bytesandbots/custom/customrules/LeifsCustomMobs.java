package bytesandbots.custom.customrules;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.attribute.Attribute;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.entity.Zombie;
import org.bukkit.inventory.ItemStack;

public class LeifsCustomMobs {
	public void robotZombie(Player p, Location loc) {
		Zombie robot = (Zombie) p.getWorld().spawnEntity(loc, EntityType.ZOMBIE);
		
		robot.setCustomName(ChatColor.BLUE + "Robot" + ChatColor.RESET + " Zombie");
		
		ItemStack weapon = new ItemStack(Material.IRON_SWORD, 1);
		ItemStack boots = new ItemStack(Material.IRON_BOOTS, 1);
		ItemStack leggings = new ItemStack(Material.IRON_LEGGINGS, 1);
		ItemStack chestplate = new ItemStack(Material.IRON_CHESTPLATE, 1);
		ItemStack head = new ItemStack(Material.IRON_BLOCK, 1);
		
		robot.getEquipment().setItemInMainHand(weapon);
		robot.getEquipment().setBoots(boots);
		robot.getEquipment().setLeggings(leggings);
		robot.getEquipment().setChestplate(chestplate);
		robot.getEquipment().setHelmet(head);
		
		robot.getAttribute(Attribute.GENERIC_ATTACK_DAMAGE).setBaseValue(3f);
		robot.getAttribute(Attribute.GENERIC_KNOCKBACK_RESISTANCE).setBaseValue(1f);
		robot.getAttribute(Attribute.GENERIC_MOVEMENT_SPEED).setBaseValue(.5f);
		
		robot.getAttribute(Attribute.GENERIC_MAX_HEALTH).setBaseValue(150f);
		
		robot.setHealth(50);
	}
	public void wrestlerZombie(Player p, Location loc) {
		Zombie wrestler = (Zombie) p.getWorld().spawnEntity(loc, EntityType.ZOMBIE);
		
		wrestler.setCustomName(ChatColor.RED + "Wrestler" + ChatColor.RESET + " Zombie");
		
		ItemStack weapon = new ItemStack(Material.RED_WOOL, 1);
		ItemStack boots = new ItemStack(Material.GREEN_WOOL, 1);
		ItemStack leggings = new ItemStack(Material.IRON_LEGGINGS, 1);
		ItemStack chestplate = new ItemStack(Material.ENCHANTED_BOOK, 1);
		ItemStack head = new ItemStack(Material.SEA_LANTERN, 1);
		
		wrestler.getEquipment().setItemInMainHand(weapon);
		wrestler.getEquipment().setBoots(boots);
		wrestler.getEquipment().setLeggings(leggings);
		wrestler.getEquipment().setChestplate(chestplate);
		wrestler.getEquipment().setHelmet(head);
		
		wrestler.getAttribute(Attribute.GENERIC_ATTACK_DAMAGE).setBaseValue(3f);
		wrestler.getAttribute(Attribute.GENERIC_KNOCKBACK_RESISTANCE).setBaseValue(1f);
		wrestler.getAttribute(Attribute.GENERIC_MOVEMENT_SPEED).setBaseValue(.2f);
		
		wrestler.getAttribute(Attribute.GENERIC_MAX_HEALTH).setBaseValue(150f);
		
		wrestler.setHealth(40);
	}
	public void woolZombie(Player p, Location loc) {
		Zombie wool = (Zombie) p.getWorld().spawnEntity(loc, EntityType.ZOMBIE);
		
		wool.setCustomName(ChatColor.BLUE + "Wool" + ChatColor.RESET + " Zombie");
		
		ItemStack weapon = new ItemStack(Material.TRIDENT, 1);
		ItemStack boots = new ItemStack(Material.BLUE_WOOL, 1);
		ItemStack leggings = new ItemStack(Material.RED_WOOL, 1);
		ItemStack chestplate = new ItemStack(Material.YELLOW_WOOL, 1);
		ItemStack head = new ItemStack(Material.ORANGE_WOOL, 1);
		
		wool.getEquipment().setItemInMainHand(weapon);
		wool.getEquipment().setBoots(boots);
		wool.getEquipment().setLeggings(leggings);
		wool.getEquipment().setChestplate(chestplate);
		wool.getEquipment().setHelmet(head);
		
		wool.getAttribute(Attribute.GENERIC_ATTACK_DAMAGE).setBaseValue(4f);
		wool.getAttribute(Attribute.GENERIC_KNOCKBACK_RESISTANCE).setBaseValue(1f);
		wool.getAttribute(Attribute.GENERIC_MOVEMENT_SPEED).setBaseValue(.1f);
		
		wool.getAttribute(Attribute.GENERIC_MAX_HEALTH).setBaseValue(150f);
		
		wool.setHealth(60);
	}
	/*public void MageZombie(Player p, Location loc) {
		Zombie mage = (Zombie) p.getWorld().spawnEntity(loc, EntityType.ZOMBIE);
		
		mage.setCustomName(ChatColor.RED + "Wrestler" + ChatColor.RESET + " Zombie");
		
		ItemStack weapon = new ItemStack(Material.RED_WOOL, 1);
		ItemStack boots = new ItemStack(Material.LEATHER_BOOTS, 1);
		ItemStack leggings = new ItemStack(Material.DIAMOND_LEGGINGS, 1);
		ItemStack chestplate = new ItemStack(Material.BLUE_WOOL, 1);
		ItemStack head = new ItemStack(Material.JACK_O_LANTERN, 1);
		
		mage.getEquipment().setItemInMainHand(weapon);
		mage.getEquipment().setBoots(boots);
		mage.getEquipment().setLeggings(leggings);
		mage.getEquipment().setChestplate(chestplate);
		mage.getEquipment().setHelmet(head);
		
		mage.getAttribute(Attribute.GENERIC_ATTACK_DAMAGE).setBaseValue(3f);
		mage.getAttribute(Attribute.GENERIC_KNOCKBACK_RESISTANCE).setBaseValue(1f);
		mage.getAttribute(Attribute.GENERIC_MOVEMENT_SPEED).setBaseValue(.1f);
		
		mage.getAttribute(Attribute.GENERIC_MAX_HEALTH).setBaseValue(150f);
		
		mage.setHealth(80);
	}*/
}