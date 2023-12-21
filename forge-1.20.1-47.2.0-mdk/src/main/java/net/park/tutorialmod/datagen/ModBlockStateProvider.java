package net.park.tutorialmod.datagen;

import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.client.model.generators.ConfiguredModel;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.park.tutorialmod.TutorialMod;
import net.park.tutorialmod.block.ModBlocks;
import net.park.tutorialmod.block.custom.CornCropBlock;
import net.park.tutorialmod.block.custom.RubyLampBlock;
import net.park.tutorialmod.block.custom.StrawberryCropBlock;

import java.util.function.Function;

public class ModBlockStateProvider extends BlockStateProvider {
    public ModBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper){
        super(output, TutorialMod.MOD_ID,exFileHelper);
    }
    private void blockWithItem(RegistryObject<Block> blockRegistryObject){
        simpleBlockWithItem(blockRegistryObject.get(),cubeAll(blockRegistryObject.get()));
    }

    @Override
    protected void registerStatesAndModels() {
        blockWithItem(ModBlocks.RUBY_BLOCK);
        blockWithItem(ModBlocks.RAW_RUBY_BLOCK);

        blockWithItem(ModBlocks.ENDER_RUBY_ORE);
        blockWithItem(ModBlocks.NETHER_RUBY_ORE);
        blockWithItem(ModBlocks.RUBY_ORE);
        blockWithItem(ModBlocks.DEEPSLATE_RUBY_ORE);

        stairsBlock(((StairBlock) ModBlocks.RUBY_STAIRS.get()),blockTexture(ModBlocks.RUBY_BLOCK.get()));
        slabBlock(((SlabBlock) ModBlocks.RUBY_SLAB.get()),blockTexture(ModBlocks.RUBY_BLOCK.get()),blockTexture(ModBlocks.RUBY_BLOCK.get()));

        buttonBlock(((ButtonBlock) ModBlocks.RUBY_BUTTON.get()),blockTexture(ModBlocks.RUBY_BLOCK.get()));
        pressurePlateBlock(((PressurePlateBlock) ModBlocks.RUBY_PRESSURE_PLATE.get()),blockTexture(ModBlocks.RUBY_BLOCK.get()));

        fenceBlock(((FenceBlock) ModBlocks.RUBY_FENCE.get()),blockTexture(ModBlocks.RUBY_BLOCK.get()));
        fenceGateBlock(((FenceGateBlock) ModBlocks.RUBY_FENCE_GATE.get()),blockTexture(ModBlocks.RUBY_BLOCK.get()));
        wallBlock(((WallBlock) ModBlocks.RUBY_WALL.get()),blockTexture(ModBlocks.RUBY_BLOCK.get()));

        doorBlockWithRenderType(((DoorBlock) ModBlocks.RUBY_DOOR.get()),modLoc("block/ruby_door_bottom"),modLoc("block/ruby_door_top"),"cutout");
        trapdoorBlockWithRenderType(((TrapDoorBlock) ModBlocks.RUBY_TRAPDOOR.get()),modLoc("block/ruby_trapdoor"),true,"cutout");


        blockWithItem(ModBlocks.SOUND_BLOCK);

        makeStrawberryCrop((CropBlock) ModBlocks.STRAWBERRY_CROP.get(),"strawberry_stage","strawberry_stage");
        makeCornCorp(((CropBlock) ModBlocks.CORN_CROP.get()),"corn_stage_","corn_stage_");


        simpleBlockWithItem(ModBlocks.CATMINT.get(),models().cross(blockTexture(ModBlocks.CATMINT.get()).getPath(),
                blockTexture(ModBlocks.CATMINT.get())).renderType("cutout"));

        simpleBlockWithItem(ModBlocks.POTTED_CATMINT.get(), models().singleTexture("potted_catmint", new ResourceLocation("flower_pot_cross"), "plant",
                blockTexture(ModBlocks.CATMINT.get())).renderType("cutout"));
        simpleBlockWithItem(ModBlocks.GEM_POLISHING_STATION.get(),
                new ModelFile.UncheckedModelFile(modLoc("block/gem_polishing_station")));

        logBlock((RotatedPillarBlock) ModBlocks.PINE_LOG.get());
        axisBlock(((RotatedPillarBlock) ModBlocks.PINE_WOOD.get()), blockTexture(ModBlocks.PINE_LOG.get()),blockTexture(ModBlocks.PINE_LOG.get()));

        axisBlock(((RotatedPillarBlock) ModBlocks.STRIPPED_PINE_LOG.get()), blockTexture(ModBlocks.STRIPPED_PINE_LOG.get()),
                new ResourceLocation(TutorialMod.MOD_ID,"block/stripped_pine_log_top"));
        axisBlock(((RotatedPillarBlock) ModBlocks.STRIPPED_PINE_WOOD.get()), blockTexture(ModBlocks.STRIPPED_PINE_LOG.get()),
                blockTexture(ModBlocks.STRIPPED_PINE_LOG.get()));

        blockItem(ModBlocks.PINE_LOG);
        blockItem(ModBlocks.PINE_WOOD);
        blockItem(ModBlocks.STRIPPED_PINE_WOOD);
        blockItem(ModBlocks.STRIPPED_PINE_LOG);

        blockWithItem(ModBlocks.PINE_PLANKS);

        levesBlock(ModBlocks.PINE_LEAVES);
        customLamp();
    }
    private void levesBlock(RegistryObject<Block> blockRegistryObject){
        simpleBlockWithItem(blockRegistryObject.get(),
                models().singleTexture(ForgeRegistries.BLOCKS.getKey(blockRegistryObject.get()).getPath(),new ResourceLocation("minecraft:block/leaves"),
                        "all",blockTexture(blockRegistryObject.get())).renderType("cutout"));
    }
    private void blockItem(RegistryObject<Block> blockRegistryObject){
        simpleBlockItem(blockRegistryObject.get(),new ModelFile.UncheckedModelFile(TutorialMod.MOD_ID+
                ":block/"+ ForgeRegistries.BLOCKS.getKey(blockRegistryObject.get()).getPath()));
    }
    public void makeStrawberryCrop(CropBlock block,String modelName,String textureName){
        Function<BlockState, ConfiguredModel[]> function = state -> strawberryStates(state,block,modelName,textureName);

        getVariantBuilder(block).forAllStates(function);
    }
    private ConfiguredModel[] strawberryStates(BlockState state, CropBlock block, String modelName, String textureName) {
        ConfiguredModel[] models = new ConfiguredModel[1];
        models[0] = new ConfiguredModel(models().crop(modelName + state.getValue(((StrawberryCropBlock) block).getAgeProperty()),
                new ResourceLocation(TutorialMod.MOD_ID, "block/" + textureName + state.getValue(((StrawberryCropBlock) block).getAgeProperty()))).renderType("cutout"));

        return models;
    }
    public void makeCornCorp(CropBlock block,String modelName,String textureName){
        Function<BlockState,ConfiguredModel[]> function = state -> cornStates(state,block,modelName,textureName);

        getVariantBuilder(block).forAllStates(function);
    }
    private ConfiguredModel[] cornStates(BlockState state, CropBlock block, String modelName, String textureName) {
        ConfiguredModel[] models = new ConfiguredModel[1];
        models[0] = new ConfiguredModel(models().crop(modelName + state.getValue(((CornCropBlock) block).getAgeProperty()),
                new ResourceLocation(TutorialMod.MOD_ID, "block/" + textureName + state.getValue(((CornCropBlock) block).getAgeProperty()))).renderType("cutout"));

        return models;
    }
    private void customLamp(){
        getVariantBuilder(ModBlocks.RUBY_LAMP.get()).forAllStates(state ->{
            if (state.getValue(RubyLampBlock.CLICKED)){
                return new ConfiguredModel[]{new ConfiguredModel(models().cubeAll("ruby_lamp_on",
                        new ResourceLocation(TutorialMod.MOD_ID,"block/"+"ruby_lamp_off")))};
            }else {
                return new ConfiguredModel[]{new ConfiguredModel(models().cubeAll("ruby_lamp_off",
                        new ResourceLocation(TutorialMod.MOD_ID,"block/"+"ruby_lamp_off")))};
            }
        });
        simpleBlockItem(ModBlocks.RUBY_LAMP.get(), models().cubeAll("ruby_lamp_on",
                new ResourceLocation(TutorialMod.MOD_ID,"block/"+"ruby_lamp_on")));
    }
}
