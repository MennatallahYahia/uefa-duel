package me.guillaume.duel.handler;

import me.guillaume.duel.model.Equipment;
import me.guillaume.duel.model.Soldier;

public class BlowingHandlerImpl implements BlowingHandler {

	@Override
	public void handleBlow(Soldier first, Soldier second) {
		first.blows(second);
		handleEquipment(first, second);
	}

	private void handleEquipment(Soldier first, Soldier second) {
		for (Equipment equip : first.getEquipments()) {
			equip.handleDamage(first, second);
		}
	}

}
