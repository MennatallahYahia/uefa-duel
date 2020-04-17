package me.guillaume.duel.model;

import me.guillaume.duel.factory.EquipmentFactory;

public class Swordsman extends Soldier {

	private static final int MAX_AXE_BLOW = 3;
	private static final int BUCKLER_TIMES = 2;

	private int numberOfAxeBlows;

	public Swordsman() {
		super();
		hitDamages = 5;
		hitPoints = 100;
	}

	@Override
	public int soldierDamagePerHit() {
		return hitDamages;
	}

	@Override
	public Swordsman equip(String equipmentName) {
		equipments.add(EquipmentFactory.constructEquipment(equipmentName));
		return this;
	}

	public void incrementNumberOfAxeBlows() {
		numberOfAxeBlows++;
	}

	public boolean isMaxNumberOfAxeBlows() {
		return !(numberOfAxeBlows <= BUCKLER_TIMES * MAX_AXE_BLOW);
	}

}
