package fr.klaivert.orderofobsidian.block.entity.client;

import fr.klaivert.orderofobsidian.OrderOfObsidianMod;
import fr.klaivert.orderofobsidian.item.custom.AnimatedItem;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class AnimatedItemModel extends AnimatedGeoModel<AnimatedItem> {
    @Override
    public ResourceLocation getModelResource(AnimatedItem object) {
        return new ResourceLocation(OrderOfObsidianMod.MOD_ID, "geo/animated_item.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(AnimatedItem object) {
        return new ResourceLocation(OrderOfObsidianMod.MOD_ID, "textures/item/animated_item_texture.png");
    }

    @Override
    public ResourceLocation getAnimationResource(AnimatedItem animatable) {
        return new ResourceLocation(OrderOfObsidianMod.MOD_ID, "animations/animated_item.animation.json");
    }
}
