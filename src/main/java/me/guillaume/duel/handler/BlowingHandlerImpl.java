package me.guillaume.duel.handler;

import me.guillaume.duel.enumeration.Equipment;
import me.guillaume.duel.model.Soldier;
import me.guillaume.duel.model.Swordsman;

public class BlowingHandlerImpl implements BlowingHandler {

	@Override
	public void handleBlowEquipment(Soldier first, Soldier second) {
		first.getBlowed(second);
		boolean hasMaxAxeBlowsReached = checkMaxAxeBlows(first);
		handleEquipment(first, second, hasMaxAxeBlowsReached);
	}

	private void handleEquipment(Soldier first, Soldier second, boolean hasMaxAxeBlowsReached) {
		if (checkEquipmentType(first, hasMaxAxeBlowsReached)) {
			cancelBlowDamage(first, second);
			first.decrementEquipmentUsage();
			resetEquipmentUsage(first);
		}
	}

	private boolean checkEquipmentType(Soldier first, boolean hasMaxAxeBlowsReached) {
		return first.getEquipment().equals(Equipment.buckler) && !hasMaxAxeBlowsReached;
	}

	private void cancelBlowDamage(Soldier first, Soldier second) {
		if (first.getEquipmentUsage() > 1) {
			first.cancelBlowDamage(second);
		}
	}

	private void resetEquipmentUsage(Soldier first) {
		if (first.getEquipmentUsage() == 0) {
			first.resetEquipmentUsage();
		}
	}

	private boolean checkMaxAxeBlows(Soldier first) {
		boolean isMax = false;
		if (first instanceof Swordsman) {
			((Swordsman) first).incrementNumberOfAxeBlows();
			isMax = ((Swordsman) first).isMaxNumberOfAxeBlows();
		}
		return isMax;
	}
}
