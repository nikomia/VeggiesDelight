package net.mehdinoui.veggiesdelight.common.registry;

import net.mehdinoui.veggiesdelight.VeggiesDelight;
import net.mehdinoui.veggiesdelight.common.item.ModFoods;
import net.minecraft.core.component.DataComponents;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.storage.loot.providers.number.ints.ContextIntProvider;
import net.minecraft.world.level.storage.loot.providers.number.ints.ContextIntProviders;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;
import vectorwing.farmersdelight.common.item.ConsumableItem;

import java.util.function.Function;
import java.util.function.Supplier;

public class ModItems {
    public final static DeferredRegister.Items ITEMS =
            DeferredRegister.createItems(VeggiesDelight.MOD_ID);

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }

    // Composter chances (former neoforge:compostables data map)
    private static final ResourceKey<ContextIntProvider> COMPOST_10 = ResourceKey.create(Registries.CONTEXT_INT_PROVIDER,
            Identifier.fromNamespaceAndPath(VeggiesDelight.MOD_ID, "compostable/very_low"));
    private static final ResourceKey<ContextIntProvider> COMPOST_30 = ContextIntProviders.COMPOSTABLE_LOW;
    private static final ResourceKey<ContextIntProvider> COMPOST_65 = ContextIntProviders.COMPOSTABLE_MEDIUM;
    private static final ResourceKey<ContextIntProvider> COMPOST_85 = ContextIntProviders.COMPOSTABLE_MEDIUM_HIGH;
    private static final ResourceKey<ContextIntProvider> COMPOST_100 = ContextIntProviders.COMPOSTABLE_ALWAYS_ADD_ONE;

    public static Item.Properties foodItem(ModFoods food) {
        Item.Properties properties = new Item.Properties();
        return food.food() != null ? properties.food(food.food(), food.consumable()) : properties.component(DataComponents.CONSUMABLE, food.consumable());
    }

    public static Item.Properties bowlFoodItem(ModFoods food) {
        return foodItem(food).craftRemainder(Items.BOWL).stacksTo(16);
    }

    public static Item.Properties bottleItem(ModFoods food) {
        return foodItem(food).craftRemainder(Items.GLASS_BOTTLE).stacksTo(32);
    }

    public static Item.Properties stickItem(ModFoods food) {
        return foodItem(food).craftRemainder(Items.STICK).stacksTo(64);
    }

    private static DeferredItem<Item> item(String name, Function<Item.Properties, Item> factory, Supplier<Item.Properties> properties) {
        return ITEMS.registerItem(name, factory, properties);
    }

    private static DeferredItem<Item> food(String name, ModFoods food) {
        return item(name, Item::new, () -> foodItem(food));
    }

    private static DeferredItem<Item> food(String name, ModFoods food, ResourceKey<ContextIntProvider> compost) {
        return item(name, Item::new, () -> foodItem(food).compostable(compost));
    }

    private static DeferredItem<Item> bowlMeal(String name, ModFoods food) {
        return item(name, p -> new ConsumableItem(p, true), () -> bowlFoodItem(food));
    }

    private static DeferredItem<Item> drink(String name, ModFoods food) {
        return item(name, p -> new ConsumableItem(p, true), () -> bottleItem(food));
    }

    private static DeferredItem<Item> block(DeferredBlock<Block> block, Supplier<Item.Properties> properties) {
        return ITEMS.registerItem(block.getId().getPath(), p -> new BlockItem(block.get(), p), () -> properties.get().useBlockDescriptionPrefix());
    }

    private static DeferredItem<Item> block(DeferredBlock<Block> block) {
        return block(block, Item.Properties::new);
    }

    /** Item planting a crop, named after itself (was ItemNameBlockItem). */
    private static DeferredItem<Item> planter(String name, DeferredBlock<Block> crop, Supplier<Item.Properties> properties) {
        return ITEMS.registerItem(name, p -> new BlockItem(crop.get(), p), properties);
    }

    // Blocks
    // Crate Blocks
    public static final DeferredItem<Item> BELLPEPPER_CRATE = block(ModBlocks.BELLPEPPER_CRATE);
    public static final DeferredItem<Item> BROCCOLI_CRATE = block(ModBlocks.BROCCOLI_CRATE);
    public static final DeferredItem<Item> CAULIFLOWER_CRATE = block(ModBlocks.CAULIFLOWER_CRATE);
    public static final DeferredItem<Item> GARLIC_CRATE = block(ModBlocks.GARLIC_CRATE);
    public static final DeferredItem<Item> SWEET_POTATO_CRATE = block(ModBlocks.SWEET_POTATO_CRATE);
    public static final DeferredItem<Item> TURNIP_CRATE = block(ModBlocks.TURNIP_CRATE);
    public static final DeferredItem<Item> ZUCCHINI_CRATE = block(ModBlocks.ZUCCHINI_CRATE);

    // Misc Blocks
    public static final DeferredItem<Item> BEETROOT_BROWNIE_TRAY = block(ModBlocks.BEETROOT_BROWNIE_TRAY, () -> new Item.Properties().compostable(COMPOST_100));
    public static final DeferredItem<Item> STUFFED_BELLPEPPERS_BLOCK = block(ModBlocks.STUFFED_BELLPEPPERS_BLOCK);
    public static final DeferredItem<Item> CARROT_CAKE = block(ModBlocks.CARROT_CAKE, () -> new Item.Properties().stacksTo(1).compostable(COMPOST_100));
    public static final DeferredItem<Item> SWEET_POTATO_PIE = block(ModBlocks.SWEET_POTATO_PIE, () -> new Item.Properties().compostable(COMPOST_100));
    public static final DeferredItem<Item> ZUCCHINI_QUICHE = block(ModBlocks.ZUCCHINI_QUICHE, () -> new Item.Properties().compostable(COMPOST_100));
    public static final DeferredItem<Item> VEGAN_PIZZA = block(ModBlocks.VEGAN_PIZZA, () -> new Item.Properties().compostable(COMPOST_100));
    public static final DeferredItem<Item> LASAGNA_PAN = block(ModBlocks.LASAGNA_PAN);

    // Wild Flowers
    public static final DeferredItem<Item> MATURE_DANDELION = block(ModBlocks.MATURE_DANDELION, () -> new Item.Properties().compostable(COMPOST_65));
    public static final DeferredItem<Item> WILD_BELLPEPPERS = block(ModBlocks.WILD_BELLPEPPERS, () -> new Item.Properties().compostable(COMPOST_65));
    public static final DeferredItem<Item> WILD_BROCCOLI = block(ModBlocks.WILD_BROCCOLI, () -> new Item.Properties().compostable(COMPOST_65));
    public static final DeferredItem<Item> WILD_CAULIFLOWERS = block(ModBlocks.WILD_CAULIFLOWERS, () -> new Item.Properties().compostable(COMPOST_65));
    public static final DeferredItem<Item> WILD_GARLIC = block(ModBlocks.WILD_GARLIC, () -> new Item.Properties().compostable(COMPOST_65));
    public static final DeferredItem<Item> WILD_SWEET_POTATOES = block(ModBlocks.WILD_SWEET_POTATOES, () -> new Item.Properties().compostable(COMPOST_65));
    public static final DeferredItem<Item> WILD_TURNIPS = block(ModBlocks.WILD_TURNIPS, () -> new Item.Properties().compostable(COMPOST_65));
    public static final DeferredItem<Item> WILD_ZUCCHINIS = block(ModBlocks.WILD_ZUCCHINIS, () -> new Item.Properties().compostable(COMPOST_65));

    // Items
    // Seeds
    public static final DeferredItem<Item> BELLPEPPER_SEEDS = planter("bellpepper_seeds", ModBlocks.BELLPEPPER_CROP, () -> new Item.Properties().compostable(COMPOST_30));
    public static final DeferredItem<Item> BROCCOLI_SEEDS = planter("broccoli_seeds", ModBlocks.BROCCOLI_CROP, () -> new Item.Properties().compostable(COMPOST_30));
    public static final DeferredItem<Item> CAULIFLOWER_SEEDS = planter("cauliflower_seeds", ModBlocks.CAULIFLOWER_CROP, () -> new Item.Properties().compostable(COMPOST_30));
    public static final DeferredItem<Item> GARLIC_CLOVE = planter("garlic_clove", ModBlocks.GARLIC_CROP,
            () -> foodItem(ModFoods.GARLIC_CLOVE).compostable(COMPOST_10).villagerFood(1));
    public static final DeferredItem<Item> SWEET_POTATO = planter("sweet_potato", ModBlocks.SWEET_POTATO_CROP,
            () -> foodItem(ModFoods.SWEET_POTATO).compostable(COMPOST_65).villagerFood(1));
    public static final DeferredItem<Item> TURNIP_SEEDS = planter("turnip_seeds", ModBlocks.TURNIP_CROP, () -> new Item.Properties().compostable(COMPOST_30));
    public static final DeferredItem<Item> ZUCCHINI_SEEDS = planter("zucchini_seeds", ModBlocks.ZUCCHINI_CROP, () -> new Item.Properties().compostable(COMPOST_30));

    // Vegetables/Foods
    // Bell Pepper
    public static final DeferredItem<Item> BELLPEPPER = item("bellpepper", Item::new, () -> foodItem(ModFoods.BELLPEPPER).compostable(COMPOST_65).villagerFood(1));
    public static final DeferredItem<Item> SMOKED_BELLPEPPER = food("smoked_bellpepper", ModFoods.SMOKED_BELLPEPPER);
    public static final DeferredItem<Item> CACCIATORE = bowlMeal("cacciatore", ModFoods.CACCIATORE);
    public static final DeferredItem<Item> SHAKSHOUKA = bowlMeal("shakshouka", ModFoods.SHAKSHOUKA);
    public static final DeferredItem<Item> STUFFED_BELLPEPPER = food("stuffed_bellpepper", ModFoods.STUFFED_BELLPEPPER);
    public static final DeferredItem<Item> UNCOOKED_MHADJEB = food("uncooked_mhadjeb", ModFoods.UNCOOKED_MHADJEB, COMPOST_85);
    public static final DeferredItem<Item> MHADJEB = food("mhadjeb", ModFoods.MHADJEB);
    public static final DeferredItem<Item> VEGAN_PIZZA_SLICE = food("vegan_pizza_slice", ModFoods.VEGAN_PIZZA_SLICE, COMPOST_85);
    public static final DeferredItem<Item> CHICKEN_FAJITAS_WRAP = food("chicken_fajitas_wrap", ModFoods.CHICKEN_FAJITAS_WRAP);

    // Broccoli
    public static final DeferredItem<Item> BROCCOLI = item("broccoli", Item::new, () -> foodItem(ModFoods.BROCCOLI).compostable(COMPOST_65).villagerFood(1));
    public static final DeferredItem<Item> BROCCOLI_SALAD = bowlMeal("broccoli_salad", ModFoods.BROCCOLI_SALAD);
    public static final DeferredItem<Item> BROCCOLI_SOUP = bowlMeal("broccoli_soup", ModFoods.BROCCOLI_SOUP);
    public static final DeferredItem<Item> PASTA_WITH_BROCCOLI = bowlMeal("pasta_with_broccoli", ModFoods.PASTA_WITH_BROCCOLI);
    public static final DeferredItem<Item> STEAK_AND_BROCCOLI = bowlMeal("steak_and_broccoli", ModFoods.STEAK_AND_BROCCOLI);

    // Cauliflower
    public static final DeferredItem<Item> CAULIFLOWER = item("cauliflower", Item::new, () -> foodItem(ModFoods.CAULIFLOWER).compostable(COMPOST_65).villagerFood(1));
    public static final DeferredItem<Item> CAULIFLOWER_FLORET = food("cauliflower_floret", ModFoods.CAULIFLOWER_FLORET, COMPOST_30);
    public static final DeferredItem<Item> ROASTED_CAULIFLOWER_FLORET = food("roasted_cauliflower_floret", ModFoods.ROASTED_CAULIFLOWER_FLORET);
    public static final DeferredItem<Item> CAULIFLOWER_BREAD = item("cauliflower_bread", Item::new, () -> foodItem(ModFoods.CAULIFLOWER_BREAD).villagerFood(4));
    public static final DeferredItem<Item> CAULIFLOWER_SOUP = bowlMeal("cauliflower_soup", ModFoods.CAULIFLOWER_SOUP);
    public static final DeferredItem<Item> CAULIFLOWER_KUKU = bowlMeal("cauliflower_kuku", ModFoods.CAULIFLOWER_KUKU);

    // Garlic
    public static final DeferredItem<Item> GARLIC = item("garlic", Item::new, () -> new Item.Properties().compostable(COMPOST_65).villagerFood(1));
    public static final DeferredItem<Item> ROASTED_GARLIC_CLOVE = food("roasted_garlic_clove", ModFoods.ROASTED_GARLIC_CLOVE);
    public static final DeferredItem<Item> GARLIC_BREAD = food("garlic_bread", ModFoods.GARLIC_BREAD);
    public static final DeferredItem<Item> GARLIC_CHICKEN_STEW = bowlMeal("garlic_chicken_stew", ModFoods.GARLIC_CHICKEN_STEW);
    public static final DeferredItem<Item> GARLIC_BAKED_COD = bowlMeal("garlic_baked_cod", ModFoods.GARLIC_BAKED_COD);
    public static final DeferredItem<Item> GARLIC_RICE_WITH_CAULIFLOWER = bowlMeal("garlic_rice_with_cauliflower", ModFoods.GARLIC_RICE_WITH_CAULIFLOWER);
    public static final DeferredItem<Item> CESAR_SALAD = bowlMeal("cesar_salad", ModFoods.CESAR_SALAD);
    public static final DeferredItem<Item> FERMENTED_GARLIC_HONEY = drink("fermented_garlic_honey", ModFoods.FERMENTED_GARLIC_HONEY);
    public static final DeferredItem<Item> GARLIC_STUFFED_MUSHROOMS = food("garlic_stuffed_mushrooms", ModFoods.GARLIC_STUFFED_MUSHROOMS);

    // Sweet Potato
    public static final DeferredItem<Item> BAKED_SWEET_POTATO = food("baked_sweet_potato", ModFoods.BAKED_SWEET_POTATO);
    public static final DeferredItem<Item> MASHED_POTATOES = bowlMeal("mashed_potatoes", ModFoods.MASHED_POTATOES);
    public static final DeferredItem<Item> POTATO_NOODLE = food("potato_noodle", ModFoods.POTATO_NOODLE, COMPOST_85);
    public static final DeferredItem<Item> POTATO_NOODLES = bowlMeal("potato_noodles", ModFoods.POTATO_NOODLES);
    public static final DeferredItem<Item> SWEET_POTATO_PIE_SLICE = food("sweet_potato_pie_slice", ModFoods.SWEET_POTATO_PIE_SLICE, COMPOST_85);
    public static final DeferredItem<Item> SWEET_POTATO_DOUGH = food("sweet_potato_dough", ModFoods.SWEET_POTATO_DOUGH, COMPOST_85);
    public static final DeferredItem<Item> SWEET_POTATO_CUPCAKE = food("sweet_potato_cupcake", ModFoods.SWEET_POTATO_CUPCAKE, COMPOST_85);
    public static final DeferredItem<Item> SWEET_POTATO_PANCAKES = bowlMeal("sweet_potato_pancakes", ModFoods.SWEET_POTATO_PANCAKES);

    // Turnip
    public static final DeferredItem<Item> TURNIP = item("turnip", Item::new, () -> foodItem(ModFoods.TURNIP).compostable(COMPOST_65).villagerFood(1));
    public static final DeferredItem<Item> TURNIP_BEEF_STEW = bowlMeal("turnip_beef_stew", ModFoods.TURNIP_BEEF_STEW);
    public static final DeferredItem<Item> TURNIP_CAKE = food("turnip_cake", ModFoods.TURNIP_CAKE);
    public static final DeferredItem<Item> TURNIP_SALAD = bowlMeal("turnip_salad", ModFoods.TURNIP_SALAD);
    public static final DeferredItem<Item> TURNIP_WATER = drink("turnip_water", ModFoods.TURNIP_WATER);
    public static final DeferredItem<Item> TURNIP_MUTTON_SKEWER = item("turnip_mutton_skewer", ConsumableItem::new, () -> stickItem(ModFoods.TURNIP_MUTTON_SKEWER));

    // Zucchini
    public static final DeferredItem<Item> COLESLAW = bowlMeal("coleslaw", ModFoods.COLESLAW);
    public static final DeferredItem<Item> ZUCCHINI = item("zucchini", Item::new, () -> foodItem(ModFoods.ZUCCHINI).compostable(COMPOST_65).villagerFood(1));
    public static final DeferredItem<Item> ROASTED_ZUCCHINI = food("roasted_zucchini", ModFoods.ROASTED_ZUCCHINI);
    public static final DeferredItem<Item> ZUCCHINI_SANDWICH = food("zucchini_sandwich", ModFoods.ZUCCHINI_SANDWICH);
    public static final DeferredItem<Item> ZUCCHINI_SLICE = item("zucchini_slice", Item::new, () -> foodItem(ModFoods.ZUCCHINI_SLICE).villagerFood(1));
    public static final DeferredItem<Item> STUFFED_ZUCCHINIS = bowlMeal("stuffed_zucchinis", ModFoods.STUFFED_ZUCCHINIS);
    public static final DeferredItem<Item> ZUCCHINI_QUICHE_SLICE = food("zucchini_quiche_slice", ModFoods.ZUCCHINI_QUICHE_SLICE, COMPOST_85);
    public static final DeferredItem<Item> STUFFED_ZUCCHINI_BOAT = food("stuffed_zucchini_boat", ModFoods.STUFFED_ZUCCHINI_BOAT);

    // Misc
    public static final DeferredItem<Item> CARROT_JUICE = drink("carrot_juice", ModFoods.CARROT_JUICE);
    public static final DeferredItem<Item> DANDELION_JUICE = drink("dandelion_juice", ModFoods.DANDELION_JUICE);
    public static final DeferredItem<Item> DANDELION_LEAF = food("dandelion_leaf", ModFoods.DANDELION_LEAF, COMPOST_30);
    public static final DeferredItem<Item> DANDELION_AND_EGGS = bowlMeal("dandelion_and_eggs", ModFoods.DANDELION_WITH_EGGS);
    public static final DeferredItem<Item> FISH_AND_CHIPS = bowlMeal("fish_and_chips", ModFoods.FISH_AND_CHIPS);
    public static final DeferredItem<Item> ROASTED_VEGETABLES = bowlMeal("roasted_vegetables", ModFoods.ROASTED_VEGETABLES);
    public static final DeferredItem<Item> BEETROOT_BROWNIE = food("beetroot_brownie", ModFoods.BEETROOT_BROWNIE, COMPOST_85);
    public static final DeferredItem<Item> CARROT_CAKE_SLICE = food("carrot_cake_slice", ModFoods.CARROT_CAKE_SLICE, COMPOST_85);
    public static final DeferredItem<Item> LASAGNA_SLICE = bowlMeal("lasagna_slice", ModFoods.LASAGNA_SLICE);
    public static final DeferredItem<Item> RAW_VEGETARIAN_PATTY = food("raw_vegetarian_patty", ModFoods.RAW_VEGETARIAN_PATTY, COMPOST_85);
    public static final DeferredItem<Item> COOKED_VEGETARIAN_PATTY = food("cooked_vegetarian_patty", ModFoods.COOKED_VEGETARIAN_PATTY);
    public static final DeferredItem<Item> VEGETARIAN_BURGER = food("vegetarian_burger", ModFoods.VEGETARIAN_BURGER);
    public static final DeferredItem<Item> RICE_AND_VEGETABLES = bowlMeal("rice_and_vegetables", ModFoods.RICE_AND_VEGETABLES);
    public static final DeferredItem<Item> VEGETABLES_WRAP = food("vegetables_wrap", ModFoods.VEGETABLES_WRAP);
}
