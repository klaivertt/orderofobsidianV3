package fr.klaivert.orderofobsidian.world.structure;

import com.mojang.serialization.Codec;
import fr.klaivert.orderofobsidian.OrderOfObsidianMod;
import net.minecraft.core.Registry;
import net.minecraft.world.level.levelgen.structure.Structure;
import net.minecraft.world.level.levelgen.structure.StructureType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModStructures {

    /**
     * We are using the Deferred Registry system to register our structure as this is the preferred way on Forge.
     * This will handle registering the base structure for us at the correct time so we don't have to handle it ourselves.
     */
    public static final DeferredRegister<StructureType<?>> DEFERRED_REGISTRY_STRUCTURE
            = DeferredRegister.create(Registry.STRUCTURE_TYPE_REGISTRY, OrderOfObsidianMod.MOD_ID);

    /**
     * Registers the base structure itself and sets what its path is. In this case,
     * this base structure will have the resourcelocation of structure_tutorial:sky_structures.
     */
    public static final RegistryObject<StructureType<?>> SKY_STRUCTURES =
            DEFERRED_REGISTRY_STRUCTURE.register("sky_structures", () -> typeConvert(SkyStructures.CODEC));

    // Helper method to register since compiler will complain about typing if we did () -> SkyStructures.CODEC directly.
    private static <S extends Structure> StructureType<S> typeConvert(Codec<S> codec) {
        return () -> codec;
    }

    public static void register(IEventBus eventBus) {
        DEFERRED_REGISTRY_STRUCTURE.register(eventBus);
    }
}