package net.mehdinoui.veggiesdelight.common.item;

import net.minecraft.core.Holder;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.component.Consumable;
import net.minecraft.world.item.component.Consumables;
import net.minecraft.world.item.consume_effects.ApplyStatusEffectsConsumeEffect;
import org.jspecify.annotations.Nullable;
import vectorwing.farmersdelight.common.registry.ModEffects;

import static vectorwing.farmersdelight.common.FoodValues.*;

/**
 * Since 1.21.2 food effects and eating speed live in the Consumable component, so each food is a pair.
 * {@code food} is null for drinks without nutrition.
 */
public record ModFoods(@Nullable FoodProperties food, Consumable consumable) {

    // RAW CROPS
    public static final ModFoods DANDELION_LEAF = food(1, 0.1F).effect(MobEffects.REGENERATION, 100).fast().build();
    public static final ModFoods BELLPEPPER = food(2, 0.2F).build();
    public static final ModFoods BROCCOLI = food(2, 0.4F).build();
    public static final ModFoods CAULIFLOWER = food(4, 0.4F).build();
    public static final ModFoods GARLIC_CLOVE = food(1, 0.1F).fast().build();
    public static final ModFoods SWEET_POTATO = food(2, 0.4F).build();
    public static final ModFoods TURNIP = food(2, 0.4F).build();
    public static final ModFoods ZUCCHINI = food(3, 0.4F).build();

    // DRINKS
    public static final ModFoods CARROT_JUICE = drink().effect(MobEffects.NIGHT_VISION, 400).build();
    public static final ModFoods DANDELION_JUICE = drink().effect(MobEffects.REGENERATION, 400).build();
    public static final ModFoods TURNIP_WATER = drink().effect(MobEffects.RESISTANCE, 400).build();
    public static final ModFoods FERMENTED_GARLIC_HONEY = drink().nutrition(7, 0.7F)
            .effect(MobEffects.REGENERATION, 100).effect(MobEffects.HEALTH_BOOST, 100).build();

    // BASIC INGREDIENTS & COMPONENTS
    public static final ModFoods SMOKED_BELLPEPPER = food(4, 0.4F).build();
    public static final ModFoods BAKED_SWEET_POTATO = food(4, 0.5F).build();
    public static final ModFoods CAULIFLOWER_FLORET = food(1, 0.1F).fast().build();
    public static final ModFoods ROASTED_CAULIFLOWER_FLORET = food(2, 0.3F).fast().build();
    public static final ModFoods ROASTED_GARLIC_CLOVE = food(2, 0.2F).fast().build();
    public static final ModFoods ZUCCHINI_SLICE = food(2, 0.1F).build();
    public static final ModFoods ROASTED_ZUCCHINI = food(4, 0.4F).build();
    public static final ModFoods POTATO_NOODLE = food(4, 0.2F).build();
    public static final ModFoods SWEET_POTATO_DOUGH = food(3, 0.2F).effect(MobEffects.HUNGER, 300, 0.3F).build();
    public static final ModFoods RAW_VEGETARIAN_PATTY = food(3, 0.3F).build();
    public static final ModFoods COOKED_VEGETARIAN_PATTY = food(6, 0.8F).build();

    // DESSERTS
    public static final ModFoods BEETROOT_BROWNIE = food(6, 0.5F).effect(MobEffects.SPEED, 100).build();
    public static final ModFoods CARROT_CAKE_SLICE = food(3, 0.2F).build();
    public static final ModFoods SWEET_POTATO_PIE_SLICE = food(5, 0.3F).build();
    public static final ModFoods SWEET_POTATO_CUPCAKE = food(6, 0.5F).effect(MobEffects.SPEED, 100).build();
    public static final ModFoods SWEET_POTATO_PANCAKES = food(12, 0.8F).effect(MobEffects.SPEED, 100).nourishment(MEDIUM_DURATION).build();

    // SALADS
    public static final ModFoods BROCCOLI_SALAD = food(6, 0.6F).effect(MobEffects.RESISTANCE, 100).build();
    public static final ModFoods CESAR_SALAD = food(10, 0.7F).effect(MobEffects.STRENGTH, 100).build();
    public static final ModFoods COLESLAW = food(8, 0.6F).nourishment(MEDIUM_DURATION).build();
    public static final ModFoods TURNIP_SALAD = food(6, 0.6F).effect(MobEffects.HASTE, 100).build();

    // SNACKS & BAKED GOODS
    public static final ModFoods CAULIFLOWER_BREAD = food(6, 0.6F).build();
    public static final ModFoods GARLIC_BREAD = food(5, 0.4F).fast().build();
    public static final ModFoods GARLIC_STUFFED_MUSHROOMS = food(7, 0.6F).build();
    public static final ModFoods TURNIP_MUTTON_SKEWER = food(7, 0.7F).build();
    public static final ModFoods CHICKEN_FAJITAS_WRAP = food(10, 0.7F).build();
    public static final ModFoods VEGETABLES_WRAP = food(12, 0.8F).build();
    public static final ModFoods VEGETARIAN_BURGER = food(12, 0.8F).build();
    public static final ModFoods ZUCCHINI_SANDWICH = food(10, 0.7F).build();
    public static final ModFoods UNCOOKED_MHADJEB = food(6, 0.4F).build();
    public static final ModFoods MHADJEB = food(12, 0.8F).build();
    public static final ModFoods VEGAN_PIZZA_SLICE = food(5, 0.5F).build();
    public static final ModFoods ZUCCHINI_QUICHE_SLICE = food(6, 0.5F).build();
    public static final ModFoods STUFFED_ZUCCHINI_BOAT = food(10, 0.7F).build();

    // SOUPS & BOWLED MEALS
    public static final ModFoods BROCCOLI_SOUP = food(10, 0.7F).nourishment(BRIEF_DURATION).build();
    public static final ModFoods CAULIFLOWER_SOUP = food(10, 0.7F).nourishment(BRIEF_DURATION).build();
    public static final ModFoods GARLIC_CHICKEN_STEW = food(12, 0.8F).nourishment(MEDIUM_DURATION).build();
    public static final ModFoods TURNIP_BEEF_STEW = food(14, 0.75F).nourishment(LONG_DURATION).build();
    public static final ModFoods CACCIATORE = food(14, 0.75F).nourishment(LONG_DURATION).build();
    public static final ModFoods MASHED_POTATOES = food(10, 0.7F).nourishment(BRIEF_DURATION).build();
    public static final ModFoods POTATO_NOODLES = food(12, 0.8F).effect(MobEffects.RESISTANCE, 100).nourishment(MEDIUM_DURATION).build();

    // PLATED MEALS
    public static final ModFoods DANDELION_WITH_EGGS = food(10, 0.6F).effect(MobEffects.REGENERATION, 100).nourishment(BRIEF_DURATION).build();
    public static final ModFoods CAULIFLOWER_KUKU = food(12, 0.8F).nourishment(MEDIUM_DURATION).build();
    public static final ModFoods TURNIP_CAKE = food(14, 0.75F).nourishment(LONG_DURATION).build();
    public static final ModFoods RICE_AND_VEGETABLES = food(14, 0.75F).nourishment(LONG_DURATION).build();
    public static final ModFoods ROASTED_VEGETABLES = food(12, 0.8F).nourishment(MEDIUM_DURATION).build();
    public static final ModFoods SHAKSHOUKA = food(12, 0.8F).nourishment(MEDIUM_DURATION).build();
    public static final ModFoods PASTA_WITH_BROCCOLI = food(12, 0.8F).nourishment(MEDIUM_DURATION).build();
    public static final ModFoods GARLIC_RICE_WITH_CAULIFLOWER = food(14, 0.75F).nourishment(LONG_DURATION).build();
    public static final ModFoods STEAK_AND_BROCCOLI = food(12, 0.8F).nourishment(MEDIUM_DURATION).build();
    public static final ModFoods FISH_AND_CHIPS = food(10, 0.6F).nourishment(BRIEF_DURATION).build();
    public static final ModFoods GARLIC_BAKED_COD = food(10, 0.6F).nourishment(LONG_DURATION).build();
    public static final ModFoods STUFFED_ZUCCHINIS = food(14, 0.75F).nourishment(LONG_DURATION).build();

    // FEAST SLICES
    public static final ModFoods LASAGNA_SLICE = food(14, 0.75F).nourishment(MEDIUM_DURATION).build();
    public static final ModFoods STUFFED_BELLPEPPER = food(8, 0.65F).nourishment(LONG_DURATION).build();

    private static Builder food(int nutrition, float saturation) {
        return new Builder(false).nutrition(nutrition, saturation);
    }

    private static Builder drink() {
        return new Builder(true);
    }

    private static final class Builder {
        private final boolean drink;
        private final Consumable.Builder consumable;
        private FoodProperties.@Nullable Builder food;

        private Builder(boolean drink) {
            this.drink = drink;
            this.consumable = drink ? Consumables.defaultDrink() : Consumables.defaultFood();
        }

        Builder nutrition(int nutrition, float saturation) {
            this.food = new FoodProperties.Builder().nutrition(nutrition).saturationModifier(saturation);
            return this;
        }

        Builder effect(Holder<MobEffect> effect, int duration) {
            return effect(effect, duration, 1.0F);
        }

        Builder effect(Holder<MobEffect> effect, int duration, float chance) {
            this.consumable.onConsume(new ApplyStatusEffectsConsumeEffect(new MobEffectInstance(effect, duration, 0), chance));
            return this;
        }

        Builder nourishment(int duration) {
            return effect(ModEffects.NOURISHMENT, duration);
        }

        Builder fast() {
            this.consumable.consumeSeconds(0.8F);
            return this;
        }

        ModFoods build() {
            // Drinks were alwaysEdible in the original.
            if (this.drink && this.food != null) {
                this.food.alwaysEdible();
            }
            return new ModFoods(this.food == null ? null : this.food.build(), this.consumable.build());
        }
    }
}
