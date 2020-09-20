package nl.dyonb.waddles.mixin;

import net.minecraft.entity.SpawnGroup;
import net.minecraft.world.biome.SpawnSettings;
import net.minecraft.world.gen.feature.DefaultBiomeFeatures;
import nl.dyonb.waddles.registry.WaddlesConfig;
import nl.dyonb.waddles.registry.WaddlesEntities;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(DefaultBiomeFeatures.class)
public class DefaultBiomeFeaturesMixin {

    @Inject(at = @At("HEAD"), method = "addSnowyMobs")
    private static void addSnowyMobs(SpawnSettings.Builder builder, CallbackInfo ci) {
        builder.spawn(SpawnGroup.CREATURE, new SpawnSettings.SpawnEntry(WaddlesEntities.ADELIE_PENGUIN,
                WaddlesConfig.CONFIG.adelie_spawn_weight, WaddlesConfig.CONFIG.adelie_min_group_size, WaddlesConfig.CONFIG.adelie_max_group_size));
    }

}
