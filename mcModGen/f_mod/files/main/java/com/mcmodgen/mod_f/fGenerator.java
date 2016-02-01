

package com.mcmodgen.mod_f;

import java.util.Random;

import com.mcmodgen.mod_f.blocks.fBlocks;

import net.minecraft.block.Block;
import net.minecraft.block.state.BlockState;
import net.minecraft.block.state.IBlockState;
import net.minecraft.block.state.pattern.BlockHelper;
import net.minecraft.init.Blocks;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenMinable;
import net.minecraftforge.fml.common.IWorldGenerator;

public class fGenerator implements IWorldGenerator {

	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world,
			IChunkProvider chunkGenerator, IChunkProvider chunkProvider) {

		switch(world.provider.getDimensionId()) {
			case -1:
				generateNether(random, world, chunkX, chunkZ);
				break;
			case 0:
				generateOverworld(random, world, chunkX, chunkZ);
				break;
			case 1:
				generateEnd(random, world, chunkX, chunkZ);
				break;
			default:
				generateOverworld(random, world, chunkX, chunkZ);
		}
		
	}

	private void generateNether(Random random, World world, int x, int z) {
    
	}

	private void generateOverworld(Random random, World world, int x, int z) {
   
	}

	private void generateEnd(Random random, World world, int x, int z) {
   
	}
	
	private void addOres(Block block, World world, Random random, int blockXpos, int blockZpos,
			int maxVein, int minVein, int spawnChance, int minY, int maxY, Block replaceBlock) {
		
		WorldGenMinable minable = new WorldGenMinable(block.getDefaultState(), minVein + random.nextInt(maxVein - minVein), BlockHelper.forBlock(replaceBlock));
		for (int i = 0; i < spawnChance; i++) {
			int posX = (blockXpos * 16) + random.nextInt(16);
			int posZ = (blockZpos * 16) + random.nextInt(16);
			int posY = minY + random.nextInt(maxY - minY);
			minable.generate(world, random, new BlockPos(posX, posZ, posY));
		}
		
	}

}
