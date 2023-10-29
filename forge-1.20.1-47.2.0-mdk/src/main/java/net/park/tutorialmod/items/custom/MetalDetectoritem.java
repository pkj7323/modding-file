package net.park.tutorialmod.items.custom;

import net.minecraft.client.resources.language.I18n;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.park.tutorialmod.items.util.ModTags;
import net.park.tutorialmod.sound.ModSounds;
import org.jetbrains.annotations.Nullable;

import java.util.List;


public class MetalDetectoritem extends Item{
    public MetalDetectoritem(Properties pProperties){
       super(pProperties);
    }
    @Override
    public InteractionResult useOn(UseOnContext pContext){
        if(!pContext.getLevel().isClientSide()){
            BlockPos positionClicked = pContext.getClickedPos();
            Player player = pContext.getPlayer();
            boolean foundBlock=false;

            for(int i=0;i<=positionClicked.getY()+64;i++){
                BlockState state=pContext.getLevel().getBlockState(positionClicked.below(i));
                if(isValidBlock(state)){
                    outputValuableCoordinates(positionClicked.below(i),player,state.getBlock());
                    foundBlock =true;

                    pContext.getLevel().playSeededSound(null,positionClicked.getX(),positionClicked.getY(),positionClicked.getZ(),
                            ModSounds.METAL_DETECTOR_FOUND_ORE.get(), SoundSource.BLOCKS,1f,1f,0);
                    break;
                }
            }
            if(!foundBlock){
                player.sendSystemMessage(Component.literal("No Values Found!"));
            }
        }
        pContext.getItemInHand().hurtAndBreak(1,pContext.getPlayer(),
                player -> player.broadcastBreakEvent(player.getUsedItemHand()));
        return InteractionResult.SUCCESS;
    }

    @Override
    public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> pTooltipComponents, TooltipFlag pIsAdvanced) {
        pTooltipComponents.add(Component.translatable("tootips.tutorialmod.metal_detector.tooltip"));
        //이방법은 각각의 언어마다 툴팁을 적을 수 있으므로 가장 추천하는 방법이나 귀찮음
        super.appendHoverText(pStack, pLevel, pTooltipComponents, pIsAdvanced);
    }

    private void outputValuableCoordinates(BlockPos blockPos, Player player, Block block){
        player.sendSystemMessage(Component.literal("Found"+ I18n.get(block.getDescriptionId())
                +" at "+"("+blockPos.getX()+","+blockPos.getY()+","+blockPos.getZ()+")"));
    }

    private boolean isValidBlock(BlockState state){

        return state.is(ModTags.Blocks.METAL_DETECTOR_VALUES);
    }
}
