package fr.klaivert.orderofobsidian;

import fr.klaivert.orderofobsidian.block.ModBlocks;
import fr.klaivert.orderofobsidian.block.entity.ModBlockEntities;
import fr.klaivert.orderofobsidian.block.entity.ModWoodTypes;
import fr.klaivert.orderofobsidian.config.OrderOfObsidianClientConfigs;
import fr.klaivert.orderofobsidian.config.OrderOfObsidianCommonConfigs;
import fr.klaivert.orderofobsidian.effect.ModEffects;
import fr.klaivert.orderofobsidian.enchantment.ModEnchantments;
import fr.klaivert.orderofobsidian.entity.ModEntityTypes;
import fr.klaivert.orderofobsidian.fluid.ModFluids;
import fr.klaivert.orderofobsidian.painting.ModPaintings;
import fr.klaivert.orderofobsidian.particle.ModParticles;
import fr.klaivert.orderofobsidian.potion.ModPotions;
import fr.klaivert.orderofobsidian.recipe.ModRecipes;
import fr.klaivert.orderofobsidian.screen.ModMenuTypes;
import fr.klaivert.orderofobsidian.sound.ModSounds;
import fr.klaivert.orderofobsidian.villager.ModPOIs;
import fr.klaivert.orderofobsidian.villager.ModVillagers;
import fr.klaivert.orderofobsidian.world.biomemods.ModBiomeModifiers;
import fr.klaivert.orderofobsidian.world.dimension.ModDimensions;
import fr.klaivert.orderofobsidian.world.feature.ModPlacedFeatures;
import fr.klaivert.orderofobsidian.world.structure.ModStructures;
import fr.klaivert.orderofobsidian.item.ModItems;
import fr.klaivert.orderofobsidian.util.BetterBrewingRecipe;
import net.minecraft.client.renderer.Sheets;
import net.minecraft.world.entity.SpawnPlacements;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.item.alchemy.Potions;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.FlowerPotBlock;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.brewing.BrewingRecipeRegistry;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import software.bernie.geckolib3.GeckoLib;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(OrderOfObsidianMod.MOD_ID)
public class OrderOfObsidianMod {
    public static final String MOD_ID = "orderofobsidian";

    // Directly reference a log4j logger.
    public static final Logger LOGGER = LogManager.getLogger();

    // Add a comment
    public OrderOfObsidianMod() {
        IEventBus eventBus = FMLJavaModLoadingContext.get().getModEventBus();

        ModItems.register(eventBus);
        ModBlocks.register(eventBus);

        ModPaintings.register(eventBus);
        ModSounds.register(eventBus);

        ModEffects.register(eventBus);
        ModPotions.register(eventBus);

        ModBlockEntities.register(eventBus);
        ModMenuTypes.register(eventBus);

        ModRecipes.register(eventBus);
        ModParticles.register(eventBus);

        ModFluids.register(eventBus);
        ModEnchantments.register(eventBus);

        ModEntityTypes.register(eventBus);
        ModVillagers.register(eventBus);

        ModStructures.register(eventBus);
        ModDimensions.register();

        ModPOIs.register(eventBus);

        ModBiomeModifiers.register(eventBus);
        ModPlacedFeatures.register(eventBus);

        eventBus.addListener(this::setup);

        GeckoLib.initialize();

        ModLoadingContext.get().registerConfig(ModConfig.Type.CLIENT, OrderOfObsidianClientConfigs.SPEC, "tutorialmod-client.toml");
        ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, OrderOfObsidianCommonConfigs.SPEC, "tutorialmod-common.toml");

        // Register ourselves for server and other game events we are interested in
        MinecraftForge.EVENT_BUS.register(this);
    }

    private void setup(final FMLCommonSetupEvent event) {
        event.enqueueWork(() -> {
            ((FlowerPotBlock) Blocks.FLOWER_POT).addPlant(ModBlocks.PINK_ROSE.getId(), ModBlocks.POTTED_PINK_ROSE);

            BrewingRecipeRegistry.addRecipe(new BetterBrewingRecipe(Potions.AWKWARD,
                    ModItems.CITRINE.get(), ModPotions.FREEZE_POTION.get()));

            Sheets.addWoodType(ModWoodTypes.EBONY);

            SpawnPlacements.register(ModEntityTypes.RACCOON.get(),
                    SpawnPlacements.Type.ON_GROUND,
                    Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,
                    Animal::checkAnimalSpawnRules);

            ModVillagers.registerPOIs();
        });
    }
}
