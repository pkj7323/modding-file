package net.park.tutorialmod.datagen;

import net.minecraft.client.Minecraft;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.MinecartItem;
import net.minecraft.world.item.crafting.AbstractCookingRecipe;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.level.ItemLike;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;
import net.park.tutorialmod.TutorialMod;
import net.park.tutorialmod.block.ModBlocks;
import net.park.tutorialmod.items.ModItems;

import java.util.List;
import java.util.function.Consumer;

public class ModRecipeProvider extends RecipeProvider implements IConditionBuilder {
    private static final List<ItemLike>RUBY_SMELTABLES=List.of(ModItems.RAW_RUBY.get(),
        ModBlocks.RUBY_ORE.get(),ModBlocks.DEEPSLATE_RUBY_ORE.get(),ModBlocks.ENDER_RUBY_ORE.get(),
        ModBlocks.NETHER_RUBY_ORE.get());
    public ModRecipeProvider(PackOutput pOutput) {
        super(pOutput);
    }

    @Override
    protected void buildRecipes(Consumer<FinishedRecipe> pWriter) {
        oreBlasting(pWriter,RUBY_SMELTABLES,RecipeCategory.MISC,ModItems.RUBY.get(),0.25f,200,"ruby");
        oreSmelting(pWriter,RUBY_SMELTABLES,RecipeCategory.MISC,ModItems.RUBY.get(),0.25f,100,"ruby");

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC,ModBlocks.RUBY_BLOCK.get())
                .pattern("SSS")
                .pattern("SSS")
                .pattern("SSS")
                .define('S',ModItems.RUBY.get())
                .unlockedBy(getHasName(ModItems.RUBY.get()),has(ModItems.RUBY.get()))
                .save(pWriter);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC,ModBlocks.RAW_RUBY_BLOCK.get())
                .pattern("SSS")
                .pattern("SSS")
                .pattern("SSS")
                .define('S',ModItems.RAW_RUBY.get())
                .unlockedBy(getHasName(ModItems.RAW_RUBY.get()),has(ModItems.RAW_RUBY.get()))
                .save(pWriter);


        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT,ModItems.RUBY_SWORD.get())
                .pattern("S")
                .pattern("S")
                .pattern("#")
                .define('S',ModItems.RUBY.get()).define('#',ModItems.IRON_STICK.get())
                .unlockedBy(getHasName(ModItems.RUBY.get()),has(ModItems.RUBY.get()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS,ModItems.RUBY_PICKAXE.get())
                .pattern("SSS")
                .pattern(" # ")
                .pattern(" # ")
                .define('S',ModItems.RUBY.get()).define('#',ModItems.IRON_STICK.get())
                .unlockedBy(getHasName(ModItems.RUBY.get()),has(ModItems.RUBY.get()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS,ModItems.RUBY_AXE.get())
                .pattern("SS")
                .pattern("S#")
                .pattern(" #")
                .define('S',ModItems.RUBY.get()).define('#',ModItems.IRON_STICK.get())
                .unlockedBy(getHasName(ModItems.RUBY.get()),has(ModItems.RUBY.get()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS,ModItems.RUBY_HOE.get())
                .pattern("SS")
                .pattern(" #")
                .pattern(" #")
                .define('S',ModItems.RUBY.get()).define('#',ModItems.IRON_STICK.get())
                .unlockedBy(getHasName(ModItems.RUBY.get()),has(ModItems.RUBY.get()))
                .save(pWriter);
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS,ModItems.RUBY_SHOVEL.get())
                .pattern("S")
                .pattern("#")
                .pattern("#")
                .define('S',ModItems.RUBY.get()).define('#',ModItems.IRON_STICK.get())
                .unlockedBy(getHasName(ModItems.RUBY.get()),has(ModItems.RUBY.get()))
                .save(pWriter);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC,ModItems.IRON_STICK.get())
                .pattern("S")
                .pattern("S")
                .define('S', Items.IRON_INGOT)
                .unlockedBy(getHasName(ModItems.RUBY.get()),has(ModItems.RUBY.get()))
                .save(pWriter);
        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT,ModItems.RUBY_HELMET.get())
                .pattern("SSS")
                .pattern("S S")
                .define('S', ModItems.RUBY.get())
                .unlockedBy(getHasName(ModItems.RUBY.get()),has(ModItems.RUBY.get()))
                .save(pWriter);
        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT,ModItems.RUBY_CHESTPLATE.get())
                .pattern("S S")
                .pattern("SSS")
                .pattern("SSS")
                .define('S', ModItems.RUBY.get())
                .unlockedBy(getHasName(ModItems.RUBY.get()),has(ModItems.RUBY.get()))
                .save(pWriter);
        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT,ModItems.RUBY_LEGGINGS.get())
                .pattern("SSS")
                .pattern("S S")
                .pattern("S S")
                .define('S', ModItems.RUBY.get())
                .unlockedBy(getHasName(ModItems.RUBY.get()),has(ModItems.RUBY.get()))
                .save(pWriter);
        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT,ModItems.RUBY_BOOTS.get())
                .pattern("S S")
                .pattern("S S")
                .define('S', ModItems.RUBY.get())
                .unlockedBy(getHasName(ModItems.RUBY.get()),has(ModItems.RUBY.get()))
                .save(pWriter);


        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC,ModItems.RUBY.get(),9)
                .requires(ModBlocks.RUBY_BLOCK.get())
                .unlockedBy(getHasName(ModBlocks.RUBY_BLOCK.get()),has(ModBlocks.RUBY_BLOCK.get()))
                .save(pWriter);
    }
    protected static void oreSmelting(Consumer<FinishedRecipe> pFinishedRecipeConsumer, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTIme, String pGroup) {
        oreCooking(pFinishedRecipeConsumer, RecipeSerializer.SMELTING_RECIPE, pIngredients, pCategory, pResult, pExperience, pCookingTIme, pGroup, "_from_smelting");
    }

    protected static void oreBlasting(Consumer<FinishedRecipe> pFinishedRecipeConsumer, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTime, String pGroup) {
        oreCooking(pFinishedRecipeConsumer, RecipeSerializer.BLASTING_RECIPE, pIngredients, pCategory, pResult, pExperience, pCookingTime, pGroup, "_from_blasting");
    }

    protected static void oreCooking(Consumer<FinishedRecipe> pFinishedRecipeConsumer, RecipeSerializer<? extends AbstractCookingRecipe> pCookingSerializer, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTime, String pGroup, String pRecipeName) {
        for(ItemLike itemlike : pIngredients) {
            SimpleCookingRecipeBuilder.generic(Ingredient.of(itemlike)
                    ,pCategory, pResult, pExperience, pCookingTime, pCookingSerializer)
                    .group(pGroup).unlockedBy(getHasName(itemlike), has(itemlike))
                    .save(pFinishedRecipeConsumer, TutorialMod.MOD_ID +":"+getItemName(pResult) + pRecipeName + "_" + getItemName(itemlike));
        }

    }
}
