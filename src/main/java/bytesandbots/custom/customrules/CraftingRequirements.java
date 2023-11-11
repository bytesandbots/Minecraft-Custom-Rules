package bytesandbots.custom.customrules;

import java.util.HashMap;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

public class CraftingRequirements {
	
	public HashMap<Integer,ItemStack> TitaniumSword(){
		HashMap<Integer,ItemStack> reciepe = new HashMap<Integer,ItemStack>();
		reciepe.put(0, null);
		reciepe.put(1, new CustomItems().compactedTitanium());
		reciepe.put(2, null);
		reciepe.put(3, null);
		reciepe.put(4, new CustomItems().compactedTitanium());
		reciepe.put(5, null);
		reciepe.put(6, null);
		reciepe.put(7, new ItemStack(Material.STICK));
		reciepe.put(8, null);
		
		return reciepe;
		
	}
	
	public HashMap<Integer,ItemStack> AetherstoneSword(){
		HashMap<Integer,ItemStack> reciepe = new HashMap<Integer,ItemStack>();
		reciepe.put(0, null);
		reciepe.put(1, new CustomItems().compactedAetherstone());
		reciepe.put(2, null);
		reciepe.put(3, null);
		reciepe.put(4, new CustomItems().compactedAetherstone());
		reciepe.put(5, null);
		reciepe.put(6, null);
		reciepe.put(7, new ItemStack(Material.STICK));
		reciepe.put(8, null);
		
		return reciepe;
		
	}
	
	public HashMap<Integer,ItemStack> BloodSteelSword(){
		HashMap<Integer,ItemStack> reciepe = new HashMap<Integer,ItemStack>();
		reciepe.put(0, null);
		reciepe.put(1, new CustomItems().compactedBloodsteel());
		reciepe.put(2, null);
		reciepe.put(3, null);
		reciepe.put(4, new CustomItems().compactedBloodsteel());
		reciepe.put(5, null);
		reciepe.put(6, null);
		reciepe.put(7, new ItemStack(Material.STICK));
		reciepe.put(8, null);
		
		return reciepe;
		
	}
	
	public HashMap<Integer,ItemStack> HolyBeacon(){
		HashMap<Integer,ItemStack> reciepe = new HashMap<Integer,ItemStack>();
		reciepe.put(0, null);
		reciepe.put(1, null);
		reciepe.put(2, null);
		reciepe.put(3, null);
		ItemStack cm = new ItemStack(Material.DIAMOND);
		cm.setAmount(16);
		reciepe.put(4, cm);
		reciepe.put(5, null);
		reciepe.put(6, null);
		reciepe.put(7, new ItemStack(Material.BEACON));
		reciepe.put(8, null);
		
		return reciepe;
		
	}
	
	public HashMap<Integer,ItemStack> RefinedDiamondSword(){
		HashMap<Integer,ItemStack> reciepe = new HashMap<Integer,ItemStack>();
		reciepe.put(0, null);
		reciepe.put(1, new ItemStack(Material.DIAMOND_SWORD));
		reciepe.put(2, null);
		reciepe.put(3, null);
		reciepe.put(4, new ItemStack(Material.DIAMOND_BLOCK));
		reciepe.put(5, null);
		reciepe.put(6, null);
		reciepe.put(7, new ItemStack(Material.DIAMOND_BLOCK));
		reciepe.put(8, null);
		
		return reciepe;
		
	}
	public HashMap<Integer,ItemStack> ObsidianSword(){
		HashMap<Integer,ItemStack> reciepe = new HashMap<Integer,ItemStack>();
		reciepe.put(0, null);
		ItemStack cm = new ItemStack(Material.OBSIDIAN);
		cm.setAmount(10);
		reciepe.put(1, cm);
		reciepe.put(2, null);
		reciepe.put(3, null);
		reciepe.put(4, cm);
		reciepe.put(5, null);
		reciepe.put(6, null);
		reciepe.put(7, new ItemStack(Material.STICK));
		reciepe.put(8, null);
		
		return reciepe;
		
	}
	
	public HashMap<Integer,ItemStack> EmeraldSword(){
		HashMap<Integer,ItemStack> reciepe = new HashMap<Integer,ItemStack>();
		reciepe.put(0, null);
		ItemStack cm = new ItemStack(Material.EMERALD);
		cm.setAmount(16);
		reciepe.put(1, cm);
		reciepe.put(2, null);
		reciepe.put(3, null);
		reciepe.put(4, cm);
		reciepe.put(5, null);
		reciepe.put(6, null);
		reciepe.put(7, new ItemStack(Material.STICK));
		reciepe.put(8, null);
		
		return reciepe;
		
	}
	
	public HashMap<Integer,ItemStack> SoulFury(){
		HashMap<Integer,ItemStack> reciepe = new HashMap<Integer,ItemStack>();
		
		ItemStack req = new CustomItems().compactedAetherstone();
		req.setAmount(2);
		
		ItemStack req2 = new ItemStack(Material.SOUL_SAND);
		req2.setAmount(32);
		
		ItemStack req3 = new CustomItems().Koshil();
		req3.setAmount(64);
		
		ItemStack req4 = new CustomItems().SoulStriker();
		
		
		reciepe.put(0, null);
		reciepe.put(1, req);
		reciepe.put(2, null);
		reciepe.put(3, null);
		reciepe.put(4, req4);
		reciepe.put(5, null);
		reciepe.put(6, req2);
		reciepe.put(7, req3);
		reciepe.put(8, req2);
		
		return reciepe;
		
	}
	
	public HashMap<Integer,ItemStack> SoulStriker(){
		HashMap<Integer,ItemStack> reciepe = new HashMap<Integer,ItemStack>();
		
		ItemStack req = new CustomItems().compactedAetherstone();
		req.setAmount(1);
		
		ItemStack req2 = new ItemStack(Material.SOUL_SAND);
		req2.setAmount(32);
		
		
		reciepe.put(0, null);
		reciepe.put(1, req);
		reciepe.put(2, null);
		reciepe.put(3, null);
		reciepe.put(4, req2);
		reciepe.put(5, null);
		reciepe.put(6, null);
		reciepe.put(7, new ItemStack(Material.STICK));
		reciepe.put(8, null);
		
		return reciepe;
		
	}
	
	public HashMap<Integer,ItemStack> DarkBane(){
		HashMap<Integer,ItemStack> reciepe = new HashMap<Integer,ItemStack>();
		
		ItemStack req = new CustomItems().Soulfury();
		req.setAmount(1);
		
	
		ItemStack req2 = new CustomItems().Adamant();
		req2.setAmount(30);
		
		ItemStack req3 = new CustomItems().compactedBloodsteel();
		req3.setAmount(10);
		
		
		reciepe.put(0, null);
		reciepe.put(1, req);
		reciepe.put(2, null);
		reciepe.put(3, null);
		reciepe.put(4, req2);
		reciepe.put(5, null);
		reciepe.put(6, null);
		reciepe.put(7, req3);
		reciepe.put(8, null);
		
		return reciepe;
		
	}
	
	public HashMap<Integer,ItemStack> ReaperScythe(){
		HashMap<Integer,ItemStack> reciepe = new HashMap<Integer,ItemStack>();
		
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
		
		
		reciepe.put(0, req);
		reciepe.put(1, req4);
		reciepe.put(2, null);
		reciepe.put(3, req5);
		reciepe.put(4, req3);
		reciepe.put(5, null);
		reciepe.put(6, null);
		reciepe.put(7, req2);
		reciepe.put(8, null);
		
		return reciepe;
		
	}

}
