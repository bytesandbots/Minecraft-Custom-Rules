package bytesandbots.custom.customrules;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.bukkit.ChatColor;
import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.attribute.Attribute;
import org.bukkit.attribute.AttributeModifier;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ArmorMeta;
import org.bukkit.inventory.meta.LeatherArmorMeta;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.trim.ArmorTrim;
import org.bukkit.inventory.meta.trim.TrimMaterial;
import org.bukkit.inventory.meta.trim.TrimPattern;

public class CustomItems {

	ItemStack Koshil() {
		ItemStack item = new ItemStack(Material.LIME_STAINED_GLASS);
		ItemMeta meta = item.getItemMeta();
		meta.setCustomModelData(1);
		meta.setDisplayName(ChatColor.GREEN + "Koshil");
		item.setItemMeta(meta);
		return item;
	}
	ItemStack Titanium() {
		ItemStack item = new ItemStack(Material.WHITE_STAINED_GLASS);
		ItemMeta meta = item.getItemMeta();
		meta.setCustomModelData(1);
		meta.setDisplayName(ChatColor.WHITE + "Titanium");
		item.setItemMeta(meta);
		return item;
	}
	ItemStack Bloodsteel() {
		ItemStack item = new ItemStack(Material.RED_STAINED_GLASS);
		ItemMeta meta = item.getItemMeta();
		meta.setCustomModelData(1);
		meta.setDisplayName(ChatColor.RED + "Bloodsteel");
		item.setItemMeta(meta);
		return item;
	}
	ItemStack Aetherstone() {
		ItemStack item = new ItemStack(Material.MAGENTA_STAINED_GLASS);
		ItemMeta meta = item.getItemMeta();
		meta.setCustomModelData(1);
		meta.setDisplayName(ChatColor.LIGHT_PURPLE + "Aetherstone");
		item.setItemMeta(meta);
		return item;
	}
	
	ItemStack Adamant() {
		ItemStack item = new ItemStack(Material.ORANGE_STAINED_GLASS);
		ItemMeta meta = item.getItemMeta();
		meta.setCustomModelData(1);
		meta.setDisplayName(ChatColor.YELLOW + "Adamant");
		item.setItemMeta(meta);
		return item;
	}
	
	ItemStack ScytheHandle() {
		ItemStack item = new ItemStack(Material.AMETHYST_SHARD);
		ItemMeta meta = item.getItemMeta();
		meta.setCustomModelData(1);
		meta.setDisplayName(ChatColor.DARK_AQUA + "Scythe Handle");
		item.setItemMeta(meta);
		return item;
	}
	
	ItemStack ScytheBladeFragment() {
		ItemStack item = new ItemStack(Material.AMETHYST_SHARD);
		ItemMeta meta = item.getItemMeta();
		meta.setCustomModelData(2);
		meta.setDisplayName(ChatColor.LIGHT_PURPLE + "Scythe Blade Fragments");
		item.setItemMeta(meta);
		return item;
	}
	
	ItemStack DeathFragment() {
		ItemStack item = new ItemStack(Material.AMETHYST_SHARD);
		ItemMeta meta = item.getItemMeta();
		meta.setCustomModelData(3);
		meta.setDisplayName(ChatColor.DARK_PURPLE + "Death Fragment");
		item.setItemMeta(meta);
		return item;
	}
	ItemStack HellCatalyst() {
		ItemStack item = new ItemStack(Material.NETHER_STAR);
		ItemMeta meta = item.getItemMeta();
		meta.setCustomModelData(1);
		meta.setDisplayName(ChatColor.DARK_RED + "Hell Catalyst");
		item.setItemMeta(meta);
		return item;
	}
	
	ItemStack compactedDiamond() {
		ItemStack item = new ItemStack(Material.DIAMOND);
		ItemMeta meta = item.getItemMeta();
		meta.setCustomModelData(1);
		meta.setDisplayName(ChatColor.RESET + "Compacted Diamond");
		item.setItemMeta(meta);
		return item;
	}
	ItemStack compactedIron() {
		ItemStack item = new ItemStack(Material.IRON_INGOT);
		ItemMeta meta = item.getItemMeta();
		meta.setCustomModelData(1);
		meta.setDisplayName(ChatColor.RESET + "Compacted Iron");
		item.setItemMeta(meta);
		return item;
	}
	ItemStack compactedKoshil() {
		ItemStack item = new ItemStack(Material.LIME_STAINED_GLASS);
		ItemMeta meta = item.getItemMeta();
		meta.setCustomModelData(2);
		meta.setDisplayName(ChatColor.RESET + "Compacted Koshil");
		item.setItemMeta(meta);
		return item;
	}
	ItemStack compactedTitanium() {
		ItemStack item = new ItemStack(Material.WHITE_STAINED_GLASS);
		ItemMeta meta = item.getItemMeta();
		meta.setCustomModelData(2);
		meta.setDisplayName(ChatColor.RESET + "Compacted Titanium");
		item.setItemMeta(meta);
		return item;
	}
	ItemStack compactedBloodsteel() {
		ItemStack item = new ItemStack(Material.RED_STAINED_GLASS);
		ItemMeta meta = item.getItemMeta();
		meta.setCustomModelData(2);
		meta.setDisplayName(ChatColor.RESET + "Compacted Bloodsteel");
		item.setItemMeta(meta);
		return item;
	}
	ItemStack compactedAetherstone() {
		ItemStack item = new ItemStack(Material.MAGENTA_STAINED_GLASS);
		ItemMeta meta = item.getItemMeta();
		meta.setCustomModelData(2);
		meta.setDisplayName(ChatColor.RESET + "Compacted Aetherstone");
		item.setItemMeta(meta);
		return item;
	}
	ItemStack compactedAdamant() {
		ItemStack item = new ItemStack(Material.ORANGE_STAINED_GLASS);
		ItemMeta meta = item.getItemMeta();
		meta.setCustomModelData(2);
		meta.setDisplayName(ChatColor.RESET + "Compacted Adamant");
		item.setItemMeta(meta);
		return item;
	}
	ItemStack DarkBane() {
		ItemStack item2 = new ItemStack(Material.DIAMOND_SWORD);
		ItemMeta meta2 = item2.getItemMeta();
		meta2.setCustomModelData(1);
		meta2.setDisplayName(ChatColor.RED + "DarkBane");
		
		//List<String> lore = new ArrayList<>();
		//lore.add("Sweeping Edge X");
		//meta2.setLore(lore);
		
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
		meta2.addEnchant(Enchantment.SWEEPING_EDGE, 10,true);
		
		item2.setItemMeta(meta2);
		
		
		return item2;
	}
	
	ItemStack BloodSteel_Sword() {
		ItemStack sword = new ItemStack(Material.DIAMOND_SWORD, 1);
		ItemMeta meta= sword.getItemMeta();
		meta.setCustomModelData(2);
		meta.setDisplayName(ChatColor.BOLD+""+ChatColor.ITALIC+""+ChatColor.RED+"Bloodsteel Sword");

		
		List<String> lore = new ArrayList<>();
		lore.add("Ability: Lifesteal");
		lore.add("Every time you hit an enemy,");
		lore.add("Gain 1 health");
		
		
		meta.setLore(lore);
		AttributeModifier modifiers = new AttributeModifier(UUID.randomUUID(),"generic.attackDamage",21,AttributeModifier.Operation.ADD_NUMBER,EquipmentSlot.HAND);
		meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE,modifiers);
		meta.setUnbreakable(true);
		
		
		sword.setItemMeta(meta);
		
		return sword;
		
	}
	
	ItemStack AetherStone_Sword() {
		ItemStack sword = new ItemStack(Material.DIAMOND_SWORD, 1);
		ItemMeta meta= sword.getItemMeta();
		meta.setCustomModelData(3);
		meta.setDisplayName(ChatColor.BOLD+""+ChatColor.ITALIC+""+ChatColor.LIGHT_PURPLE+"Aetherstone Katana");

		
		List<String> lore = new ArrayList<>();
		lore.add("Made from pure Aetherstone,");
		lore.add("very difficult to forge though");
		
		
		meta.setLore(lore);
		AttributeModifier damage2 = new AttributeModifier(UUID.randomUUID(),"generic.attackDamage",19,AttributeModifier.Operation.ADD_NUMBER,EquipmentSlot.HAND);
		meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE,damage2);
		meta.setUnbreakable(true);
		
		
		sword.setItemMeta(meta);
		
		return sword;
		
	}
	
	
	ItemStack HolyBeacon() {
		ItemStack item = new ItemStack(Material.BEACON);
		ItemMeta meta= item.getItemMeta();
		meta.setCustomModelData(1);
		meta.setDisplayName(ChatColor.BOLD+""+ChatColor.ITALIC+""+ChatColor.GOLD+"Holy Beacon");

		
		List<String> lore = new ArrayList<>();
		lore.add("Holy Diver");
		lore.add("Better Be Careful");
		
		
		meta.setLore(lore);
		AttributeModifier damage = new AttributeModifier(UUID.randomUUID(),"generic.attackDamage",19,AttributeModifier.Operation.ADD_NUMBER,EquipmentSlot.HAND);
		meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE,damage);
		meta.setUnbreakable(true);
		
		
		item.setItemMeta(meta);
		
		return item;
		
	}
	
	ItemStack TitaniumSword() {
		ItemStack item = new ItemStack(Material.DIAMOND_SWORD, 1);
		ItemMeta meta= item.getItemMeta();
		meta.setCustomModelData(4);
		meta.setDisplayName(ChatColor.BOLD+""+ChatColor.ITALIC+"Titanium Sword");

		
		List<String> lore = new ArrayList<>();
		lore.add("A sword of strong titanium,");
		lore.add("very difficult to forge though");
		
		
		meta.setLore(lore);
		AttributeModifier damage = new AttributeModifier(UUID.randomUUID(),"generic.attackDamage",17,AttributeModifier.Operation.ADD_NUMBER,EquipmentSlot.HAND);
		meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE,damage);
		meta.setUnbreakable(true);
		
		
		item.setItemMeta(meta);
		
		return item;
		
	}
	
	ItemStack RefinedDiamondSword() {
		ItemStack item = new ItemStack(Material.DIAMOND_SWORD, 1);
		ItemMeta meta= item.getItemMeta();
		meta.setCustomModelData(5);
		meta.setDisplayName(ChatColor.AQUA +"T" +ChatColor.BLUE+"itanium Sword");

		
		List<String> lore = new ArrayList<>();
		lore.add("The legendary \"best\" sword of minecraft");
		lore.add("is back! with a new shine too!");
		
		
		meta.setLore(lore);
		AttributeModifier damage = new AttributeModifier(UUID.randomUUID(),"generic.attackDamage",11,AttributeModifier.Operation.ADD_NUMBER,EquipmentSlot.HAND);
		meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE,damage);
		meta.setUnbreakable(true);
		
		
		item.setItemMeta(meta);
		
		return item;
		
	}
	
	ItemStack ObsidianSword() {
		ItemStack item = new ItemStack(Material.DIAMOND_SWORD, 1);
		ItemMeta meta= item.getItemMeta();
		meta.setCustomModelData(6);
		meta.setDisplayName(ChatColor.LIGHT_PURPLE +"O" +ChatColor.BLUE+"bsidian "+ChatColor.LIGHT_PURPLE +"S"+ChatColor.BLUE+"word");

		
		AttributeModifier damage = new AttributeModifier(UUID.randomUUID(),"generic.attackDamage",8,AttributeModifier.Operation.ADD_NUMBER,EquipmentSlot.HAND);
		meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE,damage);
		meta.setUnbreakable(true);
		
		item.setItemMeta(meta);
		
		return item;
		
	}
	
	ItemStack KoshilSword() {
		ItemStack item = new ItemStack(Material.DIAMOND_SWORD, 1);
		ItemMeta meta= item.getItemMeta();
		meta.setCustomModelData(7);
		meta.setDisplayName(ChatColor.DARK_RED +"K" +ChatColor.RED+"oshil "+ChatColor.DARK_RED +"S"+ChatColor.RED+"word");

		
		AttributeModifier damage = new AttributeModifier(UUID.randomUUID(),"generic.attackDamage",9,AttributeModifier.Operation.ADD_NUMBER,EquipmentSlot.HAND);
		meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE,damage);
		meta.setUnbreakable(true);
		
		item.setItemMeta(meta);
		
		return item;
		
	}
	
	ItemStack AdamantSword() {
		ItemStack item = new ItemStack(Material.DIAMOND_SWORD, 1);
		ItemMeta meta= item.getItemMeta();
		meta.setCustomModelData(8);
		meta.setDisplayName(ChatColor.RED +"A" +ChatColor.AQUA+"damant "+ChatColor.GREEN +"S"+ChatColor.AQUA+"word");

		
		AttributeModifier damage = new AttributeModifier(UUID.randomUUID(),"generic.attackDamage",7,AttributeModifier.Operation.ADD_NUMBER,EquipmentSlot.HAND);
		meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE,damage);
		meta.setUnbreakable(true);
		
		item.setItemMeta(meta);
		
		return item;
		
	}
	
	ItemStack Soulfury() {
		ItemStack item = new ItemStack(Material.DIAMOND_SWORD, 1);
		ItemMeta meta= item.getItemMeta();
		meta.setCustomModelData(9);
		meta.setDisplayName(ChatColor.WHITE+"S"+
							ChatColor.LIGHT_PURPLE+"O"+
							ChatColor.DARK_AQUA+"OULFU"+
							ChatColor.LIGHT_PURPLE+"R"+
							ChatColor.WHITE+"Y");
		
		
		List<String> lore = new ArrayList<>();
		lore.add(ChatColor.LIGHT_PURPLE+"Born with the pain of");
		lore.add(ChatColor.LIGHT_PURPLE+"crying AND the flame of fury,");
		lore.add(ChatColor.LIGHT_PURPLE+"this sword will");
		lore.add(ChatColor.LIGHT_PURPLE+"avenge on all");
		lore.add(ChatColor.LIGHT_PURPLE+"who wronged the wielder");
		
		AttributeModifier attackSpeed = new AttributeModifier(UUID.randomUUID(),"generic.attack_speed",1,AttributeModifier.Operation.ADD_NUMBER,EquipmentSlot.HAND);
		meta.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED,attackSpeed);
		

		AttributeModifier attackDamage = new AttributeModifier(UUID.randomUUID(),"generic.attack_damage",29,AttributeModifier.Operation.ADD_NUMBER,EquipmentSlot.HAND);
		meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE,attackDamage);

		AttributeModifier movementSpeed = new AttributeModifier(UUID.randomUUID(),"generic.movement_speed",.2,AttributeModifier.Operation.ADD_NUMBER,EquipmentSlot.HAND);
		meta.addAttributeModifier(Attribute.GENERIC_MOVEMENT_SPEED,movementSpeed);
		
		

		meta.setUnbreakable(true);
		
		item.setItemMeta(meta);
		
		return item;
		
	}
	ItemStack SoulStriker() {
		ItemStack item = new ItemStack(Material.DIAMOND_SWORD, 1);
		ItemMeta meta= item.getItemMeta();
		meta.setCustomModelData(10);
		meta.setDisplayName(ChatColor.DARK_AQUA + "" +ChatColor.BOLD + "S" + 
				ChatColor.RESET + "" + ChatColor.DARK_AQUA + "oul" + 
				ChatColor.BOLD +"S" + 
				ChatColor.RESET + "" + ChatColor.DARK_AQUA + "triker");
		
		List<String> lore = new ArrayList<>();
		lore.add(ChatColor.WHITE+"Born with the pain of crying souls,");
		lore.add(ChatColor.WHITE+"only to avenge them once more.");
		AttributeModifier attackSpeed = new AttributeModifier(UUID.randomUUID(),"generic.attack_speed",.5,AttributeModifier.Operation.ADD_NUMBER,EquipmentSlot.HAND);
		meta.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED,attackSpeed);
		

		AttributeModifier attackDamage = new AttributeModifier(UUID.randomUUID(),"generic.attack_damage",17,AttributeModifier.Operation.ADD_NUMBER,EquipmentSlot.HAND);
		meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE,attackDamage);

		meta.setUnbreakable(true);
		
		item.setItemMeta(meta);
		
		return item;
		
	}
	
	ItemStack ReaperScythe() {
		ItemStack item = new ItemStack(Material.DIAMOND_HOE, 1);
		ItemMeta meta= item.getItemMeta();
		meta.setCustomModelData(1);
		meta.setDisplayName(ChatColor.LIGHT_PURPLE + "Reaper Scythe" );
		List<String> lore = new ArrayList<>();
		lore.add(ChatColor.RED+"The most powerful undead");
		lore.add(ChatColor.RED+"slaying weapon");
		lore.add(ChatColor.RED+"in the universe");
		
		lore.add(ChatColor.RED+"Ability: Death Swish");
		lore.add(ChatColor.RED+"Swing your scythe around");
		lore.add(ChatColor.RED+"dealing massive damage around you!");
		lore.add(ChatColor.RED+"Cooldown: 3 seconds");
		
		AttributeModifier attackSpeed = new AttributeModifier(UUID.randomUUID(),"generic.attack_speed",4,AttributeModifier.Operation.ADD_NUMBER,EquipmentSlot.HAND);
		meta.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED,attackSpeed);
		

		AttributeModifier attackDamage = new AttributeModifier(UUID.randomUUID(),"generic.attack_damage",45,AttributeModifier.Operation.ADD_NUMBER,EquipmentSlot.HAND);
		meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE,attackDamage);
		
		AttributeModifier maxHealth = new AttributeModifier(UUID.randomUUID(),"generic.max_health",10,AttributeModifier.Operation.ADD_NUMBER,EquipmentSlot.HAND);
		meta.addAttributeModifier(Attribute.GENERIC_MAX_HEALTH,maxHealth);
		
		AttributeModifier movementSpeed = new AttributeModifier(UUID.randomUUID(),"generic.movement_speed",.1,AttributeModifier.Operation.ADD_NUMBER,EquipmentSlot.HAND);
		meta.addAttributeModifier(Attribute.GENERIC_MOVEMENT_SPEED,movementSpeed);
		
		
		meta.addEnchant(Enchantment.DAMAGE_UNDEAD, 45,true);
		
		meta.setUnbreakable(true);
		
		item.setItemMeta(meta);
		
		return item;
		
	}
	
	ItemStack TitaniumHelmet() {
		ItemStack item = new ItemStack(Material.IRON_HELMET);
		ArmorMeta meta = (ArmorMeta)item.getItemMeta();
		meta.setDisplayName(ChatColor.GREEN +"Titanium Helmet");
		meta.setUnbreakable(true);
		
		meta.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 12, true);

		ArmorTrim pt = new ArmorTrim(TrimMaterial.QUARTZ,TrimPattern.SILENCE);
		meta.setTrim(pt);
		
		item.setItemMeta(meta);
		
		return item;
		
	}
	ItemStack TitaniumChestplate() {
		ItemStack item = new ItemStack(Material.IRON_CHESTPLATE);
		ArmorMeta meta = (ArmorMeta)item.getItemMeta();
		meta.setDisplayName(ChatColor.GREEN +"Titanium Chestplate");
		meta.setUnbreakable(true);
		
		meta.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 12, true);
		
		ArmorTrim pt = new ArmorTrim(TrimMaterial.QUARTZ,TrimPattern.SILENCE);
		meta.setTrim(pt);
		
		item.setItemMeta(meta);
		
		return item;
		
	}
	ItemStack TitaniumLeggings() {
		ItemStack item = new ItemStack(Material.IRON_LEGGINGS);
		ArmorMeta meta = (ArmorMeta)item.getItemMeta();
		meta.setDisplayName(ChatColor.GREEN +"Titanium Leggings");
		meta.setUnbreakable(true);
		
		meta.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 12, true);
		
		ArmorTrim pt = new ArmorTrim(TrimMaterial.QUARTZ,TrimPattern.SILENCE);
		meta.setTrim(pt);
		
		item.setItemMeta(meta);
		
		return item;
		
	}
	ItemStack TitaniumBoots() {
		ItemStack item = new ItemStack(Material.IRON_BOOTS);
		ArmorMeta meta = (ArmorMeta)item.getItemMeta();
		meta.setDisplayName(ChatColor.GREEN +"Titanium Boots");
		meta.setUnbreakable(true);
		
		meta.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 12, true);
		ArmorTrim pt = new ArmorTrim(TrimMaterial.QUARTZ,TrimPattern.SILENCE);
		meta.setTrim(pt);
		
		item.setItemMeta(meta);
		
		return item;
		
	}
	ItemStack Koshil_Helmet() {
		ItemStack item = new ItemStack(Material.LEATHER_HELMET);
		LeatherArmorMeta meta = (LeatherArmorMeta)item.getItemMeta();
		meta.setDisplayName(ChatColor.GREEN +"Koshil Helmet");
		meta.setUnbreakable(true);
		meta.setColor(Color.LIME);
		meta.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 20, true);
		
		item.setItemMeta(meta);
		ArmorMeta meta2 = (ArmorMeta)item.getItemMeta();
		ArmorTrim pt = new ArmorTrim(TrimMaterial.EMERALD,TrimPattern.COAST);
		meta2.setTrim(pt);
		item.setItemMeta(meta2);
		return item;
		
	
	}
	ItemStack Koshil_Chestplate() {
		ItemStack item = new ItemStack(Material.LEATHER_CHESTPLATE);
		LeatherArmorMeta meta = (LeatherArmorMeta)item.getItemMeta();
		meta.setDisplayName(ChatColor.GREEN +"Koshil Chestplate");
		meta.setUnbreakable(true);
		meta.setColor(Color.LIME);
		meta.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 20, true);
		
		item.setItemMeta(meta);
		ArmorMeta meta2 = (ArmorMeta)item.getItemMeta();
		ArmorTrim pt = new ArmorTrim(TrimMaterial.EMERALD,TrimPattern.COAST);
		meta2.setTrim(pt);
		item.setItemMeta (meta2);
		
		
		return item;
		
	
		
	
	}
	ItemStack Koshil_Leggings() {
		ItemStack item = new ItemStack(Material.LEATHER_LEGGINGS);
		LeatherArmorMeta meta = (LeatherArmorMeta)item.getItemMeta();
		meta.setDisplayName(ChatColor.GREEN +"Koshil Leggings");
		meta.setUnbreakable(true);
		meta.setColor(Color.LIME);
		meta.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 20, true);
		
		item.setItemMeta(meta);
		ArmorMeta meta2 = (ArmorMeta) item.getItemMeta();
		ArmorTrim pt = new ArmorTrim(TrimMaterial.EMERALD,TrimPattern.COAST);
		meta2.setTrim(pt);
		item.setItemMeta(meta2);
		
		
		return item;
		
	
	}
	ItemStack Koshil_Boots() {
		ItemStack item = new ItemStack(Material.LEATHER_BOOTS);
		LeatherArmorMeta meta = (LeatherArmorMeta)item.getItemMeta();
		meta.setDisplayName(ChatColor.GREEN +"Koshil Boots");
		meta.setUnbreakable(true);
		meta.setColor(Color.LIME);
		meta.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 20, true);
		
		item.setItemMeta(meta);
		ArmorMeta meta2 = (ArmorMeta) item.getItemMeta();
		ArmorTrim pt = new ArmorTrim(TrimMaterial.EMERALD,TrimPattern.COAST);
		meta2.setTrim(pt);
		item.setItemMeta(meta2);
		
		
		return item;
		
	
	}
	
	
	
	
}
