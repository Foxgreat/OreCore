package xxrexraptorxx.orecore.blocks;

import java.util.Random;

import xxrexraptorxx.orecore.main.ModBlocks;
import xxrexraptorxx.orecore.main.OreCore;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;


public class BlockEndGlowstoneOre extends Block {
	
	public BlockEndGlowstoneOre() {
		super(Material.ROCK);
		this.setCreativeTab(OreCore.mainTab);
		this.setHarvestLevel("pickaxe", 1);
		this.setHardness(1.0F);
		this.setResistance(2.5F);
		this.setSoundType(SoundType.STONE);
		this.setLightLevel(5.0F);
		this.setLightOpacity(5);


	}
	
	/* Drop */    
    public int quantityDropped(Random random)
    {
        return 1 + random.nextInt(2);
    }
    
    public Item getItemDropped(IBlockState state, Random rand, int fortune)
    {
        return Items.GLOWSTONE_DUST;
    }


	@Override
	public int quantityDroppedWithBonus(int fortune, Random random) {
	    return this.quantityDropped(random) + random.nextInt(fortune + 1);
	}
	
	
	@Override
	public void dropBlockAsItemWithChance(World worldIn, BlockPos pos, IBlockState state, float chance, int fortune) {
	    super.dropBlockAsItemWithChance(worldIn, pos, state, chance, fortune);
	}
	
				/* Exp */
	@Override
	public int getExpDrop(IBlockState state, net.minecraft.world.IBlockAccess world, BlockPos pos, int fortune)
	{
	    if (this.getItemDropped(state, RANDOM, fortune) != Item.getItemFromBlock(this))
	    {
	        return 3 + RANDOM.nextInt(6);
	    }
	    return 0;
	}
	
}