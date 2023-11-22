package net.park.tutorialmod.block;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.park.tutorialmod.TutorialMod;
import net.park.tutorialmod.block.custom.*;
import net.park.tutorialmod.items.ModItems;
import net.park.tutorialmod.sound.ModSounds;

import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS=
            DeferredRegister.create(ForgeRegistries.BLOCKS, TutorialMod.MOD_ID);

    public static final RegistryObject<Block> RUBY_BLOCK=registerBlock("ruby_block",
            ()->new Block(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).sound(SoundType.AMETHYST)));

    public static final RegistryObject<Block> RAW_RUBY_BLOCK=registerBlock("raw_ruby_block",
            ()->new Block(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).sound(SoundType.AMETHYST)));

    public static final RegistryObject<Block> RUBY_STAIRS=registerBlock("ruby_stairs",
            ()->new StairBlock(()->ModBlocks.RUBY_BLOCK.get().defaultBlockState(),
                    BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).sound(SoundType.AMETHYST)));
    public static final RegistryObject<Block> RUBY_SLAB=registerBlock("ruby_slab",
            ()->new SlabBlock(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).sound(SoundType.AMETHYST)));
    public static final RegistryObject<Block> RUBY_BUTTON=registerBlock("ruby_button",
            ()->new ButtonBlock(BlockBehaviour.Properties.copy(Blocks.STONE_BUTTON).sound(SoundType.AMETHYST),
                    BlockSetType.IRON,10,true));
    public static final RegistryObject<Block> RUBY_PRESSURE_PLATE=registerBlock("ruby_pressure_plate",
            ()->new PressurePlateBlock(PressurePlateBlock.Sensitivity.EVERYTHING,BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).sound(SoundType.AMETHYST),
                    BlockSetType.IRON));
    public static final RegistryObject<Block> RUBY_FENCE=registerBlock("ruby_fence",
            ()->new FenceBlock(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).sound(SoundType.AMETHYST)));
    public static final RegistryObject<Block> RUBY_FENCE_GATE=registerBlock("ruby_fence_gate",
            ()->new FenceGateBlock(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).sound(SoundType.AMETHYST), SoundEvents.CHAIN_PLACE,SoundEvents.ANVIL_BREAK));
    public static final RegistryObject<Block> RUBY_WALL=registerBlock("ruby_wall",
            ()->new WallBlock(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).sound(SoundType.AMETHYST)));
    public static final RegistryObject<Block> RUBY_DOOR=registerBlock("ruby_door",
            ()->new DoorBlock(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).sound(SoundType.AMETHYST).noOcclusion(),BlockSetType.IRON));
    public static final RegistryObject<Block> RUBY_TRAPDOOR=registerBlock("ruby_trapdoor",
            ()->new TrapDoorBlock(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).sound(SoundType.AMETHYST).noOcclusion(),BlockSetType.IRON));


    public static final RegistryObject<Block> SOUND_BLOCK=registerBlock("sound_block",
            ()->new SoundBlock(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).sound(ModSounds.SOUND_BLOCK_SOUNDS)));


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

    public static final RegistryObject<Block> GEM_POLISHING_STATION=registerBlock("gem_polishing_station",
            ()->new GemPolishingStationBlock(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).noOcclusion()));


    public static final RegistryObject<Block> PINE_LOG=registerBlock("pine_log",
            ()->new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.OAK_LOG).strength(3f)));
    public static final RegistryObject<Block> PINE_WOOD=registerBlock("pine_wood",
            ()->new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.OAK_WOOD).strength(3f)));
    public static final RegistryObject<Block> STRIPPED_PINE_LOG=registerBlock("stripped_pine_log",
            ()->new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.STRIPPED_OAK_LOG).strength(3f)));
    public static final RegistryObject<Block> STRIPPED_PINE_WOOD=registerBlock("stripped_pine_wood",
            ()->new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.STRIPPED_OAK_WOOD).strength(3f)));

    public static final RegistryObject<Block> PINE_PLANKS=registerBlock("pine_planks",
            ()->new Block(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS)){
                @Override
                public boolean isFlammable(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return true;
                }

                @Override
                public int getFlammability(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return 20;                }

                @Override
                public int getFireSpreadSpeed(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return 5;
                }
            });
    public static final RegistryObject<Block> PINE_LEAVES=registerBlock("pine_leaves",
            ()->new LeavesBlock(BlockBehaviour.Properties.copy(Blocks.OAK_LEAVES)){
                @Override
                public boolean isFlammable(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return true;
                }

                @Override
                public int getFlammability(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return 60;                }

                @Override
                public int getFireSpreadSpeed(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return 30;
                }
            });



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
