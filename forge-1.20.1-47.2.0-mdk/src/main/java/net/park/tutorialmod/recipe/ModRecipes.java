package net.park.tutorialmod.recipe;

import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.park.tutorialmod.TutorialMod;

public class ModRecipes {
    public static final DeferredRegister<RecipeSerializer<?>>SERIALZERS=
            DeferredRegister.create(ForgeRegistries.RECIPE_SERIALIZERS, TutorialMod.MOD_ID);

    public static final RegistryObject<RecipeSerializer<GemPolishingRecipe>> GEM_POLISHING_SERIALIZER=
            SERIALZERS.register("gem_polishing",()-> GemPolishingRecipe.Serializer.INSTANCE);

    public static void register(IEventBus eventBus){
        SERIALZERS.register(eventBus);
    }
}
