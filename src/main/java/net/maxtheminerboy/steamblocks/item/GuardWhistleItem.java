package net.maxtheminerboy.steamblocks.item;

import net.maxtheminerboy.steamblocks.sound.ModSounds;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class GuardWhistleItem extends Item {

	public GuardWhistleItem() {
		super(new Item.Properties()
			.stacksTo(1)
		);
	}

	@Override
	public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand usedHand) {

		// Go on server-side so everyone can hear the whistle
		if (level.isClientSide() == false)
		{
			// Add a cooldown so you don't spam it
			player.getCooldowns().addCooldown(this, 20); 

			// Play the whistle sound
			level.playSound(null, player.blockPosition(), ModSounds.GUARD_WHISTLE.get(), SoundSource.PLAYERS, 1f, 1f);
		}

		return InteractionResultHolder.sidedSuccess(player.getItemInHand(usedHand), level.isClientSide);
	}
}
