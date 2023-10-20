package net.potterplaysgames.leatherplus.item;

import net.minecraft.world.food.FoodProperties;

public class ModFoods {
    public static final FoodProperties PORK_RINDS = new FoodProperties.Builder().meat().nutrition(4)
            .saturationMod(0.5f).fast().build();
}
