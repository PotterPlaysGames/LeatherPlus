package net.potterplaysgames.leatherplus.item;

import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.potterplaysgames.leatherplus.LeatherPlus;

public class ModItems {
    //Long List of items
    //Deferred Register is a massive list of objects kinda like a big array.
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, LeatherPlus.MOD_ID);

    ///////////////////REGISTER ITEMS HERE////////////////
    public static final RegistryObject<Item> STRAPCUTTER = ITEMS.register("strapcutter",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> STRAPS = ITEMS.register("straps",
            () -> new Item(new Item.Properties()));

    //////////////////////////////////////////////////////
    public static void register(IEventBus eventBus){
        ITEMS.register(eventBus);
    }
}
