package me.elcih.CustomAIEntity.utils;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

public class ReflectHelper
{
	public static Object getField(String fieldName, Class<?> clazz, Object object)
	{
		Field field;
		Object o = null;

		try
		{
			field = clazz.getField(fieldName);

			o = field.get(object);
		} catch (NoSuchFieldException e)
		{
			e.printStackTrace();
		} catch (IllegalAccessException e)
		{
			e.printStackTrace();
		}

		return o;
	}

	public static Object getPrivateField(String fieldName, Class<?> clazz, Object object)
	{
		Field field;
		Object o = null;

		try
		{
			field = clazz.getDeclaredField(fieldName);

			field.setAccessible(true);

			o = field.get(object);
		} catch (NoSuchFieldException e)
		{
			e.printStackTrace();
		} catch (IllegalAccessException e)
		{
			e.printStackTrace();
		}

		return o;
	}

	public static Object staticInvoke(Class<?> clazz, String methodName, Object... params)
	{
		Class<?>[] paramClazz = new Class<?>[params.length];
		for (int i = 0; i < params.length; i++)
		{
			paramClazz[i] = params[i].getClass();
		}
		Object obj = null;
		try
		{
			try
			{
				obj = clazz.getMethod(methodName, paramClazz).invoke(null, params);
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
		return obj;
	}
}
