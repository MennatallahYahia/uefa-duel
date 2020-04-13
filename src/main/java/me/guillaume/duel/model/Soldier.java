package me.guillaume.duel.model;

public interface Soldier {

	int hitPoints();

	int soldierDamagePerHit();

	void hitSoldier(Soldier soldier);

	void markSoldierAsDead();

	void engage(Soldier otherSoldier);

}
