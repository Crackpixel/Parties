package com.alessiodp.parties.api.events.bukkit.party;

import com.alessiodp.parties.api.events.bukkit.BukkitPartiesEvent;
import com.alessiodp.parties.api.events.common.party.IPartyLevelUpEvent;
import com.alessiodp.parties.api.interfaces.Party;
import org.checkerframework.checker.nullness.qual.NonNull;

public class BukkitPartiesPartyLevelUpEvent extends BukkitPartiesEvent implements IPartyLevelUpEvent {
	private final Party party;
	private final int newLevel;
	
	public BukkitPartiesPartyLevelUpEvent(Party party, int newLevel) {
		super(true);
		this.party = party;
		this.newLevel = newLevel;
	}
	
	@NonNull
	@Override
	public Party getParty() {
		return party;
	}
	
	@Override
	public int getNewLevel() {
		return newLevel;
	}
}
