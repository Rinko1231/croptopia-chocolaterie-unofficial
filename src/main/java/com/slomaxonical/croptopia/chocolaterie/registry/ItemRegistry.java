package com.slomaxonical.croptopia.chocolaterie.registry;

import com.slomaxonical.croptopia.chocolaterie.CroptopiaChocolaterie;
import me.thonk.croptopia.items.CookingUtensil;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.FoodComponent;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.util.registry.Registry;
import me.thonk.croptopia.Croptopia;
import me.thonk.croptopia.registry.FoodRegistry;

//import static me.thonk.croptopia.registry.FoodRegistry.*;
//import static me.thonk.croptopia.Croptopia.createGroup;
//import static com.slomaxonical.croptopia.chocolaterie.CroptopiaChocolaterie.createGroup;

public class ItemRegistry {

    public static final Item CACAO_NIBS = new Item(Croptopia.createGroup());
    public static final Item CACAO_MASS_BUCKET = new Item(Croptopia.createGroup().recipeRemainder(Items.BUCKET));
    public static final Item CACAO_MASS_BOTTLE = new Item(Croptopia.createGroup());
    public static final Item CACAO_BUTTER_BOTTLE = new Item(Croptopia.createGroup());
//    public static final Item COCOA_POWDER = new Item(Croptopia.createGroup());
//    public static Item pressedCocoaCone = new Item(CroptopiaChocolaterie.Croptopia.createGroup());

    public static final Item SILICON_DUST = new Item(Croptopia.createGroup());
    public static final CookingUtensil SILICON_MOLD = new CookingUtensil(Croptopia.createGroup().maxCount(1));
    public static final CookingUtensil ALL_PURPOSE_FILTER = new CookingUtensil(Croptopia.createGroup().maxCount(1));
    public static final CookingUtensil MANUAL_FOOD_GRINDER = new CookingUtensil(Croptopia.createGroup().maxCount(1));
    //    public static Item massFilledCloth = new Item(Croptopia.createGroup().maxCount(1).recipeRemainder(pressedCocoaCone));

    public static final Item DARK_CHOCOLATE = new Item(Croptopia.createGroup().food(FoodRegistry.EDIBLE_7));
    public static final Item CARAMEL_DARK_CHOCOLATE = new Item(Croptopia.createGroup().food(FoodRegistry.EDIBLE_7));
    public static final Item PRALINE_DARK_CHOCOLATE = new Item(Croptopia.createGroup().food(FoodRegistry.EDIBLE_7));
    public static final Item STRAWBERRY_CREAM_DARK_CHOCOLATE = new Item(Croptopia.createGroup().food(FoodRegistry.EDIBLE_7));
    public static final Item COOKIE_CREAM_DARK_CHOCOLATE = new Item(Croptopia.createGroup().food(FoodRegistry.EDIBLE_7));
    public static final Item MIXED_NUTS_DARK_CHOCOLATE = new Item(Croptopia.createGroup().food(FoodRegistry.EDIBLE_7));
    public static final Item COCONUT_DARK_CHOCOLATE = new Item(Croptopia.createGroup().food(FoodRegistry.EDIBLE_7));
    public static final Item PEANUT_BUTTER_DARK_CHOCOLATE = new Item(Croptopia.createGroup().food(FoodRegistry.EDIBLE_7));

    public static final Item MILK_CHOCOLATE = new Item(Croptopia.createGroup().food(FoodRegistry.EDIBLE_7));
    public static final Item CARAMEL_MILK_CHOCOLATE = new Item(Croptopia.createGroup().food(FoodRegistry.EDIBLE_7));
    public static final Item PRALINE_MILK_CHOCOLATE = new Item(Croptopia.createGroup().food(FoodRegistry.EDIBLE_7));
    public static final Item STRAWBERRY_CREAM_MILK_CHOCOLATE = new Item(Croptopia.createGroup().food(FoodRegistry.EDIBLE_7));
    public static final Item COOKIE_CREAM_MILK_CHOCOLATE = new Item(Croptopia.createGroup().food(FoodRegistry.EDIBLE_7));
    public static final Item MIXED_NUTS_MILK_CHOCOLATE = new Item(Croptopia.createGroup().food(FoodRegistry.EDIBLE_7));
    public static final Item COCONUT_MILK_CHOCOLATE = new Item(Croptopia.createGroup().food(FoodRegistry.EDIBLE_7));
    public static final Item PEANUT_BUTTER_MILK_CHOCOLATE = new Item(Croptopia.createGroup().food(FoodRegistry.EDIBLE_7));

    public static final Item WHITE_CHOCOLATE = new Item(Croptopia.createGroup().food(FoodRegistry.EDIBLE_7));
    public static final Item CARAMEL_WHITE_CHOCOLATE = new Item(Croptopia.createGroup().food(FoodRegistry.EDIBLE_7));
    public static final Item PRALINE_WHITE_CHOCOLATE = new Item(Croptopia.createGroup().food(FoodRegistry.EDIBLE_7));
    public static final Item STRAWBERRY_CREAM_WHITE_CHOCOLATE = new Item(Croptopia.createGroup().food(FoodRegistry.EDIBLE_7));
    public static final Item COOKIE_CREAM_WHITE_CHOCOLATE = new Item(Croptopia.createGroup().food(FoodRegistry.EDIBLE_7));
    public static final Item MIXED_NUTS_WHITE_CHOCOLATE = new Item(Croptopia.createGroup().food(FoodRegistry.EDIBLE_7));
    public static final Item COCONUT_WHITE_CHOCOLATE = new Item(Croptopia.createGroup().food(FoodRegistry.EDIBLE_7));
    public static final Item PEANUT_BUTTER_WHITE_CHOCOLATE = new Item(Croptopia.createGroup().food(FoodRegistry.EDIBLE_7));

    public static final Item GOLDEN_CHOCOLATE = new Item(Croptopia.createGroup().food(new FoodComponent.Builder()
            .hunger(7).
            saturationModifier(0.6f)
            .statusEffect(new StatusEffectInstance(StatusEffects.SPEED, 2400, 1), 1.0f)
            .statusEffect(new StatusEffectInstance(StatusEffects.ABSORPTION, 1200, 2), 0.7f)
            .statusEffect(new StatusEffectInstance(StatusEffects.REGENERATION, 100, 2), 0.7f)
            .alwaysEdible()
            .build()));
    public static final Item DARK_CHOCOLATE_COVERED_APPLE = new Item(Croptopia.createGroup().food(FoodRegistry.EDIBLE_7));
    public static final Item MILK_CHOCOLATE_COVERED_APPLE = new Item(Croptopia.createGroup().food(FoodRegistry.EDIBLE_7));
    public static final Item WHITE_CHOCOLATE_COVERED_APPLE = new Item(Croptopia.createGroup().food(FoodRegistry.EDIBLE_7));

    public static void init(){
        registerItem("cacao_nibs", CACAO_NIBS);
        registerItem("cacao_mass_bucket", CACAO_MASS_BUCKET);
        registerItem("cacao_mass_bottle", CACAO_MASS_BOTTLE);
        registerItem("cacao_butter_bottle", CACAO_BUTTER_BOTTLE);
//        registerItem("cocoa_powder", COCOA_POWDER);
//        registerItem("pressed_cocoa_cone",pressedCocoaCone);
        registerItem("silicon_dust", SILICON_DUST);
        registerItem("silicon_mold", SILICON_MOLD);
        registerItem("all_purpose_filter", ALL_PURPOSE_FILTER);
        registerItem("manual_food_grinder", MANUAL_FOOD_GRINDER);

        registerItem("dark_chocolate", DARK_CHOCOLATE);
        registerItem("caramel_dark_chocolate", CARAMEL_DARK_CHOCOLATE);
        registerItem("praline_dark_chocolate", PRALINE_DARK_CHOCOLATE);
        registerItem("strawberry_cream_dark_chocolate", STRAWBERRY_CREAM_DARK_CHOCOLATE);
        registerItem("cookie_cream_dark_chocolate", COOKIE_CREAM_DARK_CHOCOLATE);
        registerItem("mixed_nuts_dark_chocolate", MIXED_NUTS_DARK_CHOCOLATE);
        registerItem("coconut_dark_chocolate", COCONUT_DARK_CHOCOLATE);
        registerItem("peanut_butter_dark_chocolate", PEANUT_BUTTER_DARK_CHOCOLATE);

        registerItem("milk_chocolate", MILK_CHOCOLATE);
        registerItem("caramel_milk_chocolate", CARAMEL_MILK_CHOCOLATE);
        registerItem("praline_milk_chocolate", PRALINE_MILK_CHOCOLATE);
        registerItem("strawberry_cream_milk_chocolate", STRAWBERRY_CREAM_MILK_CHOCOLATE);
        registerItem("cookie_cream_milk_chocolate", COOKIE_CREAM_MILK_CHOCOLATE);
        registerItem("mixed_nuts_milk_chocolate", MIXED_NUTS_MILK_CHOCOLATE);
        registerItem("coconut_milk_chocolate", COCONUT_MILK_CHOCOLATE);
        registerItem("peanut_butter_milk_chocolate", PEANUT_BUTTER_MILK_CHOCOLATE);

        registerItem("white_chocolate", WHITE_CHOCOLATE);
        registerItem("caramel_white_chocolate", CARAMEL_WHITE_CHOCOLATE);
        registerItem("praline_white_chocolate", PRALINE_WHITE_CHOCOLATE);
        registerItem("strawberry_cream_white_chocolate", STRAWBERRY_CREAM_WHITE_CHOCOLATE);
        registerItem("cookie_cream_white_chocolate", COOKIE_CREAM_WHITE_CHOCOLATE);
        registerItem("mixed_nuts_white_chocolate", MIXED_NUTS_WHITE_CHOCOLATE);
        registerItem("coconut_white_chocolate", COCONUT_WHITE_CHOCOLATE);
        registerItem("peanut_butter_white_chocolate", PEANUT_BUTTER_WHITE_CHOCOLATE);

        registerItem("golden_chocolate", GOLDEN_CHOCOLATE);
        registerItem("dark_chocolate_covered_apple", DARK_CHOCOLATE_COVERED_APPLE);
        registerItem("milk_chocolate_covered_apple", MILK_CHOCOLATE_COVERED_APPLE);
        registerItem("white_chocolate_covered_apple", WHITE_CHOCOLATE_COVERED_APPLE);
    }

    private static Item registerItem(String itemName, Item item) {
        Registry.register(Registry.ITEM, CroptopiaChocolaterie.createIdentifier(itemName), item);
        return item;
    }
}
