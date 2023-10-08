package net.park.tutorialmod.items.util;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.park.tutorialmod.TutorialMod;

public class ModTags {
    public static class Blocks{
        public static final TagKey<Block>METAL_DETECTOR_VALUES=tag("metal_detector_valuables");
        public static final TagKey<Block>NEEDS_RUBY_TOOL=tag("needs_ruby_tool");
        public static final TagKey<Block>DEUS_EX_MACHINA=tag("deus_ex_machina");
        private static TagKey<Block> tag(String name){
            return BlockTags.create(new ResourceLocation(TutorialMod.MOD_ID,name));
        }
    }
    public static class Items{
        private static TagKey<Item> tag(String name){
            return ItemTags.create(new ResourceLocation(TutorialMod.MOD_ID,name));
        }
    }
}
