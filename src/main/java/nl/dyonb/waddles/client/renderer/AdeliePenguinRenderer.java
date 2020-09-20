package nl.dyonb.waddles.client.renderer;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.render.entity.EntityRenderDispatcher;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.util.Identifier;
import nl.dyonb.waddles.Waddles;
import nl.dyonb.waddles.client.model.AdeliePenguinModel;
import nl.dyonb.waddles.common.entity.AdeliePenguinEntity;

@Environment(EnvType.CLIENT)
public class AdeliePenguinRenderer extends MobEntityRenderer<AdeliePenguinEntity, AdeliePenguinModel<AdeliePenguinEntity>> {

    public AdeliePenguinRenderer(EntityRenderDispatcher entityRenderDispatcher) {
        super(entityRenderDispatcher, new AdeliePenguinModel<>(), 0.5F);
    }

    @Override
    public Identifier getTexture(AdeliePenguinEntity entity) {
        String name = entity.getName().getString().toLowerCase().trim();
        if (name.equals("joshie") || name.equals("joshiejack")) {
            return Waddles.identifier("textures/entity/penguin/" + "joshie" + ".png");
        } else if (name.equals("darkosto")) {
            return Waddles.identifier("textures/entity/penguin/" + "darkosto" + ".png");
        }

        return entity.isBaby() ? Waddles.identifier("textures/entity/penguin/" + "adelie_child" + ".png") :
                Waddles.identifier("textures/entity/penguin/" + "adelie" + ".png");
    }

}
