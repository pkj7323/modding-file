package net.park.tutorialmod.items;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.Tiers;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.common.ForgeTier;
import net.minecraftforge.common.TierSortingRegistry;
import net.park.tutorialmod.TutorialMod;
import net.park.tutorialmod.util.ModTags;

import java.util.List;

public class ModToolTiers {
    public static final Tier RUBY= TierSortingRegistry.registerTier(
            new ForgeTier(5,1500,5f,4f,25,
                    ModTags.Blocks.NEEDS_RUBY_TOOL,()-> Ingredient.of(ModItems.RUBY.get())),
            new ResourceLocation(TutorialMod.MOD_ID,"ruby"), List.of(Tiers.NETHERITE),List.of());
    public static final Tier GOD= TierSortingRegistry.registerTier(
            new ForgeTier(5,20000,5f,8f,25,
                    ModTags.Blocks.DEUS_EX_MACHINA,()->Ingredient.of(ModItems.RUBY.get())),
            new ResourceLocation(TutorialMod.MOD_ID,"dues_ex_machina"), List.of(Tiers.NETHERITE),List.of());
}
