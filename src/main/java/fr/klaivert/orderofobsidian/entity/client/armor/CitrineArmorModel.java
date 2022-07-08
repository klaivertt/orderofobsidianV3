package fr.klaivert.orderofobsidian.entity.client.armor;

import fr.klaivert.orderofobsidian.OrderOfObsidianMod;
import fr.klaivert.orderofobsidian.item.custom.CitrineArmorItem;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class CitrineArmorModel extends AnimatedGeoModel<CitrineArmorItem> {
    @Override
    public ResourceLocation getModelResource(CitrineArmorItem object) {
        return new ResourceLocation(OrderOfObsidianMod.MOD_ID, "geo/citrine_armor.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(CitrineArmorItem object) {
        return new ResourceLocation(OrderOfObsidianMod.MOD_ID, "textures/models/armor/citrine_armor_texture.png");
    }

    @Override
    public ResourceLocation getAnimationResource(CitrineArmorItem animatable) {
        return new ResourceLocation(OrderOfObsidianMod.MOD_ID, "animations/armor_animation.json");
    }
}
