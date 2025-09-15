package net.teunisman.rifted.block;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.teunisman.rifted.Rifted;
import net.minecraft.item.Item;

public class ModdedBlocks {
    public static final Block PINK_GARNET_BLOCK = registerBlock("pink_garnet_block",
            new Block(AbstractBlock.Settings.create().strength(4f)
                    .requiresTool().sounds(BlockSoundGroup.METAL)));

    public static final Block PINK_GARNET_ORE = registerBlock("pink_garnet_ore",
            new Block(AbstractBlock.Settings.create().strength(3f)
                    .requiresTool().sounds(BlockSoundGroup.STONE)));

    public static final Block TRYSTANIUM_BLOCK = registerBlock("trystanium_block",
            new Block(AbstractBlock.Settings.create().strength(4f)
                    .requiresTool().sounds(BlockSoundGroup.METAL)));

    //helper method to register blocks
    private static Block registerBlock(String name, Block block) {
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, Identifier.of(Rifted.MOD_ID, name), block);
    }
    //helper method to register block items
    private static void registerBlockItem(String name, Block block) {
        Registry.register(Registries.ITEM, Identifier.of(Rifted.MOD_ID, name),
                new BlockItem(block, new Item.Settings()));
    }

    public static void registerModdedBlocks() {
        Rifted.LOGGER.info("Registering modded blocks");

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.BUILDING_BLOCKS).register(entries -> {
            entries.add(ModdedBlocks.PINK_GARNET_BLOCK);
            entries.add(ModdedBlocks.PINK_GARNET_ORE);
            entries.add(ModdedBlocks.TRYSTANIUM_BLOCK);
        });
    }
}
