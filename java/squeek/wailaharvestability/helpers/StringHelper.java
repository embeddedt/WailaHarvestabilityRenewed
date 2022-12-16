package squeek.wailaharvestability.helpers;

import net.minecraft.client.resources.I18n;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.TranslationTextComponent;

import java.lang.reflect.Method;
import java.util.List;

public class StringHelper
{

	public static Class<?> harvestLevels = null;
	public static Method getHarvestLevelName = null;
	static
	{
		try
		{
			harvestLevels = Class.forName("slimeknights.tconstruct.library.utils.HarvestLevels");
			getHarvestLevelName = harvestLevels.getDeclaredMethod("getHarvestLevelName", int.class);
		}
		catch (Exception e)
		{
		}
	}

	public static ITextComponent getHarvestLevelName(int num)
	{
		if (getHarvestLevelName != null)
		{
			try
			{
				return (ITextComponent)getHarvestLevelName.invoke(null, num);
			}
			catch (Exception e)
			{
			}
		}

		String unlocalized = "wailaharvestability.harvestlevel" + (num + 1);

		if (I18n.hasKey(unlocalized))
			return new TranslationTextComponent(unlocalized);

		return new StringTextComponent(String.valueOf(num));
	}

	public static ITextComponent concatenateStringList(List<ITextComponent> textComponents, String separator)
	{
		StringBuilder sb = new StringBuilder();
		String sep = "";
		for (ITextComponent s : textComponents)
		{
			sb.append(sep).append(s.getString());
			sep = separator;
		}
		return new StringTextComponent(sb.toString());
	}

	public static String stripFormatting(String str)
	{
		return TextFormatting.getTextWithoutFormattingCodes(str);
	}
}
