package com.alessiodp.parties.bukkit.addons.external;

import com.alessiodp.core.bukkit.addons.external.bstats.bukkit.Metrics;
import com.alessiodp.core.common.ADPPlugin;
import com.alessiodp.core.common.addons.external.MetricsHandler;
import com.alessiodp.core.common.utils.CommonUtils;
import com.alessiodp.parties.api.Parties;
import com.alessiodp.parties.bukkit.configuration.data.BukkitConfigMain;
import com.alessiodp.parties.bukkit.configuration.data.BukkitConfigParties;
import lombok.NonNull;
import org.bukkit.plugin.Plugin;

public class BukkitMetricsHandler extends MetricsHandler {
	public BukkitMetricsHandler(@NonNull ADPPlugin plugin) {
		super(plugin);
	}
	
	@Override
	protected void registerMetrics() {
		Metrics metrics = new Metrics((Plugin) plugin.getBootstrap(), plugin.getBstatsId());
		
		metrics.addCustomChart(new Metrics.SimplePie("type_of_party_used", () -> {
			if (BukkitConfigParties.ADDITIONAL_FIXED_ENABLE)
				return "Fixed";
			return "Normal";
		}));
		
		// Config
		metrics.addCustomChart(new Metrics.SimplePie("type_of_database_used", () -> plugin.getDatabaseManager().getDatabaseType().getFormattedName()));
		
		metrics.addCustomChart(new Metrics.SimplePie("auto_command_system", () -> {
			if (BukkitConfigMain.ADDITIONAL_AUTOCMD_ENABLE)
				return "Enabled";
			return "Disabled";
		}));
		
		metrics.addCustomChart(new Metrics.SimplePie("exp_levels", () -> {
			if (BukkitConfigMain.ADDITIONAL_EXP_ENABLE && BukkitConfigMain.ADDITIONAL_EXP_LEVELS_ENABLE) {
				switch (CommonUtils.toLowerCase(BukkitConfigMain.ADDITIONAL_EXP_LEVELS_MODE)) {
					case "normal":
						return "Normal";
					case "levelpoints":
						return "LevelPoints";
					case "mmocore":
						return "MMOCore";
					case "skillapi":
						return "SkillAPI";
					default:
						return "Party";
					
				}
			}
			return "Disabled";
		}));
		
		metrics.addCustomChart(new Metrics.SimplePie("follow_system", () -> {
			if (BukkitConfigMain.ADDITIONAL_FOLLOW_ENABLE)
				return "Enabled";
			return "Disabled";
		}));
		
		metrics.addCustomChart(new Metrics.SimplePie("vault_system", () -> {
			if (BukkitConfigMain.ADDONS_VAULT_ENABLE)
				return "Enabled";
			return "Disabled";
		}));
		
		// Parties
		metrics.addCustomChart(new Metrics.SimplePie("color_system", () -> {
			if (BukkitConfigParties.ADDITIONAL_COLOR_ENABLE)
				return "Enabled";
			return "Disabled";
		}));
		
		metrics.addCustomChart(new Metrics.SimplePie("friendly_fire_system", () -> {
			if (BukkitConfigParties.ADDITIONAL_FRIENDLYFIRE_ENABLE)
				return "Enabled";
			return "Disabled";
		}));
		
		metrics.addCustomChart(new Metrics.SimplePie("home_system", () -> {
			if (BukkitConfigParties.ADDITIONAL_HOME_ENABLE)
				return "Enabled";
			return "Disabled";
		}));
		
		metrics.addCustomChart(new Metrics.SimplePie("kills_system", () -> {
			if (BukkitConfigParties.ADDITIONAL_KILLS_ENABLE)
				return "Enabled";
			return "Disabled";
		}));
		
		metrics.addCustomChart(new Metrics.SimplePie("nickname_system", () -> {
			if (BukkitConfigParties.ADDITIONAL_NICKNAME_ENABLE)
				return "Enabled";
			return "Disabled";
		}));
		
		metrics.addCustomChart(new Metrics.SimplePie("tag_system", () -> {
			if (BukkitConfigParties.ADDITIONAL_TAG_ENABLE)
				return "Enabled";
			return "Disabled";
		}));
		
		metrics.addCustomChart(new Metrics.SimplePie("teleport_system", () -> {
			if (BukkitConfigParties.ADDITIONAL_TELEPORT_ENABLE)
				return "Enabled";
			return "Disabled";
		}));
		
		// Extra
		metrics.addCustomChart(new Metrics.SimplePie("using_api", () -> {
			if (Parties.isFlagHook())
				return "Yes";
			return "No";
		}));
	}
}