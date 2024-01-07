package net.nimajnebec.ars_libratum;

import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.config.ModConfigEvent;

@Mod.EventBusSubscriber(modid = ArsLibratum.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class Config
{
    private static final ForgeConfigSpec.Builder BUILDER = new ForgeConfigSpec.Builder();
    public static final ForgeConfigSpec.IntValue WARP_SCROLL_USES = BUILDER
            .comment("The number times that a stabilized Warp Scroll can be used. Set to 0 for infinite uses.")
            .defineInRange("stable_warp_scroll_uses", 1, 0, Integer.MAX_VALUE);
    static final ForgeConfigSpec SPEC = BUILDER.build();

    public static int warpScrollUses;

    @SubscribeEvent
    static void onLoad(final ModConfigEvent event)
    {
        warpScrollUses = WARP_SCROLL_USES.get();
    }
}
