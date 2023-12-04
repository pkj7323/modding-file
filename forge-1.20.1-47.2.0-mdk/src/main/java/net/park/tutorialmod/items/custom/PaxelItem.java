package net.park.tutorialmod.items.custom;

import net.minecraft.tags.TagKey;
import net.minecraft.world.item.DiggerItem;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.Vanishable;
import net.minecraft.world.level.block.Block;
import net.park.tutorialmod.block.ModBlocks;
import net.park.tutorialmod.util.ModTags;

public class PaxelItem extends DiggerItem implements Vanishable {


    public PaxelItem( Tier pTier, float pAttackDamageModifier, float pAttackSpeedModifier, Properties pProperties) {
        super(pAttackDamageModifier, pAttackSpeedModifier, pTier, ModTags.Blocks.PAXEL_MINEABLE,pProperties);
    }





}
