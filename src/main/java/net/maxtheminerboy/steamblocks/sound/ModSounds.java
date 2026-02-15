package net.maxtheminerboy.steamblocks.sound;

import java.util.function.Supplier;

import net.maxtheminerboy.steamblocks.SteamBlocks;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModSounds {
	
	public static final DeferredRegister<SoundEvent> SOUND_EVENTS = DeferredRegister.create(BuiltInRegistries.SOUND_EVENT, SteamBlocks.MOD_ID);

	public static final Supplier<SoundEvent> GUARD_WHISTLE = registerSoundEvent("guard_whistle");

	private static Supplier<SoundEvent> registerSoundEvent(String name) {

		ResourceLocation id = ResourceLocation.fromNamespaceAndPath(SteamBlocks.MOD_ID, name);
		return SOUND_EVENTS.register(name, () -> SoundEvent.createVariableRangeEvent(id));
	}

	public static void register(IEventBus eventBus) {

		SOUND_EVENTS.register(eventBus);
	}

}
