package net.maxtheminerboy.steamblocks.item;

import net.maxtheminerboy.steamblocks.SteamBlocks;
import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModItems {
	
	public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(SteamBlocks.MOD_ID);

	public static final DeferredItem<Item> GUARD_WHISTLE = ITEMS.register("guard_whistle", () -> new GuardWhistleItem());

	public static void register(IEventBus eventBus) {
		ITEMS.register(eventBus);
	}
}
