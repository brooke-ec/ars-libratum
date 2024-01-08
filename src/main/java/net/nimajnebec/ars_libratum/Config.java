package net.nimajnebec.ars_libratum;

import net.minecraft.world.item.Item;
import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.config.ModConfigEvent;

@Mod.EventBusSubscriber(modid = ArsLibratum.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class Config
{
    private static final ForgeConfigSpec.Builder BUILDER = new ForgeConfigSpec.Builder();
    private static final ForgeConfigSpec.IntValue STABLE_WARP_SCROLL_USES = BUILDER
            .comment("The number times that a Stabilized Warp Scroll can be used. Set to 0 for infinite uses.")
            .defineInRange("stable_warp_scroll_uses", 1, 0, Integer.MAX_VALUE);

    private static final ForgeConfigSpec.IntValue STABLE_WARP_SCROLL_STACK = BUILDER
            .comment("The max size Stabilized Warp Scrolls can be stacked to. Only applies if stable_warp_scroll_uses <= 1")
            .defineInRange("stable_warp_scroll_stack", 1, 0, Item.MAX_STACK_SIZE);

    private static final ForgeConfigSpec.IntValue WARP_SCROLL_STACK = BUILDER
            .comment("The max size Warp Scrolls can be stacked to.")
            .defineInRange("warp_scroll_stack", 1, 0, Item.MAX_STACK_SIZE);

    private static final ForgeConfigSpec.IntValue JUMPING_RING_MAX = BUILDER
        .comment("The max number of jumps you can do before you must touch the ground with the Ring of Jumping. Set to 0 for infinite jumps.")
        .defineInRange("jumping_ring_max", 1, 0, Integer.MAX_VALUE);
    static final ForgeConfigSpec SPEC = BUILDER.build();

    public static int stableWarpScrollUses;
    public static int stableWarpScrollStack;
    public static int warpScrollStack;
    public static int jumpingRingMax;

    @SubscribeEvent
    static void onLoad(final ModConfigEvent event)
    {
        stableWarpScrollUses = STABLE_WARP_SCROLL_USES.get();
        stableWarpScrollStack = STABLE_WARP_SCROLL_STACK.get();
        warpScrollStack = WARP_SCROLL_STACK.get();
        jumpingRingMax = JUMPING_RING_MAX.get();
    }
}
