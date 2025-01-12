package com.slomaxonical.croptopia.chocolaterie;

import com.slomaxonical.croptopia.chocolaterie.registry.BlockRegistry;
import com.slomaxonical.croptopia.chocolaterie.registry.ItemRegistry;
import com.slomaxonical.croptopia.chocolaterie.registry.TabRegistry;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;


@Mod("cacao")
public class CroptopiaChocolaterie {

    public static final String MOD_ID = "cacao";


    public CroptopiaChocolaterie(IEventBus modBus){


        BlockRegistry.BLOCKS.register(modBus);
        ItemRegistry.ITEMS.register(modBus);
        TabRegistry.TABS.register(modBus);



    }

}
