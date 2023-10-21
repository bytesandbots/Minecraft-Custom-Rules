package bytesandbots.custom.customrules;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.attribute.Attribute;
import org.bukkit.attribute.AttributeModifier;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class CustomItems {
	ItemStack compactedDiamond() {
		ItemStack item = new ItemStack(Material.DIAMOND);
		ItemMeta meta = item.getItemMeta();
		meta.setCustomModelData(1);
		meta.setDisplayName(ChatColor.RESET + "Compacted Diamond");
		item.setItemMeta(meta);
		return item;
	}
	ItemStack DarkBane() {
		ItemStack item2 = new ItemStack(Material.DIAMOND_SWORD);
		ItemMeta meta2 = item2.getItemMeta();
		meta2.setCustomModelData(1);
		meta2.setDisplayName(ChatColor.RED + "DarkBane");
		List<String> lore = new ArrayList<>();
		lore.add("Sweeping Edge X");
		meta2.setLore(lore);
		
		AttributeModifier attackSpeed = new AttributeModifier(UUID.randomUUID(),"generic.attack_speed",5,AttributeModifier.Operation.ADD_NUMBER,EquipmentSlot.HAND);
		meta2.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED,attackSpeed);
		
		AttributeModifier armor = new AttributeModifier(UUID.randomUUID(),"generic.armor",20,AttributeModifier.Operation.ADD_NUMBER,EquipmentSlot.HAND);
		meta2.addAttributeModifier(Attribute.GENERIC_ARMOR,armor);
		
		AttributeModifier attackDamage = new AttributeModifier(UUID.randomUUID(),"generic.attack_damage",54,AttributeModifier.Operation.ADD_NUMBER,EquipmentSlot.HAND);
		meta2.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE,attackDamage);
		
		AttributeModifier maxHealth = new AttributeModifier(UUID.randomUUID(),"generic.max_health",10,AttributeModifier.Operation.ADD_NUMBER,EquipmentSlot.HAND);
		meta2.addAttributeModifier(Attribute.GENERIC_MAX_HEALTH,maxHealth);
		
		AttributeModifier movementSpeed = new AttributeModifier(UUID.randomUUID(),"generic.movement_speed",.3,AttributeModifier.Operation.ADD_NUMBER,EquipmentSlot.HAND);
		meta2.addAttributeModifier(Attribute.GENERIC_MOVEMENT_SPEED,movementSpeed);
		meta2.setUnbreakable(true);
		
		item2.setItemMeta(meta2);
		return item2;
	}
}
