package me.guillaume.duel.model;

import me.guillaume.duel.handler.EngagementHandler;
import me.guillaume.duel.handler.EngagementHandlerImpl;

public class Viking implements Soldier {

	private static final int HIT_DAMAGES = 6;

	private int hitPoints;
	private EngagementHandler engagementHandler;

	public Viking() {
		super();
		this.hitPoints = 120;
		this.engagementHandler = new EngagementHandlerImpl();
	}

	@Override
	public int hitPoints() {
		return hitPoints;
	}

	@Override
	public int soldierDamagePerHit() {
		return HIT_DAMAGES;
	}

	@Override
	public void hitSoldier(Soldier soldier) {
		hitPoints -= soldier.soldierDamagePerHit();
	}

	@Override
	public void markSoldierAsDead() {
		hitPoints = 0;
	}

	@Override
	public void engage(Soldier otherSoldier) {
		engagementHandler.engage(this, otherSoldier);
	}

}
