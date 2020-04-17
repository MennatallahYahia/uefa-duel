package me.guillaume.duel.factory;

import me.guillaume.duel.model.Armor;
import me.guillaume.duel.model.Buckler;
import me.guillaume.duel.model.Equipment;

public class EquipmentFactory {

	public static Equipment constructEquipment(String name) {
		switch (name) {
		case "buckler":
			return new Buckler();
		case "armor":
			return new Armor();
		default:
			throw new IllegalArgumentException();
		}
	}
}
