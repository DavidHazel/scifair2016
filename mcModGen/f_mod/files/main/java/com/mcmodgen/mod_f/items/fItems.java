package com.mcmodgen.mod_f.items;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.RenderItem;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraftforge.common.util.EnumHelper;


import com.mcmodgen.mod_f.lib.Constants;
import com.mcmodgen.mod_f.blocks.fBlocks;
import com.mcmodgen.mod_f.blocks.*;
import com.mcmodgen.mod_f.items.*;

import com.mcmodgen.mod_f.items.ItemToolasd.EnumToolasd;
public final class fItems {


    
    public static Item asdAxe;
    public static Item asdPickaxe;
    public static Item asdSword;
    public static Item asdShovel;
    public static Item asdHoe;
    
    
    public static void init() {    
    
      
      //asd Toolset
      asdAxe =	new ItemAxeasd(EnumToolasd.ASD);
      asdPickaxe =	new ItemPickaxeasd(EnumToolasd.ASD);
      asdSword =	new ItemSwordasd(EnumToolasd.ASD);
      asdShovel =	new ItemShovelasd(EnumToolasd.ASD);
      asdHoe =	new ItemHoeasd(EnumToolasd.ASD);
    
    }
    
}