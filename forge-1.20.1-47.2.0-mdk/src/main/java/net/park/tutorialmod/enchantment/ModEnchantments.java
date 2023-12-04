package net.park.tutorialmod.enchantment;

import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentCategory;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.park.tutorialmod.TutorialMod;

public class ModEnchantments {
    public static final DeferredRegister<Enchantment> ENCAHANTMENTS=
            DeferredRegister.create(ForgeRegistries.ENCHANTMENTS, TutorialMod.MOD_ID);
    public static final RegistryObject<Enchantment> LIGHTNING_STRIKER =
            ENCAHANTMENTS.register("lightning_striker",
                    ()->new LightningStrikerEnchantment(Enchantment.Rarity.COMMON, EnchantmentCategory.WEAPON,
                            EquipmentSlot.MAINHAND));

    public static void register(IEventBus eventBus){
        ENCAHANTMENTS.register(eventBus);
    }

}
