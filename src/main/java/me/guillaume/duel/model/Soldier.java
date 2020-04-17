package me.guillaume.duel.model;

import java.util.ArrayList;
import java.util.List;

import me.guillaume.duel.handler.EngagementHandler;
import me.guillaume.duel.handler.EngagementHandlerImpl;

public abstract class Soldier {

	protected EngagementHandler engagementHandler;
	protected int hitDamages;
	protected int hitPoints;
	protected List<Equipment> equipments;

	public Soldier() {
		super();
		equipments = new ArrayList<>();
		engagementHandler = new EngagementHandlerImpl();
	}

	public void markSoldierAsDead() {
		hitPoints = 0;
	}

	public int hitPoints() {
		return hitPoints;
	}

	public void engage(Soldier otherSoldier) {
		engagementHandler.engage(this, otherSoldier);
	}

	public List<Equipment> getEquipments() {
		return equipments;
	}

	public void blows(Soldier otherSoldier) {
		otherSoldier.hitPoints -= soldierDamagePerHit();
	}

	public void cancelBlowDamage(Soldier otherSoldier) {
		for (Equipment equip : otherSoldier.equipments) {
			if (equip instanceof Buckler) {
				if (equip.getUsageCount() > 1) {
					otherSoldier.hitPoints += soldierDamagePerHit();
					equip.decrementUsage();
				} else {
					equip.resetUsageCount();
				}
			}
		}

	}

	public boolean checkMaxAxeBlows(Soldier first) {
		boolean isMax = false;
		if (first instanceof Swordsman) {
			((Swordsman) first).incrementNumberOfAxeBlows();
			isMax = ((Swordsman) first).isMaxNumberOfAxeBlows();
		}
		return isMax;
	}

	public void reduceDeliveredDamage(Soldier otherSoldier) {
		otherSoldier.hitPoints += 1;
	}

	public void reduceReceivedDamage() {
		hitPoints += 3;
	}

	public abstract Soldier equip(String equipment);

	public abstract int soldierDamagePerHit();

}
