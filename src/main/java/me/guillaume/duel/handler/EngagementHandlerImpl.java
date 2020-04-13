package me.guillaume.duel.handler;

import me.guillaume.duel.model.Soldier;

public class EngagementHandlerImpl implements EngagementHandler {

	@Override
	public void engage(Soldier first, Soldier second) {
		while (STILL_ALIVE) {
			first.hitSoldier(second);
			second.hitSoldier(first);
			if (checkSoldierAndMarkIfDead(first) || checkSoldierAndMarkIfDead(second)) {
				break;
			}
		}
	}

	private boolean checkSoldierAndMarkIfDead(Soldier soldier) {
		if (isDead(soldier)) {
			soldier.markSoldierAsDead();
			return true;
		} else {
			return false;
		}
	}

	private boolean isDead(Soldier soldier) {
		return soldier.hitPoints() == 0 || soldier.hitPoints() < 0;
	}

}
