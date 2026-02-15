package net.maxtheminerboy.steamblocks.block;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

public class DomeBlock extends Block {

	public static final VoxelShape SHAPE = Block.box(2, 0, 2, 14, 9, 14);
	public static final DirectionProperty FACING = DirectionProperty.create("facing", Direction.values());

	public DomeBlock() {
		
		super(BlockBehaviour.Properties.of()
			.sound(SoundType.METAL)
			.strength(5)
		);

		// Make the dome facing up by default (placed on the floor)
		registerDefaultState(stateDefinition.any().setValue(FACING, Direction.UP));
	}

	@Override
	public VoxelShape getShape(BlockState state, BlockGetter level, BlockPos position, CollisionContext collision) {
		return SHAPE;
	}

	@Override
	protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
		builder.add(FACING);
	}

	@Override
	public BlockState getStateForPlacement(BlockPlaceContext context) {

		// Make the block face in the direction it was placed
		Direction face = context.getClickedFace();
		return defaultBlockState().setValue(FACING, face);
	}
}
