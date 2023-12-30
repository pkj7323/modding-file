package net.park.tutorialmod.event;

import it.unimi.dsi.fastutil.ints.Int2ObjectMap;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.npc.VillagerProfession;
import net.minecraft.world.entity.npc.VillagerTrades;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.EnchantedBookItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.enchantment.EnchantmentInstance;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.item.trading.MerchantOffer;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.event.RegisterCommandsEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.event.level.BlockEvent;
import net.minecraftforge.event.village.VillagerTradesEvent;
import net.minecraftforge.event.village.WandererTradesEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.server.command.ConfigCommand;
import net.park.tutorialmod.TutorialMod;
import net.park.tutorialmod.block.ModBlocks;
import net.park.tutorialmod.command.ReturnHomeCommand;
import net.park.tutorialmod.command.SetHomeCommand;
import net.park.tutorialmod.items.ModItems;
import net.park.tutorialmod.items.custom.FieldShovelItem;
import net.park.tutorialmod.items.custom.HammerItem;
import net.park.tutorialmod.villager.ModVillagers;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Mod.EventBusSubscriber(modid = TutorialMod.MOD_ID)
public class ModEvents {
    private static final Set<BlockPos> HARVESTED_BLOCKS=new HashSet<>();




    @SubscribeEvent
    public static void onCommandsRegister(RegisterCommandsEvent event){
        new SetHomeCommand(event.getDispatcher());
        new ReturnHomeCommand(event.getDispatcher());
        ConfigCommand.register(event.getDispatcher());
    }
    @SubscribeEvent
    public static void onPlayerCloned(PlayerEvent.Clone event){
        event.getEntity().getPersistentData().putIntArray("tutorialmod.homepos",
                event.getOriginal().getPersistentData().getIntArray("tutorialmod.homepos"));
    }
    @SubscribeEvent
    public static void onHammerUasge(BlockEvent.BreakEvent event){
        Player player =event.getPlayer();
        ItemStack mainHandItem=player.getMainHandItem();

        if (mainHandItem.getItem() instanceof HammerItem hammer&&player instanceof ServerPlayer serverPlayer) {
            BlockPos initalBlockPos = event.getPos();
            if (HARVESTED_BLOCKS.contains(initalBlockPos)) {
                return;
            }

            for (BlockPos pos : HammerItem.getBlocksToBeDestroyed(1, initalBlockPos, serverPlayer)) {
                if (pos == initalBlockPos || !hammer.isCorrectToolForDrops(mainHandItem, event.getLevel().getBlockState(pos))) {
                    continue;
                }

                // Have to add them to a Set otherwise, the same code right here will get called for each block!
                HARVESTED_BLOCKS.add(pos);
                serverPlayer.gameMode.destroyBlock(pos);
                HARVESTED_BLOCKS.remove(pos);
            }
        }

    }
    @SubscribeEvent
    public static void onFieldShovelUasge(BlockEvent.BreakEvent event){
        Player player =event.getPlayer();
        ItemStack mainHandItem=player.getMainHandItem();

        if (mainHandItem.getItem() instanceof FieldShovelItem fieldShovelItem &&player instanceof ServerPlayer serverPlayer) {
            BlockPos initalBlockPos = event.getPos();
            if (HARVESTED_BLOCKS.contains(initalBlockPos)) {
                return;
            }

            for (BlockPos pos : HammerItem.getBlocksToBeDestroyed(1, initalBlockPos, serverPlayer)) {
                if (pos == initalBlockPos || !fieldShovelItem.isCorrectToolForDrops(mainHandItem, event.getLevel().getBlockState(pos))) {
                    continue;
                }

                // Have to add them to a Set otherwise, the same code right here will get called for each block!
                HARVESTED_BLOCKS.add(pos);
                serverPlayer.gameMode.destroyBlock(pos);
                HARVESTED_BLOCKS.remove(pos);
            }
        }

    }




    @SubscribeEvent
    public static void addCustomTrades(VillagerTradesEvent event){
        if (event.getType()== VillagerProfession.FARMER){
            Int2ObjectMap<List<VillagerTrades.ItemListing>> trades=event.getTrades();

            //레벨1
            trades.get(1).add((pTrader, pRandom) -> new MerchantOffer(
                    new ItemStack(Items.EMERALD, 2),
                    new ItemStack(ModItems.STRAWBERRY.get(),12),
                    10,8,0.02f));
            //레벨2
            trades.get(2).add((pTrader, pRandom) -> new MerchantOffer(
                    new ItemStack(Items.EMERALD, 5),
                    new ItemStack(ModItems.CORN.get(),6),
                    5,9,0.035f));
            //레벨3
            trades.get(3).add((pTrader, pRandom) -> new MerchantOffer(
                    new ItemStack(Items.GOLD_INGOT, 5),
                    new ItemStack(ModItems.CORN_SEEDS.get(),2),
                    5,12,0.075f));

        }
        if (event.getType()==VillagerProfession.LIBRARIAN){
            Int2ObjectMap<List<VillagerTrades.ItemListing>> trades=event.getTrades();

            ItemStack enchantedBook =EnchantedBookItem.createForEnchantment(new EnchantmentInstance(Enchantments.THORNS,5));

            //레벨1
            trades.get(1).add((pTrader, pRandom) -> new MerchantOffer(
                    new ItemStack(Items.EMERALD,2),
                    enchantedBook,
                    2,8,0.02f));

        }
        if (event.getType()== ModVillagers.SOUND_MASTER.get()){
            Int2ObjectMap<List<VillagerTrades.ItemListing>> trades=event.getTrades();

            //레벨1
            trades.get(1).add((pTrader, pRandom) -> new MerchantOffer(
                    new ItemStack(Items.EMERALD,16),
                    new ItemStack(ModBlocks.SOUND_BLOCK.get()),
                    2,8,0.02f));

            //레벨2
            trades.get(2).add((pTrader, pRandom) -> new MerchantOffer(
                    new ItemStack(Items.EMERALD,6),
                    new ItemStack(ModBlocks.SOUND_BLOCK.get()),
                    16,8,0.02f));
            trades.get(2).add((pTrader, pRandom) -> new MerchantOffer(
                    new ItemStack(Items.EMERALD,6),
                    new ItemStack(ModBlocks.RUBY_BLOCK.get()),
                    16,8,0.02f));

            //레벨3
            trades.get(3).add((pTrader, pRandom) -> new MerchantOffer(
                    new ItemStack(Items.EMERALD,4),
                    new ItemStack(ModBlocks.SOUND_BLOCK.get()),
                    20,8,0.02f));
            //레벨4
            trades.get(4).add((pTrader, pRandom) -> new MerchantOffer(
                    new ItemStack(Items.EMERALD,1),
                    new ItemStack(Blocks.NETHERITE_BLOCK),
                    2,8,0.02f));


        }
    }

    @SubscribeEvent
    public static void addCustomWanderingTrades(WandererTradesEvent event){
        List<VillagerTrades.ItemListing> genericTrades = event.getGenericTrades();
        List<VillagerTrades.ItemListing> rareTrades = event.getRareTrades();

        genericTrades.add((pTrader, pRandom) -> new MerchantOffer(
                new ItemStack(Items.EMERALD,12),
                new ItemStack(ModItems.RUBY_BOOTS.get(),1),
                10,2,0.2f));

        rareTrades.add((pTrader, pRandom) -> new MerchantOffer(
                new ItemStack(Items.EMERALD,12),
                new ItemStack(ModItems.METAL_DETECTOR.get(),1),
                10,2,0.2f));

    }


}
