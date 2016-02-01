package com.mcmodgen.mod_f.items;
import java.util.Set;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraftforge.fml.common.registry.GameRegistry;

import com.google.common.collect.Sets;
import com.mcmodgen.mod_f.lib.Constants;

public class ItemShovelasd extends ItemToolasd
{
	private String name = "ItemShovelasd";
    private static final Set blocksEffectiveAgainst = Sets.newHashSet(new Block[] {Blocks.grass, Blocks.dirt, Blocks.sand, Blocks.gravel, Blocks.snow_layer, Blocks.snow, Blocks.clay, Blocks.farmland, Blocks.soul_sand, Blocks.mycelium});	

    public ItemShovelasd(EnumToolasd enumtoolasd)
    {
    	super(1.0F, enumtoolasd, blocksEffectiveAgainst); 
        
  		setUnlocalizedName(Constants.MODID + "_" + name);
  		GameRegistry.registerItem(this, name);
    }

    public boolean canHarvestBlock(Block p_150897_1_)
    {
        return p_150897_1_ == Blocks.snow_layer ? true : p_150897_1_ == Blocks.snow;
    }  
    
  	public String getName()
  	{
  		return name;
  	} 
  
}