package net.teunisman.rifted.item;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.teunisman.rifted.Rifted;
import net.teunisman.rifted.block.ModdedBlocks;

public class ModItemGroups {

    public static final ItemGroup RIFTED_ITEMS_GROUP = Registry.register(Registries.ITEM_GROUP,
            Identifier.of(Rifted.MOD_ID, "rifted_items"),
            FabricItemGroup.builder().icon(() ->new ItemStack(ModdedItems.PINK_GARNET))
                    .displayName(Text.translatable("rifted.rifted_items"))
                    .entries((displayContext, entries) -> {
                        entries.add(ModdedItems.PINK_GARNET);
                        entries.add(ModdedItems.RAW_PINK_GARNET);
                    }).build());

    public static final ItemGroup RIFTED_BLOCKS_GROUP = Registry.register(Registries.ITEM_GROUP,
            Identifier.of(Rifted.MOD_ID, "rifted_blocks"),
            FabricItemGroup.builder().icon(() ->new ItemStack(ModdedBlocks.PINK_GARNET_BLOCK))
                    .displayName(Text.translatable("rifted.rifted_blocks"))
                    .entries((displayContext, entries) -> {
                        entries.add(ModdedBlocks.PINK_GARNET_BLOCK);
                        entries.add(ModdedBlocks.PINK_GARNET_ORE);
                    }).build());

    public static void registerItemGroups() {
        Rifted.LOGGER.info("Registering item groups");
    }

}
