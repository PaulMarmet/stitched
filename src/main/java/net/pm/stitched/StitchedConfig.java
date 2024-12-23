package net.pm.stitched;

import eu.midnightdust.lib.config.MidnightConfig;

public class StitchedConfig extends MidnightConfig {
    public enum SelectionType {
        ALL, SOME, VANILLA
    }

    //Item Changes Configs
    @Comment(category = "general") public static Comment ItemConfig1;
    @Entry(category = "general") public static SelectionType explosionProofItems = SelectionType.ALL;
    @Entry(category = "general") public static boolean explosionProofBlastProt = true;
    @Entry(category = "general") public static SelectionType fireProofItems = SelectionType.SOME;
    @Entry(category = "general") public static boolean fireProofFireProt = true;

    //Other Configs
    @Comment(category = "general") public static Comment OtherConfig1;
    @Entry(category = "general") public static boolean untramplableWetFarmland = true;
    @Entry(category = "general") public static boolean extendWaterRegion = true;
    @Entry(category = "general") public static boolean echoShardRings = false;
    @Entry(category = "general") public static boolean glowingTorchflower = true;
    @Entry(category = "general") public static boolean blocksReleaseSparks = true;
    @Entry(category = "general") public static boolean iceAndSnowDontMelt = true;
    @Entry(category = "general") public static boolean moreEndermanSafeItems = true;
    @Entry(category = "general") public static boolean sneakSweetBerries = true;
    @Entry(category = "general") public static boolean bundleChanges = true;
    @Entry(category = "general", min = 0, max = 64) public static int bundleMaxSpaceCost = 8;
    @Entry(category = "general") public static boolean copperGrateFallthrough = true;
    @Entry(category = "general", min = 0.0, max = 256) public static double copperGrateFallthroughSize = 0.7;
    @Entry(category = "general") public static boolean drowningDrops = true;
    @Entry(category = "general") public static boolean regrowCaveVines = true;
    @Entry(category = "general") public static boolean glowBerriesGiveGlowing = true;

}
