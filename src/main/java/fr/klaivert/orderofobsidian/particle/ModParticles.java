package fr.klaivert.orderofobsidian.particle;

import fr.klaivert.orderofobsidian.OrderOfObsidianMod;
import net.minecraft.core.particles.ParticleType;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModParticles {
    public static final DeferredRegister<ParticleType<?>> PARTICLE_TYPES =
            DeferredRegister.create(ForgeRegistries.PARTICLE_TYPES, OrderOfObsidianMod.MOD_ID);

    public static final RegistryObject<SimpleParticleType> CITRINE_PARTICLES =
            PARTICLE_TYPES.register("citrine_particles", () -> new SimpleParticleType(true));

    public static void register(IEventBus eventBus) {
        PARTICLE_TYPES.register(eventBus);
    }
}
