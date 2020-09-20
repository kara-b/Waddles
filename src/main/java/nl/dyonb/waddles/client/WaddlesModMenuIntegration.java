package nl.dyonb.waddles.client;

import io.github.prospector.modmenu.api.ConfigScreenFactory;
import io.github.prospector.modmenu.api.ModMenuApi;
import me.sargunvohra.mcmods.autoconfig1u.AutoConfig;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import nl.dyonb.waddles.Waddles;
import nl.dyonb.waddles.registry.WaddlesConfig;

@Environment(EnvType.CLIENT)
public class WaddlesModMenuIntegration implements ModMenuApi {

    @Override
    public String getModId() {
        return Waddles.MOD_ID; // Return your modid here
    }

    @Override
    public ConfigScreenFactory<?> getModConfigScreenFactory() {
        return parent -> AutoConfig.getConfigScreen(WaddlesConfig.class, parent).get();
    }

}
