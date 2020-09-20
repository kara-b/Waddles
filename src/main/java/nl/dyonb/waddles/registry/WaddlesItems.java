package nl.dyonb.waddles.registry;

import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.SpawnEggItem;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import nl.dyonb.waddles.Waddles;

public class WaddlesItems {

    public static final Item ADELIE_PENGUIN_SPAWN_EGG = register("adelie_penguin_spawn_egg",
            new SpawnEggItem(WaddlesEntities.ADELIE_PENGUIN, 0x000000, 0xFFFFFF, getBasicItemSettings()));

    public static void initialize() {
        // Not used here
    }

    /**
     * @param name
     *        Name of item instance to be registered
     * @param item
     *        Item instance to be registered
     * @return Item instanced registered
     */
    public static <T extends Item> T register(String name, T item) {
        return register(Waddles.identifier(name), item);
    }

    /**
     * @param name
     *        Identifier of item instance to be registered
     * @param item
     *        Item instance to be registered
     * @return Item instance registered
     */
    public static <T extends Item> T register(Identifier name, T item) {
        return Registry.register(Registry.ITEM, name, item);
    }

    /**
     * @return Basic Item.Settings
     */
    public static Item.Settings getBasicItemSettings() {
        return new Item.Settings().group(ItemGroup.MISC);
    }

}
