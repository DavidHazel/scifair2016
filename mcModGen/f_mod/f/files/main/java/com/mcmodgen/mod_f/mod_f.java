package com.mcmodgen.mod_f;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.RenderItem;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;    

import com.mcmodgen.mod_f.blocks.fBlocks;
import com.mcmodgen.mod_f.items.*;
import com.mcmodgen.mod_f.blocks.*;
import com.mcmodgen.mod_f.lib.Constants;            

@Mod(modid = Constants.MODID, name = Constants.MODNAME, version = Constants.VERSION)
public class mod_f
{  

  @Mod.EventHandler
  public void preInit(FMLPreInitializationEvent event) {
    
    fBlocks.init();
    fItems.init();
  
  }
  
  @Mod.EventHandler
  public void init(FMLInitializationEvent event) {          
  
    GameRegistry.registerWorldGenerator(new fGenerator(), 1);        
  
  	if(event.getSide() == Side.CLIENT) 
  	{
	    RenderItem renderItem = Minecraft.getMinecraft().getRenderItem();
	    //DogAxe
	    renderItem.getItemModelMesher().register(fItems.asdAxe, 0, new ModelResourceLocation(Constants.MODID + ":" + ((ItemAxeasd) fItems.asdAxe).getName(), "inventory"));
	    //asdPickaxe
	    renderItem.getItemModelMesher().register(fItems.asdPickaxe, 0, new ModelResourceLocation(Constants.MODID + ":" + ((ItemPickaxeasd) fItems.asdPickaxe).getName(), "inventory"));
	    //asdSword
	    renderItem.getItemModelMesher().register(fItems.asdSword, 0, new ModelResourceLocation(Constants.MODID + ":" + ((ItemSwordasd) fItems.asdSword).getName(), "inventory"));
	    //asdShovel
	    renderItem.getItemModelMesher().register(fItems.asdShovel, 0, new ModelResourceLocation(Constants.MODID + ":" + ((ItemShovelasd) fItems.asdShovel).getName(), "inventory"));
	    //asdHoe
	    renderItem.getItemModelMesher().register(fItems.asdHoe, 0, new ModelResourceLocation(Constants.MODID + ":" + ((ItemHoeasd) fItems.asdHoe).getName(), "inventory"));  
   
      }    
  }
  
  @Mod.EventHandler
  public void postInit(FMLPostInitializationEvent event) {
  
  } 
  
  @EventHandler
  public void load(FMLInitializationEvent event)
  {  
  

    //asd Pickaxe Recipe    
    GameRegistry.addRecipe(new ItemStack(fItems.asdPickaxe, 1), new Object []{ "yyy" , " z " , " z " ,
      Character.valueOf('y'), Blocks.bedrock
      , Character.valueOf('z'), Items.stick });
    //asd Shovel Recipe    
    GameRegistry.addRecipe(new ItemStack(fItems.asdShovel, 1), new Object []{ " y " , " z " , " z " ,
      Character.valueOf('y'), Blocks.bedrock
      , Character.valueOf('z'), Items.stick });
    //asd Axe Recipe    
    GameRegistry.addRecipe(new ItemStack(fItems.asdAxe, 1), new Object []{ "yy " , "yz " , " z " ,
      Character.valueOf('y'), Blocks.bedrock
      , Character.valueOf('z'), Items.stick });
    //asd Hoe Recipe    
    GameRegistry.addRecipe(new ItemStack(fItems.asdHoe, 1), new Object []{ "yy " , " z " , " z " ,
      Character.valueOf('y'), Blocks.bedrock
      , Character.valueOf('z'), Items.stick });
    //asd Sword Recipe    
    GameRegistry.addRecipe(new ItemStack(fItems.asdSword, 1), new Object []{ " y " , " y " , " z " ,
      Character.valueOf('y'), Blocks.bedrock
      , Character.valueOf('z'), Items.stick });

    //Furnace Recipes
  }

}
