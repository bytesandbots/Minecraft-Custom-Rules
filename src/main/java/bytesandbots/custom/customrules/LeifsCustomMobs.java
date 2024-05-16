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
}