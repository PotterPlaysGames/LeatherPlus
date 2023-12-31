package net.potterplaysgames.leatherplus.item;

import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.potterplaysgames.leatherplus.LeatherPlus;
import net.potterplaysgames.leatherplus.item.custom.StrapCuttingItem;

public class ModItems {

    //Long List of items
    //Deferred Register is a massive list of objects kinda like a big array.
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, LeatherPlus.MOD_ID);

    ///////////////////REGISTER ITEMS HERE////////////////
    public static final RegistryObject<Item> STRAPCUTTERHANDLE = ITEMS.register("strapcutterhandle",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> STRAPCUTTERBLADE = ITEMS.register("strapcutterblade",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> STRAPCUTTERBOLT = ITEMS.register("strapcutterbolt",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> STRAPCUTTERINSERT = ITEMS.register("strapcutterinsert",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> STRAPCUTTERPLATE = ITEMS.register("strapcutterplate",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> STRAPCUTTER = ITEMS.register("strapcutter",
            () -> new StrapCuttingItem(new Item.Properties().durability(64)));

    public static final RegistryObject<Item> FLINTKNIFE = ITEMS.register("flintknife",
            () -> new StrapCuttingItem(new Item.Properties().durability(1)));

    public static final RegistryObject<Item> STRAPS = ITEMS.register("straps",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> STEEL = ITEMS.register("steel",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> STEEL_CHUNK = ITEMS.register("steel_chunk",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> STEEL_NUGGET = ITEMS.register("steel_nugget",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> ANDESITE_POWDER = ITEMS.register("andesite_powder",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> QUARTZ_POWDER = ITEMS.register("quartz_powder",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> VINYL_POWDER = ITEMS.register("vinyl_powder",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> ROLL_OF_PAPER = ITEMS.register("roll_of_paper",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> FABRIC_BACKING = ITEMS.register("fabric_backing",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> RAW_COW_HIDE = ITEMS.register("raw_cow_hide",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> RAW_PIG_HIDE = ITEMS.register("raw_pig_hide",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> RAW_SHEEP_HIDE = ITEMS.register("raw_sheep_hide",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> SLICED_RAW_PIG_HIDE = ITEMS.register("sliced_raw_pig_hide",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> PORK_RINDS = ITEMS.register("pork_rinds",
            () -> new Item(new Item.Properties().food(ModFoods.PORK_RINDS)));

    //////////////////////////////////////////////////////
    public static void register(IEventBus eventBus){
        ITEMS.register(eventBus);
    }
}
