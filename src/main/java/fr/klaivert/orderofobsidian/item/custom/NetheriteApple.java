
package fr.klaivert.orderofobsidian.item.custom;


import fr.klaivert.orderofobsidian.effect.food.NetheriteAppleFoodEatenProcedure;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.level.Level;

public class NetheriteApple extends Item {
	public NetheriteApple() {
		super(new Properties().tab(CreativeModeTab.TAB_FOOD).fireResistant().stacksTo(64).rarity(Rarity.RARE)
				.food((new FoodProperties.Builder()).nutrition(5).saturationMod(0.7f)

						.build()));
	}

	@Override
	public ItemStack finishUsingItem(ItemStack itemstack, Level world, LivingEntity entity) {
		ItemStack retval = super.finishUsingItem(itemstack, world, entity);
		double x = entity.getX();
		double y = entity.getY();
		double z = entity.getZ();

		NetheriteAppleFoodEatenProcedure.execute(entity);
		return retval;
	}
}
