package net.nimajnebec.ars_libratum.mixin;

import com.hollingsworth.arsnouveau.common.items.StableWarpScroll;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.item.context.UseOnContext;
import net.nimajnebec.ars_libratum.Config;
import net.nimajnebec.ars_libratum.Util;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(StableWarpScroll.class)
public abstract class StableWarpScrollMixin {

    @Inject(method = "useOn", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/level/Level;playSound(Lnet/minecraft/world/entity/player/Player;Lnet/minecraft/core/BlockPos;Lnet/minecraft/sounds/SoundEvent;Lnet/minecraft/sounds/SoundSource;FF)V", shift = At.Shift.AFTER))
    private void consume(UseOnContext context, CallbackInfoReturnable<InteractionResult> ci) {
        if (Config.warpScrollUses == 1) context.getItemInHand().shrink(1);
        else if (Config.warpScrollUses > 1) Util.damageItem(context, 1);
    }
}
