package net.potterplaysgames.leatherplus.item;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;
import net.potterplaysgames.leatherplus.LeatherPlus;
import net.potterplaysgames.leatherplus.block.ModBlocks;

public class ModCreativeModTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, LeatherPlus.MOD_ID);

    public static final RegistryObject<CreativeModeTab> LEATHERPLUS_TAB = CREATIVE_MODE_TABS.register("leatherplus_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.STRAPCUTTER.get()))
                    .title(Component.translatable("creativetab.leatherplus_tab"))
                    .displayItems((pParameters, pOutput) -> {
                        pOutput.accept(ModItems.RAW_COW_HIDE.get());
                        pOutput.accept(ModItems.RAW_PIG_HIDE.get());
                        pOutput.accept(ModItems.SLICED_RAW_PIG_HIDE.get());
                        pOutput.accept(ModItems.PORK_RINDS.get());
                        pOutput.accept(ModItems.RAW_SHEEP_HIDE.get());
                        pOutput.accept(ModItems.STRAPS.get());
                        pOutput.accept(ModItems.STRAPCUTTERHANDLE.get());
                        pOutput.accept(ModItems.STRAPCUTTERINSERT.get());
                        pOutput.accept(ModItems.STRAPCUTTERPLATE.get());
                        pOutput.accept(ModItems.STRAPCUTTERBOLT.get());
                        pOutput.accept(ModItems.STRAPCUTTERBLADE.get());
                        pOutput.accept(ModItems.STRAPCUTTER.get());
                        pOutput.accept(ModItems.FLINTKNIFE.get());
                        pOutput.accept(ModItems.STEEL.get());
                        pOutput.accept(ModItems.STEEL_NUGGET.get());
                        pOutput.accept(ModItems.STEEL_CHUNK.get());
                        pOutput.accept(ModBlocks.STEEL_BLOCK.get());
                        pOutput.accept(ModItems.ANDESITE_POWDER.get());
                        pOutput.accept(ModItems.QUARTZ_POWDER.get());
                        pOutput.accept(ModItems.VINYL_POWDER.get());
                        pOutput.accept(ModItems.ROLL_OF_PAPER.get());
                        pOutput.accept(ModItems.FABRIC_BACKING.get());

                    })
                    .build());

    public static void register(IEventBus eventBus){
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
