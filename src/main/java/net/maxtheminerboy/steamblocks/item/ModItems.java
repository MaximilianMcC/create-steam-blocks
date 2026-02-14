package net.maxtheminerboy.steamblocks.item;

import net.maxtheminerboy.steamblocks.SteamBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModItems {
	
	public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(SteamBlocks.MOD_ID);

	public static final DeferredItem<Item> GUARD_WHISTLE = AddItemWithoutTypingAMillionCharacters("guard_whistle");

	public static void register(IEventBus eventBus) {
		ITEMS.register(eventBus);
	}

	private static DeferredItem<Item> AddItemWithoutTypingAMillionCharacters(String name) {
		return ITEMS.register(name, ()  -> new Item(new Item.Properties()));
	}

}
