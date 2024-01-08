package net.nimajnebec.ars_libratum.mixin;

import com.hollingsworth.arsnouveau.common.items.curios.JumpingRing;
import net.minecraft.world.entity.player.Player;
import net.nimajnebec.ars_libratum.Config;
import net.nimajnebec.ars_libratum.inf.IPlayerMixin;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(JumpingRing.class)
public abstract class JumpingRingMixin {

    @Inject(method = "doJump", at = @At(value = "INVOKE", target = "Lcom/hollingsworth/arsnouveau/api/mana/IManaCap;removeMana(D)D", shift = At.Shift.BEFORE), remap = false, cancellable = true)
    private static void doJump(Player player, CallbackInfo ci) {
        if (((IPlayerMixin)player).ars_libratum$getJumpingRingJumps() >= Config.jumpingRingMax) ci.cancel();
        else ((IPlayerMixin)player).ars_libratum$incrementJumpingRingJumps();
    }

}
