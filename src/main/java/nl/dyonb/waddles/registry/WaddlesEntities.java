package nl.dyonb.waddles.registry;

import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.util.registry.Registry;
import nl.dyonb.waddles.Waddles;
import nl.dyonb.waddles.common.entity.AdeliePenguinEntity;

public class WaddlesEntities {

    public static final EntityType<AdeliePenguinEntity> ADELIE_PENGUIN = Registry.register(
            Registry.ENTITY_TYPE,
            Waddles.identifier("adelie_penguin"),
            FabricEntityTypeBuilder.<AdeliePenguinEntity>create(SpawnGroup.CREATURE, AdeliePenguinEntity::new)
                    .dimensions(EntityDimensions.fixed(0.4F, 0.95F)).trackRangeBlocks(64).trackedUpdateRate(1).build()
    );

    public static void initialize() {
        FabricDefaultAttributeRegistry.register(ADELIE_PENGUIN, AdeliePenguinEntity.getEntityAttributes());
    }

}
