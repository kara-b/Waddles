package nl.dyonb.waddles.registry;

import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import nl.dyonb.waddles.Waddles;

public class WaddlesSounds {

    public static SoundEvent ADELIE_AMBIENT = register(Waddles.identifier("adelie.ambient"));
    public static SoundEvent ADELIE_BABY_AMBIENT = register(Waddles.identifier("adelie.baby.ambient"));
    public static SoundEvent ADELIE_DEATH = register(Waddles.identifier("adelie.death"));
    public static SoundEvent ADELIE_HURT = register(Waddles.identifier("adelie.hurt"));

    public static void initialize() {

    }

    public static SoundEvent register(Identifier identifier) {
        return Registry.register(Registry.SOUND_EVENT, identifier, new SoundEvent(identifier));
    }

}
