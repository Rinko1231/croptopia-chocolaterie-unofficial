package com.slomaxonical.croptopia.chocolaterie.blocks;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.Maps;
import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import com.slomaxonical.croptopia.chocolaterie.CroptopiaChocolaterie;
import com.slomaxonical.croptopia.chocolaterie.registry.BlockRegistry;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.RegistryCodecs;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.ItemInteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.*;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.pathfinder.PathComputationType;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.NotNull;

import java.util.Map;

public class CandleChocolateCakeBlock extends AbstractCandleBlock {
    public static final MapCodec<CandleChocolateCakeBlock> CODEC = RecordCodecBuilder.mapCodec((instance)->
        instance.group(BuiltInRegistries.BLOCK.byNameCodec().fieldOf("candle").forGetter(candleChocolateCakeBlock -> candleChocolateCakeBlock.candleBlock), propertiesCodec())
                .apply(instance, CandleChocolateCakeBlock::new)
    );
    public static final BooleanProperty LIT = AbstractCandleBlock.LIT;
    protected static final VoxelShape CAKE_SHAPE = Block.box(1.0D, 0.0D, 1.0D, 15.0D, 8.0D, 15.0D);
    protected static final VoxelShape CANDLE_SHAPE = Block.box(7.0D, 8.0D, 7.0D, 9.0D, 14.0D, 9.0D);
    protected static final VoxelShape SHAPE = Shapes.or(CAKE_SHAPE, CANDLE_SHAPE);
    private static final Map<CandleBlock, CandleChocolateCakeBlock> BY_CANDLE = Maps.newHashMap();
    private final CandleBlock candleBlock;
    private static final Iterable<Vec3> PARTICLE_OFFSETS = ImmutableList.of(new Vec3(0.5D, 1.0D, 0.5D));

    public CandleChocolateCakeBlock(Block candle, Properties properties) {
        super(properties);
        this.registerDefaultState(this.stateDefinition.any().setValue(LIT, Boolean.FALSE));
        if (candle instanceof CandleBlock candleblock) {
            BY_CANDLE.put(candleblock, this);
            this.candleBlock = candleblock;
        } else {
            throw new IllegalArgumentException("Expected block to be of " + CandleBlock.class + " was " + candle.getClass());
        }
    }

    @Override
    protected Iterable<Vec3> getParticleOffsets(BlockState state) {
        return PARTICLE_OFFSETS;
    }

    @Override
    protected VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
        return SHAPE;
    }

    @Override
    protected ItemInteractionResult useItemOn(ItemStack stack, BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hitResult) {
        if (stack.is(Items.FLINT_AND_STEEL) || stack.is(Items.FIRE_CHARGE)) {
            return ItemInteractionResult.SKIP_DEFAULT_BLOCK_INTERACTION;
        } else if (candleHit(hitResult) && stack.isEmpty() && state.getValue(LIT)) {
            extinguish(player, state, level, pos);
            return ItemInteractionResult.sidedSuccess(level.isClientSide);
        } else {
            return super.useItemOn(stack, state, level, pos, player, hand, hitResult);
        }
    }

    @Override
    public MapCodec<CandleChocolateCakeBlock> codec() {
        return CODEC;
    }

    @Override
    protected InteractionResult useWithoutItem(BlockState state, Level level, BlockPos pos, Player player, BlockHitResult hitResult) {
        InteractionResult interactionresult = ChocolateCakeBlock.eat(level, pos, BlockRegistry.CHOCOLATE_CAKE.get().defaultBlockState(), player);
        if (interactionresult.consumesAction()) {
            dropResources(state, level, pos);
        }

        return interactionresult;
    }

    private static boolean candleHit(BlockHitResult hit) {
        return hit.getLocation().y - (double)hit.getBlockPos().getY() > 0.5;
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(LIT);
    }

    @Override
    public ItemStack getCloneItemStack(LevelReader level, BlockPos pos, BlockState state) {
        return new ItemStack(BlockRegistry.CHOCOLATE_CAKE.get());
    }

    @Override
    protected BlockState updateShape(BlockState state, Direction direction, BlockState neighborState, LevelAccessor level, BlockPos pos, BlockPos neighborPos) {
        return direction == Direction.DOWN && !state.canSurvive(level, pos)
                ? Blocks.AIR.defaultBlockState()
                : super.updateShape(state, direction, neighborState, level, pos, neighborPos);
    }

    @Override
    protected boolean canSurvive(BlockState state, LevelReader level, BlockPos pos) {
        return level.getBlockState(pos.below()).isSolid();
    }

    @Override
    protected int getAnalogOutputSignal(BlockState state, Level level, BlockPos pos) {
        return ChocolateCakeBlock.FULL_CAKE_SIGNAL;
    }

    @Override
    protected boolean hasAnalogOutputSignal(BlockState state) {
        return true;
    }

    @Override
    protected boolean isPathfindable(BlockState state, PathComputationType pathComputationType) {
        return false;
    }

    public static BlockState byCandle(CandleBlock candle) {
        return BY_CANDLE.get(candle).defaultBlockState();
    }

    public static boolean canLight(BlockState state) {
        return state.is(BlockTags.CANDLE_CAKES, p_152896_ -> p_152896_.hasProperty(LIT) && !state.getValue(LIT));
    }
}
