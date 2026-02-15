package net.maxtheminerboy.steamblocks.block;

import java.util.function.Supplier;

import net.maxtheminerboy.steamblocks.SteamBlocks;
import net.maxtheminerboy.steamblocks.item.ModItems;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModBlocks {
	
	public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(SteamBlocks.MOD_ID);

	public static final DeferredBlock<Block> TEST_BLOCK = registerBlock("test_block", ()
		-> new Block(BlockBehaviour.Properties.of()
			.strength(4f)
			.sound(SoundType.ANVIL)
		)
	);

	private static <T extends Block> DeferredBlock<T> registerBlock(String name, Supplier<T> block) {

		DeferredBlock<T> newBlock = BLOCKS.register(name, block);
		registerBlockItem(name, newBlock);
		
		return newBlock;
	}

	private static <T extends Block> void registerBlockItem(String name, DeferredBlock<T> block) {

		ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
	}

	public static void register(IEventBus eventBus) {

		BLOCKS.register(eventBus);	
	}
}
