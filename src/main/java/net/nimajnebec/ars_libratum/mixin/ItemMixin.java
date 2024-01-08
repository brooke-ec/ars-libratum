package net.nimajnebec.ars_libratum.mixin;

import com.hollingsworth.arsnouveau.common.items.StableWarpScroll;
import com.hollingsworth.arsnouveau.common.items.WarpScroll;
import net.minecraft.world.item.Item;
import net.nimajnebec.ars_libratum.Config;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(Item.class)
public abstract class ItemMixin {

    @Inject(method = "getMaxDamage", at = @At(value = "HEAD"), cancellable = true)
    private void getMaxDamage(CallbackInfoReturnable<Integer> ci) {
        if (((Object) this) instanceof StableWarpScroll) {
            ci.setReturnValue(Config.stableWarpScrollUses > 1 ? Config.stableWarpScrollUses : 0);
            ci.cancel();
        }
    }

    @Inject(method = "canBeDepleted", at = @At(value = "HEAD"), cancellable = true)
    private void canBeDepleted(CallbackInfoReturnable<Boolean> ci) {
        ci.setReturnValue(((Item)(Object)this).getMaxDamage() > 0);
        ci.cancel();
    }

    @Inject(method = "getMaxStackSize", at = @At(value = "HEAD"), cancellable = true)
    private void getMaxStackSize(CallbackInfoReturnable<Integer> ci) {
        if (((Object) this) instanceof StableWarpScroll) {
            ci.setReturnValue(Config.stableWarpScrollUses <= 1 ? Config.stableWarpScrollStack : 1);
            ci.cancel();
        }

        if (((Object) this) instanceof WarpScroll) {
            ci.setReturnValue(Config.warpScrollStack);
            ci.cancel();
        }
    }
}
