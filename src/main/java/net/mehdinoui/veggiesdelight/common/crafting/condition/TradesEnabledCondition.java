package net.mehdinoui.veggiesdelight.common.crafting.condition;

import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import net.mehdinoui.veggiesdelight.Configuration;
import net.neoforged.neoforge.common.conditions.ICondition;

/**
 * Trades became data-driven (villager_trade registry), so the config toggles are applied as a load condition.
 */
public record TradesEnabledCondition(boolean wandering) implements ICondition {
    public static final MapCodec<TradesEnabledCondition> CODEC = Codec.BOOL.optionalFieldOf("wandering_trader", false)
            .xmap(TradesEnabledCondition::new, TradesEnabledCondition::wandering);

    @Override
    public boolean test(IContext context) {
        return wandering ? Configuration.ENABLE_WANDERING_TRADER_SELLS.get() : Configuration.ENABLE_VILLAGER_TRADES.get();
    }

    @Override
    public MapCodec<? extends ICondition> codec() {
        return CODEC;
    }
}
