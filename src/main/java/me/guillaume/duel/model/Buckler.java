package me.guillaume.duel.model;

public class Buckler extends Equipment {

	public Buckler() {
		super();
		usageCount = 2;
	}

	@Override
	public void decrementUsage() {
		usageCount--;
	}

	@Override
	public void resetUsageCount() {
		usageCount = 2;
	}

	@Override
	public void handleDamage(Soldier first, Soldier second) {
		if (!first.checkMaxAxeBlows(second)) {
			first.cancelBlowDamage(second);
		}
	}

}
