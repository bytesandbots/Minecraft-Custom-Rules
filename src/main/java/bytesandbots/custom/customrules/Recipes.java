package bytesandbots.custom.customrules;

import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.RecipeChoice;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.ShapelessRecipe;
import org.bukkit.inventory.meta.ItemMeta;

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
	
	ShapedRecipe Titanium_Sword(NamespacedKey key) {
		ItemStack titaniumSword = new CustomItems().TitaniumSword();
		
		ShapedRecipe craftSword1 = new ShapedRecipe(key,titaniumSword);
		craftSword1.shape(" * "," * "," $ ");
		
		ItemStack titaniumReq = new CustomItems().compactedTitanium();
		titaniumReq.setAmount(1);

		craftSword1.setIngredient('$', Material.STICK);
		craftSword1.setIngredient('*', new RecipeChoice.ExactChoice(titaniumReq));
		
		return craftSword1;
		
	}
	
	ShapedRecipe Aetherstone_Sword(NamespacedKey key2) {
		//Aetherstone
		
		ItemStack AetherstoneKatana = new CustomItems().AetherStone_Sword();
		
		//Recipe for Aetherstone Sword
		
		ShapedRecipe item = new ShapedRecipe(key2,AetherstoneKatana);
		item.shape(" * "," * "," $ ");
		
		ItemStack aetherReq = new CustomItems().compactedAetherstone();
	

		item.setIngredient('$', Material.STICK);
		item.setIngredient('*', new RecipeChoice.ExactChoice(aetherReq));
		
		return item;

	}
	
	ShapedRecipe BloodSteel_Sword(NamespacedKey key) {
		//Bloodsteel
		ItemStack bloodSteel = new CustomItems().BloodSteel_Sword();
		
		//Recipe for Bloodsteel Sword
		
		ShapedRecipe item = new ShapedRecipe(key,bloodSteel);
		item.shape(" * "," * "," $ ");
		
		ItemStack bloodsteelReq = new CustomItems().compactedBloodsteel();
	
		item.setIngredient('*', new RecipeChoice.ExactChoice(bloodsteelReq));
		item.setIngredient('$', Material.STICK);
		
		
		return item;
		
	}
	
	ShapedRecipe HolyBeacon(NamespacedKey key) {
		//Bloodsteel
		ItemStack holyBeacon = new CustomItems().HolyBeacon();
		
		//Recipe for Bloodsteel Sword
		
		ShapedRecipe item = new ShapedRecipe(key,holyBeacon);
		item.shape("   "," * "," $ ");
		
		ItemStack req = new ItemStack(Material.DIAMOND);
		req.setAmount(16);
		item.setIngredient('$', new RecipeChoice.ExactChoice(req));
		item.setIngredient('*', Material.BEACON);
		
		
		return item;
		
	}
	
	ShapedRecipe RefinedDiamondSword(NamespacedKey key) {
		//Bloodsteel
		ItemStack sword = new CustomItems().RefinedDiamondSword();
		
		//Recipe for Bloodsteel Sword
		
		ShapedRecipe item = new ShapedRecipe(key,sword);
		item.shape(" $ "," * "," * ");
		
		item.setIngredient('$', Material.DIAMOND_SWORD);
		item.setIngredient('*', Material.DIAMOND_BLOCK);
		
		
		return item;
		
	}
	
	ShapedRecipe ObsidianSword(NamespacedKey key) {
		//Bloodsteel
		ItemStack sword = new CustomItems().ObsidianSword();
		
		//Recipe for Bloodsteel Sword
		
		ShapedRecipe item = new ShapedRecipe(key,sword);
		item.shape(" * "," * "," $ ");
		
		ItemStack req = new ItemStack(Material.OBSIDIAN);
		req.setAmount(10);
		item.setIngredient('*', new RecipeChoice.ExactChoice(req));
		item.setIngredient('$', Material.STICK);
		
		
		return item;
		
	}
	
	ShapedRecipe KoshilSword(NamespacedKey key) {
		//Bloodsteel
		ItemStack sword = new CustomItems().KoshilSword();
		
		//Recipe for Bloodsteel Sword
		
		ShapedRecipe item = new ShapedRecipe(key,sword);
		item.shape(" * "," * "," $ ");
		
		ItemStack req = new CustomItems().compactedKoshil();
		req.setAmount(2);
		item.setIngredient('*', new RecipeChoice.ExactChoice(req));
		item.setIngredient('$', Material.STICK);
		
		
		return item;
		
	}
	
	ShapedRecipe AdamantSword(NamespacedKey key) {
		//Bloodsteel
		ItemStack sword = new CustomItems().AdamantSword();
		
		//Recipe for Bloodsteel Sword
		
		ShapedRecipe item = new ShapedRecipe(key,sword);
		item.shape(" * "," * "," $ ");
		
		ItemStack req = new CustomItems().compactedAdamant();
		req.setAmount(2);
		item.setIngredient('*', new RecipeChoice.ExactChoice(req));
		item.setIngredient('$', Material.STICK);
		
		
		return item;
		
	}
	
	ShapedRecipe SoulFury(NamespacedKey key) {
		//Bloodsteel
		ItemStack sword = new CustomItems().Soulfury();
		
		//Recipe for Bloodsteel Sword
		
		ShapedRecipe item = new ShapedRecipe(key,sword);
		item.shape(" * "," % ","#$#");
		
		ItemStack req = new CustomItems().compactedAetherstone();
		req.setAmount(2);
		
		ItemStack req2 = new ItemStack(Material.SOUL_SAND);
		req2.setAmount(32);
		
		ItemStack req3 = new CustomItems().Koshil();
		req3.setAmount(64);
		
		ItemStack req4 = new CustomItems().SoulStriker();
	
		
		item.setIngredient('*', new RecipeChoice.ExactChoice(req));
		item.setIngredient('%', new RecipeChoice.ExactChoice(req4));
		item.setIngredient('$', new RecipeChoice.ExactChoice(req3));
		item.setIngredient('#', new RecipeChoice.ExactChoice(req2));
		
		
		return item;
		
	}
	
	ShapedRecipe SoulStriker(NamespacedKey key) {
		//Bloodsteel
		ItemStack sword = new CustomItems().SoulStriker();
		
		//Recipe for Bloodsteel Sword
		
		ShapedRecipe item = new ShapedRecipe(key,sword);
		item.shape(" * "," % "," $ ");
		
		ItemStack req = new CustomItems().compactedAetherstone();
		req.setAmount(1);
		
		ItemStack req2 = new ItemStack(Material.SOUL_SAND);
		req2.setAmount(32);
		
	
		
		item.setIngredient('*', new RecipeChoice.ExactChoice(req));
		item.setIngredient('%', new RecipeChoice.ExactChoice(req2));
		item.setIngredient('$', Material.STICK);
		
		
		return item;
		
	}
	
	
	ShapedRecipe DarkBane(NamespacedKey key) {
		//Bloodsteel
		ItemStack sword = new CustomItems().DarkBane();
		
		//Recipe for Bloodsteel Sword
		
		ShapedRecipe item = new ShapedRecipe(key,sword);
		item.shape(" * "," % "," $ ");
		
		ItemStack req = new CustomItems().Soulfury();
		req.setAmount(1);
		
	
		ItemStack req2 = new CustomItems().Adamant();
		req2.setAmount(30);
		
		ItemStack req3 = new CustomItems().compactedBloodsteel();
		req3.setAmount(10);
		
		item.setIngredient('*', new RecipeChoice.ExactChoice(req));
		item.setIngredient('%', new RecipeChoice.ExactChoice(req2));
		item.setIngredient('$', new RecipeChoice.ExactChoice(req3));
		
		
		return item;
		
	}
	
	ShapedRecipe ReaperScythe(NamespacedKey key) {
		//Bloodsteel
		ItemStack sword = new CustomItems().ReaperScythe();
		
		//Recipe for Bloodsteel Sword
		
		ShapedRecipe item = new ShapedRecipe(key,sword);
		item.shape("*# ","^$ "," % ");
		
		ItemStack req = new CustomItems().Adamant();
		req.setAmount(32);
		
	
		ItemStack req2 = new CustomItems().compactedDiamond();
		req2.setAmount(10);
		
		ItemStack req3 = new CustomItems().ScytheHandle();
		req3.setAmount(1);
		
		ItemStack req4 = new CustomItems().ScytheBladeFragment();
		req4.setAmount(3);
		
		ItemStack req5 = new CustomItems().DeathFragment();
		req5.setAmount(1);
		
		item.setIngredient('*', new RecipeChoice.ExactChoice(req));
		item.setIngredient('%', new RecipeChoice.ExactChoice(req2));
		item.setIngredient('$', new RecipeChoice.ExactChoice(req3));
		item.setIngredient('#', new RecipeChoice.ExactChoice(req4));
		item.setIngredient('^', new RecipeChoice.ExactChoice(req5));
		
		
		return item;
		
	}
	
	
	
	ShapelessRecipe compactedDiamond(NamespacedKey key4) {
        ItemStack compacted = new CustomItems().compactedDiamond();
        

        ShapelessRecipe precipe = new ShapelessRecipe(key4,compacted);
        precipe.addIngredient(1, Material.DIAMOND);
        
        return precipe;
    }
	
	ShapelessRecipe compactedIron(NamespacedKey key4) {
        ItemStack compacted = new CustomItems().compactedIron();
        

        ShapelessRecipe precipe = new ShapelessRecipe(key4,compacted);
        precipe.addIngredient(1, Material.IRON_INGOT);
        
        return precipe;
    }
	
	ShapelessRecipe compactedAdamant(NamespacedKey key4) {
        ItemStack compacted = new CustomItems().compactedAdamant();
        

        ShapelessRecipe precipe = new ShapelessRecipe(key4,compacted);
        precipe.addIngredient(1, Material.ORANGE_STAINED_GLASS);
        
        return precipe;
    }
	
	ShapelessRecipe compactedKoshil(NamespacedKey key4) {
        ItemStack compacted = new CustomItems().compactedKoshil();
        

        ShapelessRecipe precipe = new ShapelessRecipe(key4,compacted);
        precipe.addIngredient(1, Material.LIME_STAINED_GLASS);
        
        return precipe;
    }
	
	ShapelessRecipe compactedTitanium(NamespacedKey key4) {
        ItemStack compacted = new CustomItems().compactedTitanium();
        

        ShapelessRecipe precipe = new ShapelessRecipe(key4,compacted);
        precipe.addIngredient(1, Material.WHITE_STAINED_GLASS);
        
        return precipe;
    }
	ShapelessRecipe compactedBloodsteel(NamespacedKey key4) {
        ItemStack compacted = new CustomItems().compactedBloodsteel();
        

        ShapelessRecipe precipe = new ShapelessRecipe(key4,compacted);
        precipe.addIngredient(1, Material.RED_STAINED_GLASS);
        
        return precipe;
    }
	ShapelessRecipe compactedAetherstone(NamespacedKey key4) {
        ItemStack compacted = new CustomItems().compactedAetherstone();
        

        ShapelessRecipe precipe = new ShapelessRecipe(key4,compacted);
        precipe.addIngredient(1, Material.MAGENTA_STAINED_GLASS);
        
        return precipe;
    }

}
