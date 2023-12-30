package net.park.tutorialmod.items;

import net.minecraft.client.renderer.item.ItemProperties;
import net.minecraft.resources.ResourceLocation;
import net.park.tutorialmod.TutorialMod;

public class ModItemProperties {
    public static void addCustomItemProperties(){
        ItemProperties.register(ModItems.DATA_TABLET.get(),new ResourceLocation(TutorialMod.MOD_ID,"on"),
                (pStack, pLevel, pEntity, pSeed) -> pStack.hasTag() ? 1f : 0f);
    }
}
