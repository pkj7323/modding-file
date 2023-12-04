package net.park.tutorialmod.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.data.BlockTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.park.tutorialmod.TutorialMod;
import net.park.tutorialmod.block.ModBlocks;
import net.park.tutorialmod.util.ModTags;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagGenerator extends BlockTagsProvider {

    public ModBlockTagGenerator(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, TutorialMod.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider pProvider) {
        this.tag(ModTags.Blocks.METAL_DETECTOR_VALUES)
                .add(ModBlocks.RUBY_ORE.get()).addTags(Tags.Blocks.ORES);//데이터 생성으로 블럭에 테그 넣기

        this.tag(BlockTags.MINEABLE_WITH_PICKAXE)
                .add(ModBlocks.RUBY_BLOCK.get(),
                        ModBlocks.RAW_RUBY_BLOCK.get(),
                        ModBlocks.RUBY_ORE.get(),
                        ModBlocks.ENDER_RUBY_ORE.get(),
                        ModBlocks.NETHER_RUBY_ORE.get(),
                        ModBlocks.SOUND_BLOCK.get()
                        );
        this.tag(BlockTags.NEEDS_IRON_TOOL)
                .add(ModBlocks.RUBY_BLOCK.get());
        this.tag(BlockTags.NEEDS_DIAMOND_TOOL)
                .add(ModBlocks.RAW_RUBY_BLOCK.get());
        this.tag(BlockTags.NEEDS_STONE_TOOL)
                .add(ModBlocks.NETHER_RUBY_ORE.get());
        this.tag(Tags.Blocks.NEEDS_NETHERITE_TOOL)
                .add(ModBlocks.ENDER_RUBY_ORE.get());

        this.tag(ModTags.Blocks.PAXEL_MINEABLE)
                .addTag(BlockTags.MINEABLE_WITH_PICKAXE)
                .addTag(BlockTags.MINEABLE_WITH_AXE)
                .addTag(BlockTags.MINEABLE_WITH_SHOVEL);



        //울타리가 연결되기 위해서는 태그 설정이 필요
        this.tag(BlockTags.FENCES)
                .add(ModBlocks.RUBY_FENCE.get());
        this.tag(BlockTags.FENCE_GATES)
                .add(ModBlocks.RUBY_FENCE_GATE.get());
        this.tag(BlockTags.WALLS)
                .add(ModBlocks.RUBY_WALL.get());
        this.tag(BlockTags.LOGS_THAT_BURN)
                .add(ModBlocks.PINE_LOG.get())
                .add(ModBlocks.PINE_WOOD.get())
                .add(ModBlocks.STRIPPED_PINE_LOG.get())
                .add(ModBlocks.STRIPPED_PINE_WOOD.get());
        this.tag(BlockTags.PLANKS)
                .add(ModBlocks.PINE_PLANKS.get());
    }
}
