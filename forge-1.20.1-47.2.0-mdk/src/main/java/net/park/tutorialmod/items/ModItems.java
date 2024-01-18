package net.park.tutorialmod.items;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.*;
import net.minecraftforge.common.ForgeSpawnEggItem;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.park.tutorialmod.TutorialMod;
import net.park.tutorialmod.block.ModBlocks;
import net.park.tutorialmod.entity.ModEntities;
import net.park.tutorialmod.items.custom.*;
import net.park.tutorialmod.sound.ModSounds;

public class ModItems {
    //모드 아이템
    public static final DeferredRegister<Item> ITEMS=
            DeferredRegister.create(ForgeRegistries.ITEMS, TutorialMod.MOD_ID);


    //재료
    public static final RegistryObject<Item> RUBY=ITEMS.register("ruby",
            ()->new Item(new Item.Properties()));
    public static final RegistryObject<Item> RAW_RUBY=ITEMS.register("raw_ruby",
            ()-> new Item(new Item.Properties()));
    public static final RegistryObject<Item> IRON_STICK=ITEMS.register("iron_stick",
            ()-> new Item(new Item.Properties()));
    public static final RegistryObject<Item> PINE_CONE=ITEMS.register("pine_cone",
            ()-> new FuelItem(new Item.Properties(),400));//연료






    //도구
    public static final RegistryObject<Item> METAL_DETECTOR=ITEMS.register("metal_detector",
            ()-> new MetalDetectoritem(new Item.Properties().durability(100)));
    public static final RegistryObject<Item> DEUS_EX_MACHINA=ITEMS.register("deus_ex_machina",
            ()-> new SwordItem(ModToolTiers.GOD,1000,3.5f,
                    new Item.Properties().fireResistant().setNoRepair()));
    public static final RegistryObject<Item> RUBY_STAFF=ITEMS.register("ruby_staff",
            ()-> new Item(new Item.Properties().stacksTo(1)));
    public static final RegistryObject<Item> RUBY_SWORD=ITEMS.register("ruby_sword",
            ()-> new SlowingSwordItem(ModToolTiers.RUBY,8,2,
                    new SwordItem.Properties()));
    public static final RegistryObject<Item> RUBY_PICKAXE=ITEMS.register("ruby_pickaxe",
            ()-> new PickaxeItem(ModToolTiers.RUBY,2,2,
                    new Item.Properties()));
    public static final RegistryObject<Item> RUBY_AXE=ITEMS.register("ruby_axe",
            ()-> new AxeItem(ModToolTiers.RUBY,7,0.5f,
                    new Item.Properties()));
    public static final RegistryObject<Item> RUBY_SHOVEL=ITEMS.register("ruby_shovel",
            ()-> new ShovelItem(ModToolTiers.RUBY,1,0,
                    new Item.Properties()));
    public static final RegistryObject<Item> RUBY_HOE=ITEMS.register("ruby_hoe",
            ()-> new HoeItem(ModToolTiers.RUBY,0,0,
                    new Item.Properties()));
    public static final RegistryObject<Item> RUBY_HAMMER=ITEMS.register("ruby_hammer",
            ()-> new HammerItem(ModToolTiers.RUBY,3,-3,
                    new Item.Properties()));
    public static final RegistryObject<Item> RUBY_FIELD_SHOVEL=ITEMS.register("ruby_field_shovel",
            ()-> new FieldShovelItem(ModToolTiers.RUBY,-2,-3,
                    new Item.Properties()));
    public static final RegistryObject<Item> RUBY_PAXEL=ITEMS.register("ruby_paxel",
            ()-> new PaxelItem(ModToolTiers.RUBY,2,-3,
                    new Item.Properties()));
    public static final RegistryObject<Item> RADIATION_STAFF=ITEMS.register("radiation_staff",
            ()-> new Item(new Item.Properties().durability(1024)));
    public static final RegistryObject<Item> RUBY_BOW=ITEMS.register("ruby_bow",
            ()-> new BowItem(new Item.Properties().durability(500)));
    public static final RegistryObject<Item> RUBY_SHIELD=ITEMS.register("ruby_shield",
            ()-> new ShieldItem(new Item.Properties().durability(500)));




    //갑옷
    public static final RegistryObject<Item> RUBY_HELMET=ITEMS.register("ruby_helmet",
            ()-> new ModArmoritem(ModArmorMaterials.RUBY, ArmorItem.Type.HELMET,new Item.Properties()));
    public static final RegistryObject<Item> RUBY_CHESTPLATE=ITEMS.register("ruby_chestplate",
            ()-> new ArmorItem(ModArmorMaterials.RUBY, ArmorItem.Type.CHESTPLATE,new Item.Properties()));
    public static final RegistryObject<Item> RUBY_LEGGINGS=ITEMS.register("ruby_leggings",
            ()-> new ArmorItem(ModArmorMaterials.RUBY, ArmorItem.Type.LEGGINGS,new Item.Properties()));
    public static final RegistryObject<Item> RUBY_BOOTS=ITEMS.register("ruby_boots",
            ()-> new ArmorItem(ModArmorMaterials.RUBY, ArmorItem.Type.BOOTS,new Item.Properties()));
    public static final RegistryObject<Item> RUBY_HORSE_ARMOR=ITEMS.register("ruby_horse_armor",
            ()-> new HorseArmorItem(12,new ResourceLocation(TutorialMod.MOD_ID,"textures/entity/horse/armor/horse_armor_ruby.png"),new Item.Properties()));





    //음식
    public static final RegistryObject<Item> STRAWBERRY_SEEDS=ITEMS.register("strawberry_seeds",
            ()-> new ItemNameBlockItem(ModBlocks.STRAWBERRY_CROP.get(),new Item.Properties()));
    public static final RegistryObject<Item> STRAWBERRY=ITEMS.register("strawberry",
            ()-> new Item(new Item.Properties().food(ModFoods.STRAWBERRY)));
    public static final RegistryObject<Item> CORN_SEEDS=ITEMS.register("corn_seeds",
            ()-> new ItemNameBlockItem(ModBlocks.CORN_CROP.get(),new Item.Properties()));
    public static final RegistryObject<Item> CORN=ITEMS.register("corn",
            ()-> new Item(new Item.Properties()));





    //음반
    public static final RegistryObject<Item> BAR_BRAWL_MUISIC_DISC=ITEMS.register("bar_brawl_music_disc",
            ()-> new RecordItem(6, ModSounds.BAR_BRAWL.get(),new Item.Properties().stacksTo(1),2440));//시간은 초*20
    public static final RegistryObject<Item> SAKURAMITSUTSUKI_MUSIC_DISC=ITEMS.register("sakuramitsutsuki_music_disc",
            ()-> new RecordItem(6, ModSounds.SAKURAMITSUTSUKI.get(),new Item.Properties().stacksTo(1),4320));




    //스폰알
    public static final RegistryObject<Item>RHINO_SPAWN_EGG=ITEMS.register("rhino_spawn_egg",
        ()->new ForgeSpawnEggItem(ModEntities.RHINO,0x7e9680,0xc5d1c5,
                new Item.Properties()));

    public static final RegistryObject<Item> DATA_TABLET=ITEMS.register("data_tablet",
            ()-> new DataTabletItem(new Item.Properties().stacksTo(1)));



    public static void register(IEventBus eventBus){
        ITEMS.register(eventBus);
    }


}

