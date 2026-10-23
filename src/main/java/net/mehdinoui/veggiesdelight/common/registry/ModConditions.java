package net.mehdinoui.veggiesdelight.common.registry;

import com.mojang.serialization.MapCodec;
import net.mehdinoui.veggiesdelight.VeggiesDelight;
import net.mehdinoui.veggiesdelight.common.crafting.condition.TradesEnabledCondition;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.common.conditions.ICondition;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.NeoForgeRegistries;

import java.util.function.Supplier;

public class ModConditions {
    public static final DeferredRegister<MapCodec<? extends ICondition>> CONDITIONS =
            DeferredRegister.create(NeoForgeRegistries.Keys.CONDITION_CODECS, VeggiesDelight.MOD_ID);

    public static final Supplier<MapCodec<TradesEnabledCondition>> TRADES_ENABLED =
            CONDITIONS.register("trades_enabled", () -> TradesEnabledCondition.CODEC);

    public static void register(IEventBus eventBus) {
        CONDITIONS.register(eventBus);
    }
}
