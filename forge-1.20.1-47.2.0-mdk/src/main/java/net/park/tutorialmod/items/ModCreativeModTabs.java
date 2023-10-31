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
            ()->CreativeModeTab.builder().icon(()->new ItemStack(ModItems.RUBY.get()))
                    .title(Component.translatable("creativetab.tutorial_tab"))
                    .displayItems((pParameters, pOutput) -> {
                        pOutput.accept(ModItems.RUBY.get());
                        pOutput.accept(ModItems.RAW_RUBY.get());
                        pOutput.accept(ModItems.IRON_STICK.get());

                        pOutput.accept(ModItems.DEUS_EX_MACHINA.get());
                        pOutput.accept(ModItems.METAL_DETECTOR.get());
                        pOutput.accept(ModItems.RUBY_SWORD.get());
                        pOutput.accept(ModItems.RUBY_PICKAXE.get());
                        pOutput.accept(ModItems.RUBY_AXE.get());
                        pOutput.accept(ModItems.RUBY_SHOVEL.get());
                        pOutput.accept(ModItems.RUBY_HOE.get());

                        pOutput.accept(ModItems.RUBY_HELMET.get());
                        pOutput.accept(ModItems.RUBY_CHESTPLATE.get());
                        pOutput.accept(ModItems.RUBY_LEGGINGS.get());
                        pOutput.accept(ModItems.RUBY_BOOTS.get());




                        pOutput.accept(ModBlocks.RUBY_BLOCK.get());
                        pOutput.accept(ModBlocks.RUBY_ORE.get());
                        pOutput.accept(ModBlocks.DEEPSLATE_RUBY_ORE.get());
                        pOutput.accept(ModBlocks.ENDER_RUBY_ORE.get());
                        pOutput.accept(ModBlocks.NETHER_RUBY_ORE.get());
                        pOutput.accept(ModBlocks.RAW_RUBY_BLOCK.get());

                        pOutput.accept(ModBlocks.SOUND_BLOCK.get());

                        pOutput.accept(ModItems.STRAWBERRY.get());
                        pOutput.accept(ModItems.CORN.get());


                        pOutput.accept(ModItems.STRAWBERRY_SEEDS.get());
                        pOutput.accept(ModItems.CORN_SEEDS.get());

                        pOutput.accept(ModItems.PINE_CONE.get());

                        pOutput.accept(ModBlocks.CATMINT.get());

                        pOutput.accept(ModItems.BAR_BRAWL_MUISIC_DISC.get());
                        pOutput.accept(ModItems.SAKURAMITSUTSUKI_MUSIC_DISC.get());


                        pOutput.accept(ModItems.RHINO_SPAWN_EGG.get());
                    })
                    .build());


    public static void register(IEventBus eventBus){
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
