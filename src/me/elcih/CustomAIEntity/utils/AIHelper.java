package me.elcih.CustomAIEntity.utils;

import java.util.List;

import me.elcih.CustomAIEntity.CustomAIEntity;


public class AIHelper
{
	public static void clearSelector(net.minecraft.server.v1_7_R4.PathfinderGoalSelector goalSelector, net.minecraft.server.v1_7_R4.PathfinderGoalSelector targetSelector)
	{
		if (CustomAIEntity.isForgeSide())
		{
			((List<?>) ReflectHelper.getPrivateField("field_75782_a", net.minecraft.server.v1_7_R4.PathfinderGoalSelector.class, goalSelector)).clear();
			((List<?>) ReflectHelper.getPrivateField("field_75780_b", net.minecraft.server.v1_7_R4.PathfinderGoalSelector.class, goalSelector)).clear();
			((List<?>) ReflectHelper.getPrivateField("field_75782_a", net.minecraft.server.v1_7_R4.PathfinderGoalSelector.class, targetSelector)).clear();
			((List<?>) ReflectHelper.getPrivateField("field_75780_b", net.minecraft.server.v1_7_R4.PathfinderGoalSelector.class, targetSelector)).clear();

		} else
		{
			((List<?>) ReflectHelper.getPrivateField("b", net.minecraft.server.v1_7_R4.PathfinderGoalSelector.class, goalSelector)).clear();
			((List<?>) ReflectHelper.getPrivateField("c", net.minecraft.server.v1_7_R4.PathfinderGoalSelector.class, goalSelector)).clear();
			((List<?>) ReflectHelper.getPrivateField("b", net.minecraft.server.v1_7_R4.PathfinderGoalSelector.class, targetSelector)).clear();
			((List<?>) ReflectHelper.getPrivateField("c", net.minecraft.server.v1_7_R4.PathfinderGoalSelector.class, targetSelector)).clear();
		}
	}
}
