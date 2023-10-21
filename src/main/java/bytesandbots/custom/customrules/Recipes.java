package bytesandbots.custom.customrules;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.attribute.Attribute;
import org.bukkit.attribute.AttributeModifier;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.RecipeChoice;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.ShapelessRecipe;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.material.MaterialData;
import org.bukkit.plugin.java.JavaPlugin;

public class Recipes{


	ShapedRecipe Rum(NamespacedKey nn) {
		ItemStack rum = new ItemStack(Material.MILK_BUCKET, 1);
		ItemMeta meta= rum.getItemMeta();
		meta.setDisplayName("Rum");
		rum.setItemMeta(meta);
		
		ShapedRecipe craftRum = new ShapedRecipe(nn,rum);
		craftRum.shape("%*%","%$%","%$%");
		
		craftRum.setIngredient('%', Material.EMERALD);
		craftRum.setIngredient('$', Material.SUGAR_CANE);
		craftRum.setIngredient('*', Material.BUCKET);
		
		
		return craftRum;
	}
	
	ShapedRecipe Titanium_Sword(NamespacedKey key1) {
		ItemStack ironSword = new ItemStack(Material.IRON_SWORD, 1);
		ItemMeta swordMeta= ironSword.getItemMeta();
		swordMeta.setDisplayName(ChatColor.BOLD+""+ChatColor.ITALIC+"Titanium Sword");

		
		List<String> lore = new ArrayList<>();
		lore.add("A sword of strong titanium,");
		lore.add("very difficult to forge though");
		
		
		swordMeta.setLore(lore);
		AttributeModifier damage = new AttributeModifier(UUID.randomUUID(),"generic.attackDamage",17,AttributeModifier.Operation.ADD_NUMBER,EquipmentSlot.HAND);
		swordMeta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE,damage);
		swordMeta.setUnbreakable(true);
		
		
		ironSword.setItemMeta(swordMeta);
		
		ShapedRecipe craftSword1 = new ShapedRecipe(key1,ironSword);
		craftSword1.shape(" * "," * "," $ ");
		
		ItemStack titaniumReq = new ItemStack(Material.WHITE_STAINED_GLASS,32);

		craftSword1.setIngredient('$', Material.STICK);
		craftSword1.setIngredient('*', new RecipeChoice.ExactChoice(titaniumReq));
		
		return craftSword1;
		
	}
	
	ShapedRecipe Aetherstone_Sword(NamespacedKey key2) {
		//Aetherstone
				ItemStack StoneSword = new ItemStack(Material.STONE_SWORD, 1);
				ItemMeta sword2Meta= StoneSword.getItemMeta();
				sword2Meta.setDisplayName(ChatColor.BOLD+""+ChatColor.ITALIC+""+ChatColor.LIGHT_PURPLE+"Aetherstone Katana");

				
				List<String> lore2 = new ArrayList<>();
				lore2.add("Made from pure Aetherstone,");
				lore2.add("very difficult to forge though");
				
				
				sword2Meta.setLore(lore2);
				AttributeModifier damage2 = new AttributeModifier(UUID.randomUUID(),"generic.attackDamage",19,AttributeModifier.Operation.ADD_NUMBER,EquipmentSlot.HAND);
				sword2Meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE,damage2);
				sword2Meta.setUnbreakable(true);
				
				
				StoneSword.setItemMeta(sword2Meta);
				
				//Recipe for Aetherstone Sword
				
				ShapedRecipe craftSword2 = new ShapedRecipe(key2,StoneSword);
				craftSword2.shape(" * "," * "," $ ");
				
				ItemStack aetherReq = new ItemStack(Material.MAGENTA_STAINED_GLASS,32);

				craftSword2.setIngredient('$', Material.STICK);
				craftSword2.setIngredient('*', new RecipeChoice.ExactChoice(aetherReq));
				
				return craftSword2;
		
	}
	
	ShapedRecipe BloodSteel_Sword(NamespacedKey key3) {
		//Bloodsteel
				ItemStack DiamondSword = new ItemStack(Material.DIAMOND_SWORD, 1);
				ItemMeta sword3Meta= DiamondSword.getItemMeta();
				sword3Meta.setDisplayName(ChatColor.BOLD+""+ChatColor.ITALIC+""+ChatColor.RED+"Bloodsteel Sword");

				
				List<String> lore3 = new ArrayList<>();
				lore3.add("Ability: Lifesteal");
				lore3.add("Every time you hit an enemy,");
				lore3.add("Gain 1 health");
				
				
				sword3Meta.setLore(lore3);
				AttributeModifier damage3 = new AttributeModifier(UUID.randomUUID(),"generic.attackDamage",21,AttributeModifier.Operation.ADD_NUMBER,EquipmentSlot.HAND);
				sword3Meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE,damage3);
				sword3Meta.setUnbreakable(true);
				
				
				DiamondSword.setItemMeta(sword3Meta);
				
				//Recipe for Bloodsteel Sword
				
				ShapedRecipe craftSword3 = new ShapedRecipe(key3,DiamondSword);
				craftSword3.shape(" * "," * "," $ ");
				
				ItemStack bloodsteelReq = new ItemStack(Material.RED_STAINED_GLASS,32);

				craftSword3.setIngredient('$', Material.STICK);
				craftSword3.setIngredient('*', new RecipeChoice.ExactChoice(bloodsteelReq));
				
				return craftSword3;
		
	}
	
	ShapelessRecipe compactedDiamond(NamespacedKey key4) {
        ItemStack compactedDiamond = new CustomItems().compactedDiamond();
        

        ShapelessRecipe precipe = new ShapelessRecipe(key4,compactedDiamond);
        precipe.addIngredient(1, Material.DIAMOND);
        
        return precipe;
    }

}
