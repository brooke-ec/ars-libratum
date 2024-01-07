package net.nimajnebec.ars_libratum;

import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.context.UseOnContext;

public class Util {
    public static void damageItem(UseOnContext context, int amount) {
        Player player = context.getPlayer();
        if (player instanceof ServerPlayer) {
            context.getItemInHand().hurtAndBreak(amount, player, (p) -> {
                player.broadcastBreakEvent(context.getHand());
            });
        }
    }
}
