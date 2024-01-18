package net.park.tutorialmod;

import com.mojang.logging.LogUtils;
import net.minecraft.client.gui.screens.MenuScreens;
import net.minecraft.client.renderer.entity.EntityRenderers;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.FlowerPotBlock;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.park.tutorialmod.block.ModBlocks;
import net.park.tutorialmod.block.entity.ModBlockEntities;
import net.park.tutorialmod.enchantment.ModEnchantments;
import net.park.tutorialmod.entity.ModEntities;
import net.park.tutorialmod.entity.client.RhinoRenderer;
import net.park.tutorialmod.items.ModCreativeModTabs;
import net.park.tutorialmod.items.ModItemProperties;
import net.park.tutorialmod.items.ModItems;
import net.park.tutorialmod.loot.ModLootModifiers;
import net.park.tutorialmod.recipe.ModRecipes;
import net.park.tutorialmod.screen.GemPolishingStationScreen;
import net.park.tutorialmod.screen.ModMenuTypes;
import net.park.tutorialmod.sound.ModSounds;
import net.park.tutorialmod.villager.ModVillagers;
import org.slf4j.Logger;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(TutorialMod.MOD_ID)
public class TutorialMod
{
    // Define mod id in a common place for everything to reference
    public static final String MOD_ID = "tutorialmod";
    // Directly reference a slf4j logger
    public static final Logger LOGGER = LogUtils.getLogger();
    // Create a Deferred Register to hold Blocks which will all be registered under the "examplemod" namespace

    public TutorialMod() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        ModRecipes.register(modEventBus);

        ModCreativeModTabs.register(modEventBus);

        ModItems.register(modEventBus);
        ModBlocks.register(modEventBus);

        ModSounds.register(modEventBus);
        ModEntities.register(modEventBus);

        ModBlockEntities.register(modEventBus);
        ModMenuTypes.register(modEventBus);


        ModVillagers.register(modEventBus);
        ModLootModifiers.register(modEventBus);

        ModEnchantments.register(modEventBus);


        modEventBus.addListener(this::commonSetup);

        MinecraftForge.EVENT_BUS.register(this);
        modEventBus.addListener(this::addCreative);

    }

    private void commonSetup(final FMLCommonSetupEvent event) {
        event.enqueueWork(()-> ((FlowerPotBlock) Blocks.FLOWER_POT).addPlant(ModBlocks.CATMINT.getId(),ModBlocks.POTTED_CATMINT));
    }

    // Add the example block item to the building blocks tab
    private void addCreative(BuildCreativeModeTabContentsEvent event) {
        if(event.getTabKey()==CreativeModeTabs.INGREDIENTS){
            event.accept(ModItems.RUBY);
            event.accept(ModItems.RAW_RUBY);
            event.accept(ModItems.IRON_STICK);
        }
    }

    // You can use SubscribeEvent and let the Event Bus discover methods to call
    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event) {

    }

    // You can use EventBusSubscriber to automatically register all static methods in the class annotated with @SubscribeEvent
    @Mod.EventBusSubscriber(modid = MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents
    {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event)
        {
            EntityRenderers.register(ModEntities.RHINO.get(), RhinoRenderer::new);
            event.enqueueWork(()-> ModItemProperties.addCustomItemProperties());
            MenuScreens.register(ModMenuTypes.GEM_POLISHING_MENU.get(), GemPolishingStationScreen::new);
        }
    }
}
