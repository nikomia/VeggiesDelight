package net.mehdinoui.veggiesdelight.common.registry;

import net.mehdinoui.veggiesdelight.VeggiesDelight;
import net.mehdinoui.veggiesdelight.common.block.*;
import net.mehdinoui.veggiesdelight.common.block.crops.*;
import net.minecraft.core.BlockPos;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;
import vectorwing.farmersdelight.common.block.PieBlock;

public class ModBlocks {
    public static final DeferredRegister.Blocks BLOCKS =
            DeferredRegister.createBlocks(VeggiesDelight.MOD_ID);
    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }

    private static BlockBehaviour.Properties crate() {
        return BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS).strength(2.0F, 3.0F).sound(SoundType.WOOD);
    }

    private static BlockBehaviour.Properties crop() {
        return BlockBehaviour.Properties.ofFullCopy(Blocks.WHEAT).noOcclusion().noCollision();
    }

    private static BlockBehaviour.Properties wildCrop() {
        return BlockBehaviour.Properties.ofFullCopy(Blocks.ALLIUM).noCollision().noOcclusion();
    }

    // Crates
    public static final DeferredBlock<Block> BELLPEPPER_CRATE = BLOCKS.registerBlock("bellpepper_crate", Block::new, ModBlocks::crate);
    public static final DeferredBlock<Block> BROCCOLI_CRATE = BLOCKS.registerBlock("broccoli_crate", Block::new, ModBlocks::crate);
    public static final DeferredBlock<Block> CAULIFLOWER_CRATE = BLOCKS.registerBlock("cauliflower_crate", Block::new, ModBlocks::crate);
    public static final DeferredBlock<Block> GARLIC_CRATE = BLOCKS.registerBlock("garlic_crate", Block::new, ModBlocks::crate);
    public static final DeferredBlock<Block> SWEET_POTATO_CRATE = BLOCKS.registerBlock("sweet_potato_crate", Block::new, ModBlocks::crate);
    public static final DeferredBlock<Block> TURNIP_CRATE = BLOCKS.registerBlock("turnip_crate", Block::new, ModBlocks::crate);
    public static final DeferredBlock<Block> ZUCCHINI_CRATE = BLOCKS.registerBlock("zucchini_crate", Block::new, ModBlocks::crate);

    // Crops
    public static final DeferredBlock<Block> BELLPEPPER_CROP = BLOCKS.registerBlock("bellpepper_crop", BellpepperCropBlock::new, ModBlocks::crop);
    public static final DeferredBlock<Block> BROCCOLI_CROP = BLOCKS.registerBlock("broccoli_crop", BroccoliCropBlock::new, ModBlocks::crop);
    public static final DeferredBlock<Block> CAULIFLOWER_CROP = BLOCKS.registerBlock("cauliflower_crop", CauliflowerCropBlock::new, ModBlocks::crop);
    public static final DeferredBlock<Block> GARLIC_CROP = BLOCKS.registerBlock("garlic_crop", GarlicCropBlock::new, ModBlocks::crop);
    public static final DeferredBlock<Block> SWEET_POTATO_CROP = BLOCKS.registerBlock("sweet_potato_crop", SweetPotatoCropBlock::new, ModBlocks::crop);
    public static final DeferredBlock<Block> TURNIP_CROP = BLOCKS.registerBlock("turnip_crop", TurnipCropBlock::new, ModBlocks::crop);
    public static final DeferredBlock<Block> ZUCCHINI_CROP = BLOCKS.registerBlock("zucchini_crop", ZucchiniCropBlock::new, ModBlocks::crop);

    // Misc Blocks
    public static final DeferredBlock<Block> VEGAN_PIZZA = BLOCKS.registerBlock("vegan_pizza",
            p -> new PizzaBlock(p, ModItems.VEGAN_PIZZA_SLICE), () -> BlockBehaviour.Properties.ofFullCopy(Blocks.CAKE));
    public static final DeferredBlock<Block> SWEET_POTATO_PIE = BLOCKS.registerBlock("sweet_potato_pie",
            p -> new PieBlock(p, ModItems.SWEET_POTATO_PIE_SLICE), () -> BlockBehaviour.Properties.ofFullCopy(Blocks.CAKE));
    public static final DeferredBlock<Block> BEETROOT_BROWNIE_TRAY = BLOCKS.registerBlock("beetroot_brownie_tray",
            p -> new PieBlock(p, ModItems.BEETROOT_BROWNIE), () -> BlockBehaviour.Properties.ofFullCopy(Blocks.CAKE));
    public static final DeferredBlock<Block> CARROT_CAKE = BLOCKS.registerBlock("carrot_cake",
            CarrotCakeBlock::new, () -> BlockBehaviour.Properties.ofFullCopy(Blocks.CAKE));
    public static final DeferredBlock<Block> STUFFED_BELLPEPPERS_BLOCK = BLOCKS.registerBlock("stuffed_bellpeppers_block",
            p -> new StuffedBellpeppersBlock(p, ModItems.STUFFED_BELLPEPPER, true), () -> BlockBehaviour.Properties.ofFullCopy(Blocks.CAKE));
    public static final DeferredBlock<Block> ZUCCHINI_QUICHE = BLOCKS.registerBlock("zucchini_quiche",
            p -> new PieBlock(p, ModItems.ZUCCHINI_QUICHE_SLICE), () -> BlockBehaviour.Properties.ofFullCopy(Blocks.CAKE));
    public static final DeferredBlock<Block> LASAGNA_PAN = BLOCKS.registerBlock("lasagna_pan",
            p -> new LasagnaPanBlock(p, ModItems.LASAGNA_SLICE, true), () -> BlockBehaviour.Properties.ofFullCopy(Blocks.CAKE));

    // Wild Crops
    public static final DeferredBlock<Block> WILD_BELLPEPPERS = BLOCKS.registerBlock("wild_bellpeppers",
            p -> new SandyFlowerBlock(p), ModBlocks::wildCrop);
    public static final DeferredBlock<Block> MATURE_DANDELION = BLOCKS.registerBlock("mature_dandelion",
            DandelionBlock::new, () -> BlockBehaviour.Properties.ofFullCopy(Blocks.DANDELION).noCollision().noOcclusion());
    public static final DeferredBlock<Block> WILD_BROCCOLI = BLOCKS.registerBlock("wild_broccoli",
            p -> new FlowerBlock(MobEffects.LUCK, 5, p), ModBlocks::wildCrop);
    public static final DeferredBlock<Block> WILD_CAULIFLOWERS = BLOCKS.registerBlock("wild_cauliflowers",
            p -> new FlowerBlock(MobEffects.LUCK, 5, p), ModBlocks::wildCrop);
    public static final DeferredBlock<Block> WILD_GARLIC = BLOCKS.registerBlock("wild_garlic",
            p -> new FlowerBlock(MobEffects.LUCK, 5, p), ModBlocks::wildCrop);
    public static final DeferredBlock<Block> WILD_SWEET_POTATOES = BLOCKS.registerBlock("wild_sweet_potatoes",
            p -> new FlowerBlock(MobEffects.LUCK, 5, p), ModBlocks::wildCrop);
    public static final DeferredBlock<Block> WILD_TURNIPS = BLOCKS.registerBlock("wild_turnips",
            p -> new SandyFlowerBlock(p), ModBlocks::wildCrop);
    public static final DeferredBlock<Block> WILD_ZUCCHINIS = BLOCKS.registerBlock("wild_zucchinis",
            p -> new FlowerBlock(MobEffects.LUCK, 5, p), ModBlocks::wildCrop);

    /** Wild crop that can also sit on sand (bell peppers, turnips). */
    private static class SandyFlowerBlock extends FlowerBlock {
        SandyFlowerBlock(BlockBehaviour.Properties properties) {
            super(MobEffects.LUCK, 5, properties);
        }

        @Override
        protected boolean mayPlaceOn(BlockState state, BlockGetter level, BlockPos pos) {
            return super.mayPlaceOn(state, level, pos) || state.is(Blocks.SAND) || state.is(Blocks.RED_SAND);
        }
    }
}
