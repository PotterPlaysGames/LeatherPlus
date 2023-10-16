package net.potterplaysgames.leatherplus.block;

import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.DropExperienceBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.potterplaysgames.leatherplus.LeatherPlus;
import net.potterplaysgames.leatherplus.item.ModItems;

import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, LeatherPlus.MOD_ID);

    /////////////////////////BLOCKS//////////////////
    public static final RegistryObject<Block> STEEL_BLOCK = registerBlock("steel_block",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).sound(SoundType.METAL)));

    /////////////////////////////////////////////////
    ////////////////////////ORES/////////////////////
    /*public static final RegistryObject<Block> ORE_PLACEHOLDER = registerBlock("ore_placeholder",
            ()-> new DropExperienceBlock(BlockBehaviour.Properties.copy(Blocks.STONE)
                    .strength(2f).requiresCorrectToolForDrops(), UniformInt.of(3,6)));
    public static final RegistryObject<Block> DEEPSLATE_ORE_PLACEHOLDER = registerBlock("deepslate_ore_placeholder",
            ()-> new DropExperienceBlock(BlockBehaviour.Properties.copy(Blocks.DEEPSLATE)
                    .strength(3f).requiresCorrectToolForDrops(), UniformInt.of(3,6)));

    public static final RegistryObject<Block> NETHER_ORE_PLACEHOLDER = registerBlock("nether_ore_placeholder",
            ()-> new DropExperienceBlock(BlockBehaviour.Properties.copy(Blocks.NETHERRACK)
                    .strength(4f).requiresCorrectToolForDrops(), UniformInt.of(3,6)));

    public static final RegistryObject<Block> END_ORE_PLACEHOLDER = registerBlock("end_ore_placeholder",
            ()-> new DropExperienceBlock(BlockBehaviour.Properties.copy(Blocks.END_STONE)
                    .strength(5f).requiresCorrectToolForDrops(), UniformInt.of(3,6)));*/
    /////////////////////////////////////////////////

    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block> RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block){
        return ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }

    public static void register (IEventBus eventBus){
        BLOCKS.register(eventBus);
    }
}
