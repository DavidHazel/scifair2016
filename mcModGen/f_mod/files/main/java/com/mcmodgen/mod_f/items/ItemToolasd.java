package com.mcmodgen.mod_f.items;
  
import java.util.Set;

import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.common.ForgeHooks;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Multimap;      

import com.mcmodgen.mod_f.blocks.fBlocks;

public class ItemToolasd extends Item
{
    private Set field_150914_c;
    protected float efficiencyOnProperMaterial = 4.0F;
    /** Damage versus entities. */
    private float damageVsEntity;
    /** The material this tool is made from. */
    protected EnumToolasd toolMaterial;
    private static final String __OBFID = "CL_00000019";

    protected ItemToolasd(float p_i45333_1_, EnumToolasd p_i45333_2_, Set p_i45333_3_)
    {
        this.toolMaterial = p_i45333_2_;
        this.field_150914_c = p_i45333_3_;
        this.maxStackSize = 1;
        this.setMaxDamage(p_i45333_2_.getMaxUses());
        this.efficiencyOnProperMaterial = p_i45333_2_.getEfficiencyOnProperMaterial();
        this.damageVsEntity = p_i45333_1_ + p_i45333_2_.getDamageVsEntity();
        this.setCreativeTab(CreativeTabs.tabTools);
        if (this instanceof ItemPickaxeasd)
        {
            toolClass = "pickaxe";
        }
        else if (this instanceof ItemAxeasd)
        {
            toolClass = "axe";
        }
        else if (this instanceof ItemShovelasd)
        {
            toolClass = "shovel";
        }
    }

    public float func_150893_a(ItemStack p_150893_1_, Block p_150893_2_)
    {
        return this.field_150914_c.contains(p_150893_2_) ? this.efficiencyOnProperMaterial : 1.0F;
    }

    /**
     * Current implementations of this method in child classes do not use the entry argument beside ev. They just raise
     * the damage on the stack.
     */
    public boolean hitEntity(ItemStack par1ItemStack, EntityLivingBase par2EntityLivingBase, EntityLivingBase par3EntityLivingBase)
    {
        par1ItemStack.damageItem(2, par3EntityLivingBase);
        return true;
    }

    public boolean onBlockDestroyed(ItemStack stack, World worldIn, Block blockIn, BlockPos pos, EntityLivingBase playerIn)
    {
        if ((double)blockIn.getBlockHardness(worldIn, pos) != 0.0D)
        {
            stack.damageItem(1, playerIn);
        }

        return true;
    }

    /**
     * Returns True is the item is renderer in full 3D when hold.
     */
    @SideOnly(Side.CLIENT)
    public boolean isFull3D()
    {
        return true;
    }

    public EnumToolasd func_150913_i()
    {
        return this.toolMaterial;
    }

    /**
     * Return the enchantability factor of the item, most of the time is based on material.
     */
    public int getItemEnchantability()
    {
        return this.toolMaterial.getEnchantability();
    }

    /**
     * Return the name for this tool's material.
     */
    public String getToolMaterialName()
    {
        return this.toolMaterial.toString();
    }

    /**
     * Return whether this item is repairable in an anvil.
     */
    public boolean getIsRepairable(ItemStack par1ItemStack, ItemStack par2ItemStack)
    {
        return this.toolMaterial.getToolCraftingMaterial() == par2ItemStack.getItem() ? true : super.getIsRepairable(par1ItemStack, par2ItemStack);
    }

    /**
     * Gets a map of item attribute modifiers, used by ItemSword to increase hit damage.
     */
    public Multimap getItemAttributeModifiers()
    {
        Multimap multimap = super.getItemAttributeModifiers();
        multimap.put(SharedMonsterAttributes.attackDamage.getAttributeUnlocalizedName(), new AttributeModifier(itemModifierUUID, "Tool modifier", (double)this.damageVsEntity, 0));
        return multimap;
    }

    /*===================================== FORGE START =================================*/
    private String toolClass;
    @Override
    public int getHarvestLevel(ItemStack stack, String toolClass)
    {
        int level = super.getHarvestLevel(stack, toolClass);
        if (level == -1 && toolClass != null && toolClass.equals(this.toolClass))
        {
            return this.toolMaterial.getHarvestLevel();
        }
        else
        {
            return level;
        }
    }

    @Override
    public Set<String> getToolClasses(ItemStack stack)
    {
        return toolClass != null ? ImmutableSet.of(toolClass) : super.getToolClasses(stack);
    }

    @Override
    public float getDigSpeed(ItemStack stack, net.minecraft.block.state.IBlockState state)
    {
        for (String type : getToolClasses(stack))
        {
            if (state.getBlock().isToolEffective(type, state))
                return efficiencyOnProperMaterial;
        }
        return super.getDigSpeed(stack, state);
    }
    
    public enum EnumToolasd
    {
        ASD(8, 100, 100F, 100F, 10),
        WOOD(0, 59, 2.0F, 0.0F, 15),
        STONE(1, 131, 4.0F, 1.0F, 5),
        IRON(2, 250, 6.0F, 2.0F, 14),
        EMERALD(3, 1561, 8.0F, 3.0F, 10),
        GOLD(0, 32, 12.0F, 0.0F, 22);


        /** The level of material this tool can harvest (3 = DIAMOND, 2 = IRON, 1 = STONE, 0 = WOOD/GOLD) */
        private final int harvestLevel;
        /** The number of uses this material allows. (wood = 59, stone = 131, iron = 250, diamond = 1561, gold = 32) */
        private final int maxUses;
        /** The strength of this tool material against blocks which it is effective against. */
        private final float efficiencyOnProperMaterial;
        /** Damage versus entities. */
        private final float damageVsEntity;
        /** Defines the natural enchantability factor of the material. */
        private final int enchantability;
        
        public Item customCraftingMaterial = null;

        private EnumToolasd(int par3, int par4, float par5, float par6, int par7)
        {
            this.harvestLevel = par3;
            this.maxUses = par4;
            this.efficiencyOnProperMaterial = par5;
            this.damageVsEntity = par6;
            this.enchantability = par7;
        }

        /**
         * The number of uses this material allows. (wood = 59, stone = 131, iron = 250, diamond = 1561, gold = 32)
         */
        public int getMaxUses()
        {
            return this.maxUses;
        }

        /**
         * The strength of this tool material against blocks which it is effective against.
         */
        public float getEfficiencyOnProperMaterial()
        {
            return this.efficiencyOnProperMaterial;
        }

        /**
         * Damage versus entities.
         */
        public float getDamageVsEntity()
        {
            return this.damageVsEntity;
        }

        /**
         * The level of material this tool can harvest (3 = DIAMOND, 2 = IRON, 1 = STONE, 0 = IRON/GOLD)
         */
        public int getHarvestLevel()
        {
            return this.harvestLevel;
        }

        /**
         * Return the natural enchantability factor of the material.
         */
        public int getEnchantability()
        {
            return this.enchantability;
        }

          /**
         * Return the crafting material for this tool material, used to determine the item that can be used to repair a tool
         * with an anvil
         */
        public Item getToolCraftingMaterial()
        {
    	    switch (this)
    	    {
          	  case ASD:		return Item.getItemFromBlock(Blocks.bedrock);              
              
    	        case WOOD:    return Item.getItemFromBlock(Blocks.planks);
    	        case STONE:   return Item.getItemFromBlock(Blocks.cobblestone);
    	        case GOLD:    return Items.gold_ingot;
    	        case IRON:    return Items.iron_ingot;
    	        case EMERALD: return Items.diamond;
    	        default:      return customCraftingMaterial;
    	    }
        	
        }    
    }
              
    
    /*===================================== FORGE END =================================*/
}