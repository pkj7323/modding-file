package net.park.tutorialmod.items;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.common.ForgeTier;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.park.tutorialmod.TutorialMod;
import net.park.tutorialmod.items.custom.MeralDetectoritem;

public class ModeItems {
    public static final DeferredRegister<Item> ITEMS=
            DeferredRegister.create(ForgeRegistries.ITEMS, TutorialMod.MOD_ID);

    public static final RegistryObject<Item> RUBY=ITEMS.register("ruby",
            ()->new Item(new Item.Properties()));
    public static final RegistryObject<Item> RAW_RUBY=ITEMS.register("raw_ruby",
            ()-> new Item(new Item.Properties()));
    public static final RegistryObject<Item> IRON_STICK=ITEMS.register("iron_stick",
            ()-> new Item(new Item.Properties()));

    public static final RegistryObject<Item> METAL_DETECTOR=ITEMS.register("metal_detector",
            ()-> new MeralDetectoritem(new Item.Properties().durability(100)));

    public static final RegistryObject<SwordItem> DEUS_EX_MACHINA=ITEMS.register("deus_ex_machina",
            ()-> new SwordItem(Tiers.five,1000,3.5f,
                    new Item.Properties()));
    public static final RegistryObject<SwordItem> RUBY_SWORD=ITEMS.register("ruby_sword",
            ()-> new SwordItem(Tiers.five,5,0.5f,
                    new Item.Properties()));

    public static void register(IEventBus eventBus){
        ITEMS.register(eventBus);
    }
    public static class Tiers{
        public static final Tier five=new ForgeTier(5,3000,3.5f,
                1,350,null,()-> Ingredient.EMPTY);
    }

}

