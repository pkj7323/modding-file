package net.park.tutorialmod.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.park.tutorialmod.TutorialMod;
import net.park.tutorialmod.items.ModItems;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModItemTagGenerator extends ItemTagsProvider {


    public ModItemTagGenerator(PackOutput pOutput, CompletableFuture<HolderLookup.Provider> pLookupProvider,
                               CompletableFuture<TagLookup<Block>> pBlockTags, @Nullable ExistingFileHelper existingFileHelper) {
        super(pOutput, pLookupProvider, pBlockTags, TutorialMod.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider pProvider) {
        this.tag(ItemTags.TRIMMABLE_ARMOR)
                .add(   ModItems.RUBY_HELMET.get(),
                        ModItems.RUBY_CHESTPLATE.get(),
                        ModItems.RUBY_LEGGINGS.get(),
                        ModItems.RUBY_BOOTS.get());
        this.tag(ItemTags.MUSIC_DISCS)
                .add(ModItems.BAR_BRAWL_MUISIC_DISC.get())
                .add(ModItems.SAKURAMITSUTSUKI_MUSIC_DISC.get());
        this.tag(ItemTags.CREEPER_DROP_MUSIC_DISCS)
                .add(ModItems.BAR_BRAWL_MUISIC_DISC.get())
                .add(ModItems.SAKURAMITSUTSUKI_MUSIC_DISC.get());
    }
}
