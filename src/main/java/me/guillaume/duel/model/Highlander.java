package me.guillaume.duel.model;

import me.guillaume.duel.factory.EquipmentFactory;

public class Highlander extends Soldier {

	private int attacksCount;

	public Highlander() {
		super();
		hitDamages = 12;
		attacksCount = 2;
		hitPoints = 150;
	}

	@Override
	public Highlander equip(String equipmentName) {
		equipments.add(EquipmentFactory.constructEquipment(equipmentName));
		return this;
	}

	@Override
	public int soldierDamagePerHit() {
		return hitDamages;
	}

	@Override
	public void blows(Soldier otherSoldier) {
		if (attacksCount > 1) {// 2 attacks by two handed Sword each of 6 damages.
			otherSoldier.hitPoints -= hitDamages;
			attacksCount--;
		} else {// reset
			attacksCount = 2;
		}
	}

}
