package net.park.tutorialmod.event;

import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.park.tutorialmod.TutorialMod;
import net.park.tutorialmod.block.entity.ModBlockEntities;
import net.park.tutorialmod.block.entity.renderer.GemPolishingBlockEntityRenderer;
import net.park.tutorialmod.entity.client.ModModelLayers;
import net.park.tutorialmod.entity.client.RhinoModel;

@Mod.EventBusSubscriber(modid = TutorialMod.MOD_ID,bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModEventBusClientEvents {
    @SubscribeEvent
    public static void registerLayer(EntityRenderersEvent.RegisterLayerDefinitions event){
        event.registerLayerDefinition(ModModelLayers.RhINO_LAYER, RhinoModel::createBodyLayer);
    }
    @SubscribeEvent
    public static void registerBER(EntityRenderersEvent.RegisterRenderers event){
        event.registerBlockEntityRenderer(ModBlockEntities.GEM_POLISHING_BE.get(), GemPolishingBlockEntityRenderer::new);
    }
}
