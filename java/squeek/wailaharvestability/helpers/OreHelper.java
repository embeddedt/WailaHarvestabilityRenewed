package squeek.wailaharvestability.helpers;

import net.minecraft.block.Block;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.Tags;

public class OreHelper
{
	public static boolean isBlockAnOre(Block block)
	{
		return isItemAnOre(new ItemStack(block)) || block.is(Tags.Blocks.ORES);
	}

	public static boolean isItemAnOre(ItemStack stack)
	{
		if (stack.getItem().is(Tags.Items.ORES)) {
			return true;
		}

		// ore in the display name (but not part of another word)
		if (stack.getHoverName().getString().matches(".*(^|\\s)([oO]re)($|\\s).*"))
			return true;

		// ore as the start of the unlocalized name
		if (stack.getItem().getDescriptionId().startsWith("ore"))
			return true;

		return false;
	}
}