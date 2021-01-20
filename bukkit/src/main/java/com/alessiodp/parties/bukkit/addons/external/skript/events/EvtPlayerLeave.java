package com.alessiodp.parties.bukkit.addons.external.skript.events;

import ch.njol.skript.Skript;
import ch.njol.skript.lang.util.SimpleEvent;
import ch.njol.skript.registrations.EventValues;
import ch.njol.skript.util.Getter;
import com.alessiodp.parties.api.events.bukkit.player.BukkitPartiesPlayerPostLeaveEvent;
import com.alessiodp.parties.api.events.bukkit.player.BukkitPartiesPlayerPreLeaveEvent;
import com.alessiodp.parties.api.interfaces.Party;
import com.alessiodp.parties.api.interfaces.PartyPlayer;
import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;

public class EvtPlayerLeave {
	static {
		Skript.registerEvent("PartyPlayer Pre Leave Party", SimpleEvent.class, BukkitPartiesPlayerPreLeaveEvent.class,
				"[player] pre leave[s] [a] party")
				.description("Called when a player is leaving a party.")
				.examples("on player pre leave party:",
						"\tmessage \"Player %name of event-partyplayer% is leaving the party %name of event-party%\"")
				.since("3.0.0");
		EventValues.registerEventValue(BukkitPartiesPlayerPreLeaveEvent.class, Party.class, new Getter<Party, BukkitPartiesPlayerPreLeaveEvent>() {
			@Override
			public Party get(BukkitPartiesPlayerPreLeaveEvent e) {
				return e.getParty();
			}
		}, 0);
		EventValues.registerEventValue(BukkitPartiesPlayerPreLeaveEvent.class, PartyPlayer.class, new Getter<PartyPlayer, BukkitPartiesPlayerPreLeaveEvent>() {
			@Override
			public PartyPlayer get(BukkitPartiesPlayerPreLeaveEvent e) {
				return e.getPartyPlayer();
			}
		}, 0);
		EventValues.registerEventValue(BukkitPartiesPlayerPreLeaveEvent.class, CommandSender.class, new Getter<CommandSender, BukkitPartiesPlayerPreLeaveEvent>() {
			@Override
			public CommandSender get(BukkitPartiesPlayerPreLeaveEvent e) {
				return Bukkit.getPlayer(e.getPartyPlayer().getPlayerUUID());
			}
		}, 0);
		
		Skript.registerEvent("PartyPlayer Post Leave Party", SimpleEvent.class, BukkitPartiesPlayerPostLeaveEvent.class,
				"[player] [post] leave[s] [a] party")
				.description("Called when a player left a party.")
				.examples("on player post leave party:",
						"\tmessage \"Player %name of event-partyplayer% left the party %name of event-party%\"")
				.since("3.0.0");
		EventValues.registerEventValue(BukkitPartiesPlayerPostLeaveEvent.class, Party.class, new Getter<Party, BukkitPartiesPlayerPostLeaveEvent>() {
			@Override
			public Party get(BukkitPartiesPlayerPostLeaveEvent e) {
				return e.getParty();
			}
		}, 0);
		EventValues.registerEventValue(BukkitPartiesPlayerPostLeaveEvent.class, PartyPlayer.class, new Getter<PartyPlayer, BukkitPartiesPlayerPostLeaveEvent>() {
			@Override
			public PartyPlayer get(BukkitPartiesPlayerPostLeaveEvent e) {
				return e.getPartyPlayer();
			}
		}, 0);
		EventValues.registerEventValue(BukkitPartiesPlayerPostLeaveEvent.class, CommandSender.class, new Getter<CommandSender, BukkitPartiesPlayerPostLeaveEvent>() {
			@Override
			public CommandSender get(BukkitPartiesPlayerPostLeaveEvent e) {
				return Bukkit.getPlayer(e.getPartyPlayer().getPlayerUUID());
			}
		}, 0);
	}
}
