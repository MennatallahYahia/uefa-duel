package me.guillaume.duel.model;

import me.guillaume.duel.enumeration.Equipment;

public class Viking extends Soldier {

	private static final int HIT_DAMAGES = 6;

	public Viking() {
		super();
		hitPoints = 120;
	}

	@Override
	public int soldierDamagePerHit() {
		return HIT_DAMAGES;
	}

	@Override
	public Viking equip(String equipment) {
		this.equipment = Equipment.valueOf(equipment);
		return this;
	}
}
