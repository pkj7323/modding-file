package net.park.tutorialmod.event;

import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.park.tutorialmod.TutorialMod;
import net.park.tutorialmod.entity.ModEntities;
import net.park.tutorialmod.entity.custom.RhinoEntity;

@Mod.EventBusSubscriber(modid = TutorialMod.MOD_ID,bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModEventBusEvents {
    @SubscribeEvent
    public static void registerAttributes(EntityAttributeCreationEvent event){
        event.put(ModEntities.RHINO.get(), RhinoEntity.createAttributes().build());
    }
}
