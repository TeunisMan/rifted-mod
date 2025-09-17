package net.teunisman.rifted.dimension;

import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import net.minecraft.world.World;

public class ModDimensions {
    public static final RegistryKey<World> SHADOW_WORLD_KEY =
            RegistryKey.of(RegistryKeys.WORLD, Identifier.of("rifted", "shadow_world"));
}
