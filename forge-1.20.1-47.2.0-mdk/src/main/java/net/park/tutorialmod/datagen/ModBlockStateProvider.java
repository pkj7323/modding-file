package net.park.tutorialmod.datagen;

import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.client.model.generators.ConfiguredModel;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;
import net.park.tutorialmod.TutorialMod;
import net.park.tutorialmod.block.ModBlocks;
import net.park.tutorialmod.block.custom.CornCropBlock;
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
}
