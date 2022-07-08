package fr.klaivert.orderofobsidian.event;

import fr.klaivert.orderofobsidian.entity.ModEntityTypes;
import fr.klaivert.orderofobsidian.entity.custom.RaccoonEntity;
import fr.klaivert.orderofobsidian.event.loot.CoalCokeFromCreeperAdditionModifier;
import fr.klaivert.orderofobsidian.event.loot.CucumberSeedsFromGrassAdditionModifier;
import fr.klaivert.orderofobsidian.event.loot.DowsingRodInIglooAdditionModifier;
import fr.klaivert.orderofobsidian.recipe.GemCuttingStationRecipe;
import fr.klaivert.orderofobsidian.OrderOfObsidianMod;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegisterEvent;

import javax.annotation.Nonnull;

@Mod.EventBusSubscriber(modid = OrderOfObsidianMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModEventBusEvents {

    @SubscribeEvent
    public static void registerModifierSerializers(@Nonnull final RegisterEvent event) {
        event.register(ForgeRegistries.Keys.LOOT_MODIFIER_SERIALIZERS, helper -> {
            helper.register(new ResourceLocation(OrderOfObsidianMod.MOD_ID,"cucumber_seeds_from_grass"),
                    new CucumberSeedsFromGrassAdditionModifier.Serializer());
            helper.register(new ResourceLocation(OrderOfObsidianMod.MOD_ID,"dowsing_rod_in_igloo"),
                    new DowsingRodInIglooAdditionModifier.Serializer());
            helper.register(new ResourceLocation(OrderOfObsidianMod.MOD_ID,"coal_coke_from_creeper"),
                    new CoalCokeFromCreeperAdditionModifier.Serializer());
        });

        event.register(ForgeRegistries.Keys.RECIPE_TYPES, helper -> {
            helper.register(new ResourceLocation(OrderOfObsidianMod.MOD_ID, GemCuttingStationRecipe.Type.ID),
                    GemCuttingStationRecipe.Type.INSTANCE);
        });
    }

    @SubscribeEvent
    public static void entityAttributeEvent(EntityAttributeCreationEvent event) {
        event.put(ModEntityTypes.RACCOON.get(), RaccoonEntity.setAttributes());
    }
}
