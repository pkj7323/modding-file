package net.park.tutorialmod.villager;

import com.google.common.collect.ImmutableSet;
import com.google.errorprone.annotations.Immutable;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.entity.ai.village.poi.PoiType;
import net.minecraft.world.entity.npc.VillagerProfession;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.park.tutorialmod.TutorialMod;
import net.park.tutorialmod.block.ModBlocks;

public class ModVillagers {
    public static final DeferredRegister<PoiType> POI_TYPES=
            DeferredRegister.create(ForgeRegistries.POI_TYPES, TutorialMod.MOD_ID);
    public static final DeferredRegister<VillagerProfession> VILLAGER_PROFESSIONS=
            DeferredRegister.create(ForgeRegistries.VILLAGER_PROFESSIONS, TutorialMod.MOD_ID);
    public static final RegistryObject<PoiType>SOUND_POI=POI_TYPES.register("sound_poi",
        ()-> new PoiType(ImmutableSet.copyOf(ModBlocks.SOUND_BLOCK.get().getStateDefinition().getPossibleStates()),
                1,1));//이미 poi타입이 되있는 블럭을 사용하면 온갖오류가생김 그러므로 커스텀 블럭이나 poi가 없는 블럭을 쓰자

    public static final RegistryObject<VillagerProfession>SOUND_MASTER=
            VILLAGER_PROFESSIONS.register("soundmaster",()->new VillagerProfession("soundmaster",
                    holder-> holder.get()==SOUND_POI.get(),holder->holder.get() == SOUND_POI.get(),
                    ImmutableSet.of(),ImmutableSet.of(), SoundEvents.VILLAGER_WORK_ARMORER));

    public static void register(IEventBus eventBus){
        POI_TYPES.register(eventBus);
        VILLAGER_PROFESSIONS.register(eventBus);
    }

}
