package com.slomaxonical.croptopia.chocolaterie;

import com.slomaxonical.croptopia.chocolaterie.registry.BlockRegistry;
import com.slomaxonical.croptopia.chocolaterie.registry.ItemRegistry;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.fabricmc.fabric.api.resource.ResourceManagerHelper;
import net.fabricmc.fabric.api.resource.ResourcePackActivationType;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.Identifier;


public class CroptopiaChocolaterie implements ModInitializer {

    public static String MOD_ID = "cacao";
    public static final ItemGroup CACAO_ITEM_GROUP = FabricItemGroupBuilder.create(new Identifier(MOD_ID, "item_group"))
            .icon(() -> new ItemStack(Items.SOUL_SAND))
            .build();
    public static Identifier createIdentifier(String name) {
        return new Identifier(MOD_ID, name);
    }


    @Override
    public void onInitialize() {
        if(FabricLoader.getInstance().isModLoaded("croptopia")) {
            ResourceManagerHelper.registerBuiltinResourcePack(new Identifier("croptop"),FabricLoader.getInstance().getModContainer(MOD_ID).orElseThrow(),ResourcePackActivationType.ALWAYS_ENABLED);
        }
        ItemRegistry.init();
        BlockRegistry.init();
    }
}
