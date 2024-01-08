package net.nimajnebec.ars_libratum.mixin;

import net.minecraft.world.entity.player.Player;
import net.nimajnebec.ars_libratum.inf.IPlayerMixin;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(Player.class)
public abstract class PlayerMixin implements IPlayerMixin {

    @Unique
    private int ars_libratum$JumpingRingJumps;

    @Override
    public int ars_libratum$getJumpingRingJumps() {
        return ars_libratum$JumpingRingJumps;
    }

    @Override
    public void ars_libratum$incrementJumpingRingJumps() {
        ars_libratum$JumpingRingJumps++;
    }

    @Inject(method = "aiStep", at = @At(value = "TAIL"))
    private void resetJumps(CallbackInfo ci) {
        if (((Player)(Object)this).onGround()) ars_libratum$JumpingRingJumps = 0;
    }

}
