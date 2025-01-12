package com.slomaxonical.croptopia.chocolaterie.registry;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;


import static com.slomaxonical.croptopia.chocolaterie.CroptopiaChocolaterie.MOD_ID;


public class TabRegistry {
    public static final DeferredRegister<CreativeModeTab> TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, MOD_ID);

    public static final DeferredHolder<CreativeModeTab, CreativeModeTab> CACAO_TAB = TABS.register(MOD_ID, () -> CreativeModeTab.builder()
            // Set name of tab to display
            .title(Component.translatable("item_group." + MOD_ID))
            // Set icon of creative tab
            .icon(() -> new ItemStack(ItemRegistry.CARAMEL_MILK_CHOCOLATE.get()))
            // Add default items to tab
            .displayItems((params, output) -> ItemRegistry.ITEMS.getEntries().forEach(it -> output.accept(it.get())))
            .build()
    );
}