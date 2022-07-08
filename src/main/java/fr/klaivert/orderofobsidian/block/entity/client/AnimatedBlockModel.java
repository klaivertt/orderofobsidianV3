package fr.klaivert.orderofobsidian.block.entity.client;

import fr.klaivert.orderofobsidian.block.entity.custom.AnimatedBlockEntity;
import fr.klaivert.orderofobsidian.OrderOfObsidianMod;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class AnimatedBlockModel extends AnimatedGeoModel<AnimatedBlockEntity> {
    @Override
    public ResourceLocation getModelResource(AnimatedBlockEntity object) {
        return new ResourceLocation(OrderOfObsidianMod.MOD_ID, "geo/animated_block.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(AnimatedBlockEntity object) {
        return new ResourceLocation(OrderOfObsidianMod.MOD_ID, "textures/machines/animated_block.png");
    }

    @Override
    public ResourceLocation getAnimationResource(AnimatedBlockEntity animatable) {
        return new ResourceLocation(OrderOfObsidianMod.MOD_ID, "animations/animated_block.animation.json");
    }
}