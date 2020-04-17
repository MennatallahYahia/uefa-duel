package me.guillaume.duel.model;

import me.guillaume.duel.factory.EquipmentFactory;

public class Viking extends Soldier {

	public Viking() {
		super();
		hitDamages = 6;
		hitPoints = 120;
	}

	@Override
	public int soldierDamagePerHit() {
		return hitDamages;
	}

	@Override
	public Viking equip(String equipmentName) {
		equipments.add(EquipmentFactory.constructEquipment(equipmentName));
		return this;
	}

}
