package nl.dyonb.waddles;

import net.fabricmc.api.ModInitializer;
import net.minecraft.util.Identifier;
import nl.dyonb.waddles.registry.WaddlesConfig;
import nl.dyonb.waddles.registry.WaddlesEntities;
import nl.dyonb.waddles.registry.WaddlesItems;
import nl.dyonb.waddles.registry.WaddlesSounds;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Waddles implements ModInitializer {

    public static final String LOG_ID = "Waddles";
    public static final String MOD_ID = "waddles";

    public static final Logger LOGGER = LogManager.getLogger(LOG_ID);

    @Override
    public void onInitialize() {
        LOGGER.log(Level.INFO, "Hello Waddles world!");

        WaddlesConfig.initialize();
        WaddlesSounds.initialize();
        WaddlesEntities.initialize();
        WaddlesItems.initialize();
    }

    public static Identifier identifier(String name) {
        return new Identifier(MOD_ID, name);
    }
}
