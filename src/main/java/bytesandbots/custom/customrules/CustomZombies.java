package bytesandbots.custom.customrules;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.attribute.Attribute;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.entity.Zombie;
import org.bukkit.inventory.ItemStack;

public class CustomZombies {
	
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
		
	}
}
