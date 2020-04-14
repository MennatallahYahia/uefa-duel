package me.guillaume.duel.model;

import me.guillaume.duel.enumeration.Equipment;

public class Swordsman extends Soldier {

	private static final int HIT_DAMAGES = 5;
	private static final int MAX_AXE_BLOW = 3;
	private static final int BUCKLER_TIMES = 2;

	private int numberOfAxeBlows;

	public Swordsman() {
		super();
		this.hitPoints = 100;
	}

	@Override
	public int soldierDamagePerHit() {
		return HIT_DAMAGES;
	}

	@Override
	public Swordsman equip(String equipment) {
		this.equipment = Equipment.valueOf(equipment);
		return this;
	}

	public void incrementNumberOfAxeBlows() {
		numberOfAxeBlows++;
	}

	public boolean isMaxNumberOfAxeBlows() {
		return !(numberOfAxeBlows <= BUCKLER_TIMES * MAX_AXE_BLOW);
	}
}
