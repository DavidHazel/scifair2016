package com.mcmodgen.mod_f.items;
import java.util.Set;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;

import com.google.common.collect.Sets;
import com.mcmodgen.mod_f.lib.Constants;

public class ItemAxeasd extends ItemToolasd
{
	private String name = "ItemAxeasd";
    private static final Set blocksEffectiveAgainst = Sets.newHashSet(new Block[] {Blocks.planks, Blocks.bookshelf, Blocks.log, Blocks.log2, Blocks.chest, Blocks.pumpkin, Blocks.lit_pumpkin});
    
    protected ItemAxeasd(EnumToolasd enumtoolasd)
    {
        super(3.0F, enumtoolasd, blocksEffectiveAgainst);   

  		setUnlocalizedName(Constants.MODID + "_" + name);
  		GameRegistry.registerItem(this, name);
    }

    public float func_150893_a(ItemStack p_150893_1_, Block p_150893_2_)
    {
        return p_150893_2_.getMaterial() != Material.wood && p_150893_2_.getMaterial() != Material.plants && p_150893_2_.getMaterial() != Material.vine ? super.func_150893_a(p_150893_1_, p_150893_2_) : this.efficiencyOnProperMaterial;
    }      
    
  	public String getName()
  	{
  		return name;
  	}  
     
}

  