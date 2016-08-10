package me.elcih.CustomAIEntity.AI;

import net.minecraft.server.v1_7_R4.PathfinderGoal;

public abstract class SimpleAI extends PathfinderGoal
{
	public SimpleAI()
	{
	}

	@Override
	public boolean a()
	{
		return shouldExecute();
	}

	@Override
	public boolean b()
	{
		return continueExecuting();
	}

	@Override
	public void c()
	{
		startExecuting();
	}

	@Override
	public void d()
	{
		resetTask();
	}

	@Override
	public void e()
	{
		updateTask();
	}

	// 1/7 s 
	/**
	 * Returns whether the EntityAIBase should begin execution.
	 */
	public abstract boolean shouldExecute();

	/**
	 * Returns whether an in-progress EntityAIBase should continue executing
	 */
	public boolean continueExecuting()
	{
		return super.b();
	}

	/**
	 * Execute a one shot task or start executing a continuous task
	 */
	public void startExecuting()
	{
		super.c();
	}

	/**
	 * Resets the task
	 */
	public void resetTask()
	{
		super.d();
	}

	/**
	 * Updates the task
	 */
	public void updateTask()
	{

	}

}
