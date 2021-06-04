package com.arrowsamuel.pauldron.core.init;

import com.arrowsamuel.pauldron.Pauldron;
import com.arrowsamuel.pauldron.common.items.PauldronGold;
import com.arrowsamuel.pauldron.common.items.PauldronIron;
import net.minecraft.item.Item;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.HashMap;
import java.util.Map;

public class ItemInit {

    static Map<String, Item> ITEM_MAP = new HashMap<>();
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, Pauldron.MOD_ID);

    static Item.Properties itemProps() {
        return new Item.Properties().group(Pauldron.TAB);
    }

    /*static RegistryObject<Item> addItem(String name) {
        Item i = new Item(itemProps());
        ITEM_MAP.put(name, i);
        return ITEMS.register(name, () -> i);
    }

    static RegistryObject<Item> addItem(String name, Item.Properties props) {
        Item i = new Item(props);
        ITEM_MAP.put(name, i);
        return ITEMS.register(name, () -> i);
    }*/

    static RegistryObject<Item> addItem(String name, Item item) {
        ITEM_MAP.put(name, item);
        return ITEMS.register(name, () -> item);
    }

    public static final RegistryObject<Item> TEST_ITEM = ITEMS.register("test_item", () -> new Item(new Item.Properties().group(Pauldron.TAB)));

    public static RegistryObject<Item>

            PAULDRON_IRON = addItem("pauldron_iron", new PauldronIron(itemProps().maxStackSize(1))),
            PAULDRON_GOLD = addItem("pauldron_gold", new PauldronGold(itemProps().maxStackSize(1)));

}
