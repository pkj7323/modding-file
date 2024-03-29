package net.park.tutorialmod.datagen.loot;

import net.minecraft.advancements.critereon.StatePropertiesPredicate;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.ApplyBonusCount;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.predicates.LootItemBlockStatePropertyCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;
import net.minecraftforge.registries.RegistryObject;
import net.park.tutorialmod.block.ModBlocks;
import net.park.tutorialmod.block.custom.CornCropBlock;
import net.park.tutorialmod.block.custom.StrawberryCropBlock;
import net.park.tutorialmod.items.ModItems;

import java.util.Set;

public class ModBlockLootTables extends BlockLootSubProvider {
    public ModBlockLootTables() {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags());
    }

    @Override
    protected void generate() {
        this.dropSelf(ModBlocks.RUBY_BLOCK.get());
        this.dropSelf(ModBlocks.RAW_RUBY_BLOCK.get());
        this.dropSelf(ModBlocks.SOUND_BLOCK.get());
        this.dropSelf(ModBlocks.CATMINT.get());
        this.dropSelf(ModBlocks.GEM_POLISHING_STATION.get());

        this.dropSelf(ModBlocks.RUBY_STAIRS.get());
        this.dropSelf(ModBlocks.RUBY_BUTTON.get());
        this.dropSelf(ModBlocks.RUBY_PRESSURE_PLATE.get());
        this.dropSelf(ModBlocks.RUBY_TRAPDOOR.get());
        this.dropSelf(ModBlocks.RUBY_FENCE.get());
        this.dropSelf(ModBlocks.RUBY_FENCE_GATE.get());
        this.dropSelf(ModBlocks.RUBY_WALL.get());


        this.dropSelf(ModBlocks.PINE_LOG.get());
        this.dropSelf(ModBlocks.PINE_PLANKS.get());
        this.dropSelf(ModBlocks.PINE_WOOD.get());
        this.dropSelf(ModBlocks.STRIPPED_PINE_LOG.get());
        this.dropSelf(ModBlocks.STRIPPED_PINE_WOOD.get());
        this.dropSelf(ModBlocks.RUBY_LAMP.get());

        this.add(ModBlocks.PINE_LEAVES.get(), block ->
                createLeavesDrops(block,ModBlocks.RUBY_BLOCK.get(),NORMAL_LEAVES_SAPLING_CHANCES));





        this.add(ModBlocks.RUBY_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.RUBY_SLAB.get()));
        this.add(ModBlocks.RUBY_DOOR.get(),
                block -> createDoorTable(ModBlocks.RUBY_DOOR.get()));


        this.add(ModBlocks.POTTED_CATMINT.get(),createPotFlowerItemTable(ModBlocks.CATMINT.get()));


        this.add(ModBlocks.RUBY_ORE.get(),
                block->createCopperLikeOreDrops(ModBlocks.RUBY_ORE.get(),ModItems.RAW_RUBY.get()));
        this.add(ModBlocks.DEEPSLATE_RUBY_ORE.get(),
                block->createCopperLikeOreDrops(ModBlocks.DEEPSLATE_RUBY_ORE.get(),ModItems.RAW_RUBY.get()));
        this.add(ModBlocks.ENDER_RUBY_ORE.get(),
                block->createCopperLikeOreDrops(ModBlocks.ENDER_RUBY_ORE.get(),ModItems.RAW_RUBY.get()));
        this.add(ModBlocks.NETHER_RUBY_ORE.get(),
                block->createCopperLikeOreDrops(ModBlocks.NETHER_RUBY_ORE.get(),ModItems.RAW_RUBY.get()));

        LootItemCondition.Builder lootitrmcondition$builder= LootItemBlockStatePropertyCondition
                .hasBlockStateProperties(ModBlocks.STRAWBERRY_CROP.get())
                .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(StrawberryCropBlock.AGE,5));
        this.add(ModBlocks.STRAWBERRY_CROP.get(),createCropDrops(ModBlocks.STRAWBERRY_CROP.get(),ModItems.STRAWBERRY.get(),
                ModItems.STRAWBERRY_SEEDS.get(),lootitrmcondition$builder));



        LootItemCondition.Builder lootitrmcondition$builder2= LootItemBlockStatePropertyCondition
                .hasBlockStateProperties(ModBlocks.CORN_CROP.get())
                .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(CornCropBlock.AGE,7))
                .or(LootItemBlockStatePropertyCondition
                        .hasBlockStateProperties(ModBlocks.CORN_CROP.get())
                        .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(CornCropBlock.AGE,8)));
        /*LootItemCondition.Builder lootitrmcondition$builder2= LootItemBlockStatePropertyCondition
                .hasBlockStateProperties(ModBlocks.CORN_CROP.get())
                .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(CornCropBlock.AGE,8));*///밑둥을 캐도 아이템이 나오게 할경우

        this.add(ModBlocks.CORN_CROP.get(),createCropDrops(ModBlocks.CORN_CROP.get(),ModItems.CORN.get(),
                ModItems.CORN_SEEDS.get(),lootitrmcondition$builder2));






    }
    protected LootTable.Builder createCopperLikeOreDrops(Block pBlock, Item item){
        return createSilkTouchDispatchTable(pBlock,
                this.applyExplosionDecay(pBlock,
                        LootItem.lootTableItem(item)
                                .apply(SetItemCountFunction.setCount(UniformGenerator.between(2.0f,5.0f)))
                                .apply(ApplyBonusCount.addOreBonusCount(Enchantments.BLOCK_FORTUNE))));
    }
    protected Iterable<Block> getKnownBlocks(){
        return ModBlocks.BLOCKS.getEntries().stream().map(RegistryObject::get)::iterator;
    }

}
