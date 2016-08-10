package me.elcih.CustomAIEntity;

import java.lang.reflect.Field;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class CustomAIEntity extends JavaPlugin
{
	private static boolean isForgeSide;

	@Override
	public void onEnable()
	{
		boolean f = false;
		Field field;

		try
		{
			Class<?> clazz;
			try
			{
				clazz = Class.forName(net.minecraft.server.v1_7_R4.EntityTypes.class.getName());
			} catch (ClassNotFoundException e)
			{
				e.printStackTrace();
				isForgeSide = false;
				return;
			}

			field = clazz.getDeclaredField("c");

			field.setAccessible(true);

		} catch (NoSuchFieldException e)
		{
			f = true;
		}
		isForgeSide = f;
	}

	public static boolean isForgeSide()
	{
		return isForgeSide;
	}

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args)
	{
		if (label.equalsIgnoreCase("cue"))
		{
			if (sender instanceof Player)
			{
				CustomEntityType.friendlyZombie.spawn(((Player) sender).getLocation());
			}
		}
		return true;
	}
}
