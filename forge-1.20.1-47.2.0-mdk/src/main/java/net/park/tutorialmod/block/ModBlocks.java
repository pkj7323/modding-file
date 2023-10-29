package net.park.tutorialmod.block;

import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.park.tutorialmod.TutorialMod;
import net.park.tutorialmod.block.custom.CornCropBlock;
import net.park.tutorialmod.block.custom.SoundBlock;
import net.park.tutorialmod.block.custom.StrawberryCropBlock;
import net.park.tutorialmod.items.ModItems;
import net.park.tutorialmod.sound.ModSounds;

import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS=
            DeferredRegister.create(ForgeRegistries.BLOCKS, TutorialMod.MOD_ID);

    public static final RegistryObject<Block> RUBY_BLOCK=registerBlock("ruby_block",
            ()->new Block(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).sound(SoundType.AMETHYST)));
    public static final RegistryObject<Block> SOUND_BLOCK=registerBlock("sound_block",
            ()->new SoundBlock(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).sound(ModSounds.SOUND_BLOCK_SOUNDS)));
    public static final RegistryObject<Block> RAW_RUBY_BLOCK=registerBlock("raw_ruby_block",
            ()->new Block(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).sound(SoundType.AMETHYST)));

    public static final RegistryObject<Block> RUBY_ORE=registerBlock("ruby_ore",
            ()->new DropExperienceBlock(BlockBehaviour.Properties.copy(Blocks.STONE)
                    .strength(2f).requiresCorrectToolForDrops(), UniformInt.of(3,6)));
    public static final RegistryObject<Block> DEEPSLATE_RUBY_ORE=registerBlock("deepslate_ruby_ore",
            ()->new DropExperienceBlock(BlockBehaviour.Properties.copy(Blocks.DEEPSLATE)
                    .strength(2f).requiresCorrectToolForDrops(), UniformInt.of(3,6)));
    public static final RegistryObject<Block> ENDER_RUBY_ORE=registerBlock("ender_ruby_ore",
            ()->new DropExperienceBlock(BlockBehaviour.Properties.copy(Blocks.END_STONE)
                    .strength(2f).requiresCorrectToolForDrops(), UniformInt.of(3,6)));
    public static final RegistryObject<Block> NETHER_RUBY_ORE=registerBlock("nether_ruby_ore",
            ()->new DropExperienceBlock(BlockBehaviour.Properties.copy(Blocks.NETHERRACK)
                    .strength(2f).requiresCorrectToolForDrops(), UniformInt.of(3,6)));

    public static final RegistryObject<Block> STRAWBERRY_CROP=BLOCKS.register("strawberry_crop",
            ()->new StrawberryCropBlock(BlockBehaviour.Properties.copy(Blocks.WHEAT).noOcclusion().noCollission()));

    public static final RegistryObject<Block> CORN_CROP=BLOCKS.register("corn_crop",
            ()->new CornCropBlock(BlockBehaviour.Properties.copy(Blocks.WHEAT).noOcclusion().noCollission()));

    public static final RegistryObject<Block> CATMINT=registerBlock("catmint",
            ()-> new FlowerBlock(()-> MobEffects.LUCK,5,
                    BlockBehaviour.Properties.copy(Blocks.ALLIUM).noCollission().noOcclusion()));
    public static final RegistryObject<Block> POTTED_CATMINT=registerBlock("potted_catmint",
            ()-> new FlowerPotBlock(()-> ((FlowerPotBlock) Blocks.FLOWER_POT),ModBlocks.CATMINT,
                    BlockBehaviour.Properties.copy(Blocks.POTTED_ALLIUM).noOcclusion()));


    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block){
        RegistryObject<T> toReturn=BLOCKS.register(name,block);
        registerBLockItem(name,toReturn);
        return toReturn;
    }


    private static <T extends Block> RegistryObject<Item> registerBLockItem(String name, RegistryObject<T>block){
        return ModItems.ITEMS.register(name,()-> new BlockItem(block.get(),new Item.Properties()));
    }



    public static void register(IEventBus eventBus){
        BLOCKS.register(eventBus);
    }

}
