package me.guillaume.duel.model;

public abstract class Equipment {

	protected int usageCount;
	protected String name;

	public int getUsageCount() {
		return usageCount;
	}

	public abstract void decrementUsage();

	public abstract void resetUsageCount();

	public abstract void handleDamage(Soldier first, Soldier second);

}
