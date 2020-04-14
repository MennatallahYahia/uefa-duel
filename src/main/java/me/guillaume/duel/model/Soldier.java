package me.guillaume.duel.model;

import me.guillaume.duel.enumeration.Equipment;
import me.guillaume.duel.handler.EngagementHandler;
import me.guillaume.duel.handler.EngagementHandlerImpl;

public abstract class Soldier {
	protected EngagementHandler engagementHandler;
	protected int hitPoints;
	protected Equipment equipment;
	protected int equipmentUsage;

	public Soldier() {
		super();
		this.equipment = Equipment.nothing;
		this.engagementHandler = new EngagementHandlerImpl();
		this.equipmentUsage = 2;
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

	public Equipment getEquipment() {
		return equipment;
	}

	public EngagementHandler getEngagementHandler() {
		return engagementHandler;
	}

	public int getHitPoints() {
		return hitPoints;
	}

	public int getEquipmentUsage() {
		return equipmentUsage;
	}

	public void resetEquipmentUsage() {
		equipmentUsage = 2;
	}

	public void decrementEquipmentUsage() {
		equipmentUsage--;
	}

	public void getBlowed(Soldier otherSoldier) {
		this.hitPoints -= otherSoldier.soldierDamagePerHit();
	}

	public void cancelBlowDamage(Soldier otherSoldier) {
		this.hitPoints += otherSoldier.soldierDamagePerHit();
	}

	public abstract Soldier equip(String equipment);

	public abstract int soldierDamagePerHit();

}
