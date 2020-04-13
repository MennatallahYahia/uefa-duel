package me.guillaume.duel.handler;

import me.guillaume.duel.model.Soldier;

public interface EngagementHandler {

	static final boolean STILL_ALIVE = true;

	void engage(Soldier first, Soldier second);

}
