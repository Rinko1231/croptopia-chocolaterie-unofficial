package com.slomaxonical.croptopia.chocolaterie;

import com.slomaxonical.croptopia.chocolaterie.registry.BlockRegistry;
import com.slomaxonical.croptopia.chocolaterie.registry.ItemRegistry;
import com.slomaxonical.croptopia.chocolaterie.registry.TabRegistry;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod("cacao")
public class CroptopiaChocolaterie {

    public static final String MOD_ID = "cacao";


    public CroptopiaChocolaterie(){
        IEventBus modBus = FMLJavaModLoadingContext.get().getModEventBus();

        BlockRegistry.BLOCKS.register(modBus);
        ItemRegistry.ITEMS.register(modBus);
        TabRegistry.TABS.register(modBus);

        MinecraftForge.EVENT_BUS.register(this);

    }

}
