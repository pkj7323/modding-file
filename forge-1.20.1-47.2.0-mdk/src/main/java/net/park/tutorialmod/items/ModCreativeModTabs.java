package net.park.tutorialmod.items;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;
import net.park.tutorialmod.TutorialMod;
import net.park.tutorialmod.block.ModBlocks;

import java.rmi.registry.Registry;

public class ModCreativeModTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS=
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, TutorialMod.MOD_ID);

    public static final RegistryObject<CreativeModeTab> TUTORIAL_TAB=CREATIVE_MODE_TABS.register("tutorial_tabs",
            ()->CreativeModeTab.builder().icon(()->new ItemStack(ModeItems.RUBY.get()))
                    .title(Component.translatable("creativetab.tutorial_tab"))
                    .displayItems((pParameters, pOutput) -> {
                        pOutput.accept(ModeItems.RUBY.get());
                        pOutput.accept(ModeItems.RAW_RUBY.get());
                        pOutput.accept(ModeItems.IRON_STICK.get());

                        pOutput.accept(ModeItems.DEUS_EX_MACHINA.get());
                        pOutput.accept(ModeItems.METAL_DETECTOR.get());
                        pOutput.accept(ModeItems.RUBY_SWORD.get());

                        pOutput.accept(ModBlocks.RUBY_BLOCK.get());
                        pOutput.accept(ModBlocks.RUBY_ORE.get());
                        pOutput.accept(ModBlocks.DEEPSLATE_RUBY_ORE.get());
                        pOutput.accept(ModBlocks.ENDER_RUBY_ORE.get());
                        pOutput.accept(ModBlocks.NETHER_RUBY_ORE.get());
                        pOutput.accept(ModBlocks.RAW_RUBY_BLOCK.get());
                    })
                    .build());


    public static void register(IEventBus eventBus){
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
