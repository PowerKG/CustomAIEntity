package me.elcih.CustomAIEntity;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

import org.bukkit.Location;
import org.bukkit.craftbukkit.v1_7_R4.CraftWorld;
import org.bukkit.entity.EntityType;

import me.elcih.CustomAIEntity.Entity.FriendlyZombie;
import me.elcih.CustomAIEntity.utils.ReflectHelper;
import net.minecraft.server.v1_7_R4.World;
import net.minecraft.server.v1_7_R4.WorldServer;

@SuppressWarnings("deprecation")
public enum CustomEntityType
{
	friendlyZombie("Zombie", EntityType.ZOMBIE.getTypeId(), FriendlyZombie.class);

	private final Class<?> clazz;

	private CustomEntityType(String name, int id, Class<?> clazz)
	{
		this.clazz = clazz;
		addToMaps(clazz, name, id);
	}

	public net.minecraft.server.v1_7_R4.Entity spawn(Location loc)
	{
		WorldServer world = ((CraftWorld) loc.getWorld()).getHandle();

		Object obj = null;

		try
		{
			Constructor<?> c0 = clazz.getConstructor(World.class);
			try
			{
				obj = c0.newInstance(world);
			} catch (InstantiationException e)
			{
				e.printStackTrace();
			} catch (IllegalAccessException e)
			{
				e.printStackTrace();
			} catch (IllegalArgumentException e)
			{
				e.printStackTrace();
			} catch (InvocationTargetException e)
			{
				e.printStackTrace();
			}
		} catch (NoSuchMethodException e)
		{
			e.printStackTrace();
		} catch (SecurityException e)
		{
			e.printStackTrace();
		}

		if (obj == null)
		{
			return null;
		}

		net.minecraft.server.v1_7_R4.Entity entity = (net.minecraft.server.v1_7_R4.Entity) obj;

		entity.setLocation(loc.getX(), loc.getY(), loc.getZ(), loc.getYaw(), loc.getPitch());

		world.addEntity(entity);

		return entity;
	}

	@SuppressWarnings(
	{ "unchecked", "rawtypes" })
	private static void addToMaps(Class<?> clazz, String name, int id)
	{

		if (CustomAIEntity.isForgeSide())
		{
			((Map) ReflectHelper.getPrivateField("field_75625_b", net.minecraft.server.v1_7_R4.EntityTypes.class, null)).put(name, clazz);
			((Map) ReflectHelper.getPrivateField("field_75626_c", net.minecraft.server.v1_7_R4.EntityTypes.class, null)).put(clazz, name);
			((Map) ReflectHelper.getPrivateField("field_75624_e", net.minecraft.server.v1_7_R4.EntityTypes.class, null)).put(clazz, Integer.valueOf(id));
		} else
		{
			((Map) ReflectHelper.getPrivateField("c", net.minecraft.server.v1_7_R4.EntityTypes.class, null)).put(name, clazz);
			((Map) ReflectHelper.getPrivateField("d", net.minecraft.server.v1_7_R4.EntityTypes.class, null)).put(clazz, name);
			((Map) ReflectHelper.getPrivateField("f", net.minecraft.server.v1_7_R4.EntityTypes.class, null)).put(clazz, Integer.valueOf(id));
		}
	}
}
