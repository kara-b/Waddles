package nl.dyonb.waddles.registry;

import me.sargunvohra.mcmods.autoconfig1u.AutoConfig;
import me.sargunvohra.mcmods.autoconfig1u.ConfigData;
import me.sargunvohra.mcmods.autoconfig1u.annotation.Config;
import me.sargunvohra.mcmods.autoconfig1u.annotation.ConfigEntry;
import me.sargunvohra.mcmods.autoconfig1u.serializer.JanksonConfigSerializer;
import me.sargunvohra.mcmods.autoconfig1u.shadowed.blue.endless.jankson.Comment;
import nl.dyonb.waddles.Waddles;

@Config(name = Waddles.MOD_ID)
public class WaddlesConfig implements ConfigData {

    @ConfigEntry.Gui.Excluded
    public static WaddlesConfig CONFIG = new WaddlesConfig();

    @Comment("Enable that penguins drop fish (0 - 2 Raw Cod)")
    public static boolean drop_fish = false;

    @Comment("Penguins should drop experience?")
    public static boolean drop_exp = true;

    @Comment("Spawn weight of adelie penguins")
    public static int adelie_spawn_weight = 4;
    @Comment("Minimal amount of adelie penguins that spawn")
    public static int adelie_min_group_size = 1;
    @Comment("Maximum amount of adelie penguins that spawn")
    public static int adelie_max_group_size = 4;

    public static void initialize() {
        AutoConfig.register(WaddlesConfig.class, JanksonConfigSerializer::new);
        CONFIG = AutoConfig.getConfigHolder(WaddlesConfig.class).getConfig();
    }

}
