package net.park.tutorialmod.command;

import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.context.CommandContext;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.Commands;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;

public class SetHomeCommand {
    public SetHomeCommand(CommandDispatcher<CommandSourceStack> dispatcher){
        dispatcher.register(Commands.literal("home").then(Commands.literal("set").executes(this::execute)));

        // /home
    }

    private int execute(CommandContext<CommandSourceStack> Context) {
        ServerPlayer player = Context.getSource().getPlayer();
        BlockPos playerPos = player.blockPosition();
        String positionString="("+playerPos.getX()+","+playerPos.getY()+","+playerPos.getZ()+")";

        player.getPersistentData().putIntArray("tutorialmod.homepos",
                new int[] {playerPos.getX(),playerPos.getY(),playerPos.getZ()});
        Context.getSource().sendSuccess(()-> Component.literal("Set Home at "+ positionString),true);
        return 1;
    }
}
