package me.guillaume.duel.model;

public class Armor extends Equipment {

	public Armor() {
		super();
		usageCount = 1;
	}

	@Override
	public void decrementUsage() {
		usageCount--;
	}

	@Override
	public void resetUsageCount() {
		usageCount = 1;
	}

	@Override
	public void handleDamage(Soldier first, Soldier second) {
		first.reduceDeliveredDamage(second);
		first.reduceReceivedDamage();
	}

}
