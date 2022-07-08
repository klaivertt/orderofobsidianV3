package fr.klaivert.orderofobsidian.world.feature;

import fr.klaivert.orderofobsidian.block.ModBlocks;
import fr.klaivert.orderofobsidian.config.OrderOfObsidianCommonConfigs;
import net.minecraft.core.Holder;
import net.minecraft.data.worldgen.features.FeatureUtils;
import net.minecraft.data.worldgen.features.OreFeatures;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.util.valueproviders.ConstantInt;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.WeightedPlacedFeature;
import net.minecraft.world.level.levelgen.feature.configurations.*;
import net.minecraft.world.level.levelgen.feature.featuresize.TwoLayersFeatureSize;
import net.minecraft.world.level.levelgen.feature.foliageplacers.BlobFoliagePlacer;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.feature.trunkplacers.StraightTrunkPlacer;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraft.world.level.levelgen.structure.templatesystem.BlockMatchTest;

import java.util.List;

public class ModConfiguredFeatures {
    public static final Holder<ConfiguredFeature<TreeConfiguration, ?>> EBONY_TREE =
            FeatureUtils.register("ebony", Feature.TREE, new TreeConfiguration.TreeConfigurationBuilder(
                    BlockStateProvider.simple(ModBlocks.EBONY_LOG.get()),
                    new StraightTrunkPlacer(5, 6, 3),
                    BlockStateProvider.simple(ModBlocks.EBONY_LEAVES.get()),
                    new BlobFoliagePlacer(ConstantInt.of(2), ConstantInt.of(0), 4),
                    new TwoLayersFeatureSize(1, 0, 2))
            .dirt(BlockStateProvider.simple(Blocks.END_STONE)).build());

    public static final Holder<PlacedFeature> EBONY_CHECKED = PlacementUtils.register("ebony_checked", EBONY_TREE,
                    PlacementUtils.filteredByBlockSurvival(ModBlocks.EBONY_SAPLING.get()));

    public static final Holder<ConfiguredFeature<RandomFeatureConfiguration, ?>> EBONY_SPAWN =
            FeatureUtils.register("ebony_spawn", Feature.RANDOM_SELECTOR,
                    new RandomFeatureConfiguration(List.of(new WeightedPlacedFeature(EBONY_CHECKED,
                            0.5F)), EBONY_CHECKED));


    public static final Holder<ConfiguredFeature<RandomPatchConfiguration, ?>> PINK_ROSE =
            FeatureUtils.register("flower_pink_rose", Feature.FLOWER,
                    new RandomPatchConfiguration(32, 6, 2, PlacementUtils.onlyWhenEmpty(Feature.SIMPLE_BLOCK,
                            new SimpleBlockConfiguration(BlockStateProvider.simple(ModBlocks.PINK_ROSE.get())))));


    public static final List<OreConfiguration.TargetBlockState> OVERWORLD_CITRINE_ORES = List.of(
            OreConfiguration.target(OreFeatures.STONE_ORE_REPLACEABLES, ModBlocks.CITRINE_ORE.get().defaultBlockState()),
            OreConfiguration.target(OreFeatures.DEEPSLATE_ORE_REPLACEABLES, ModBlocks.DEEPSLATE_CITRINE_ORE.get().defaultBlockState()));

    public static final List<OreConfiguration.TargetBlockState> END_CITRINE_ORES = List.of(
            OreConfiguration.target(new BlockMatchTest(Blocks.END_STONE), ModBlocks.ENDSTONE_CITRINE_ORE.get().defaultBlockState()));

    public static final List<OreConfiguration.TargetBlockState> NETHER_CITRINE_ORES = List.of(
            OreConfiguration.target(OreFeatures.NETHER_ORE_REPLACEABLES, ModBlocks.NETHERRACK_CITRINE_ORE.get().defaultBlockState()));

    public static final Holder<ConfiguredFeature<OreConfiguration, ?>> CITRINE_ORE = FeatureUtils.register("citrine_ore",
            Feature.ORE, new OreConfiguration(OVERWORLD_CITRINE_ORES, OrderOfObsidianCommonConfigs.CITRINE_ORE_VEIN_SIZE.get()));
    public static final Holder<ConfiguredFeature<OreConfiguration, ?>> END_CITRINE_ORE = FeatureUtils.register("end_citrine_ore",
            Feature.ORE, new OreConfiguration(END_CITRINE_ORES, 9));
    public static final Holder<ConfiguredFeature<OreConfiguration, ?>> NETHER_CITRINE_ORE = FeatureUtils.register("nether_citrine_ore",
            Feature.ORE, new OreConfiguration(NETHER_CITRINE_ORES, 9));

}
