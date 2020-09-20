package nl.dyonb.waddles.client;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.client.rendereregistry.v1.EntityRendererRegistry;
import nl.dyonb.waddles.client.renderer.AdeliePenguinRenderer;
import nl.dyonb.waddles.registry.WaddlesEntities;

@Environment(EnvType.CLIENT)
public class WaddlesClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        EntityRendererRegistry.INSTANCE.register(WaddlesEntities.ADELIE_PENGUIN, (dispatcher, context) -> {
            return new AdeliePenguinRenderer(dispatcher);
        });
    }
}
