package net.voidteam.plugins.mcmmocp;

import java.io.File;
import java.util.Arrays;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.java.JavaPlugin;

import ru.tehkode.permissions.PermissionManager;
import ru.tehkode.permissions.PermissionUser;
import ru.tehkode.permissions.bukkit.PermissionsEx;

import com.gmail.nossr50.events.experience.McMMOPlayerLevelUpEvent;

public class McMMOCapLimit extends JavaPlugin implements Listener
{
	@Override
	public void onEnable()
	{
		// Create default config if not exist yet.
		if (!new File(getDataFolder(), "config.yml").exists())
		{
			saveDefaultConfig();
		}
		
		// Load configuration.
		
		getServer().getPluginManager().registerEvents(this, this);
	}
	
	@Override
	public void onDisable()
	{
		// TODO: Place any custom disable code here.
	}
	
	@EventHandler
	public void onPlayerJoin(PlayerJoinEvent e)
	{
		PermissionManager pex = PermissionsEx.getPermissionManager();
		Player player = e.getPlayer();
		PermissionUser peplayer = pex.getUser(player);
		String[] groups = peplayer.getGroupsNames();
		
		for (String str : groups)
		{
			player.sendMessage(str);
		}
	}
	
	@EventHandler
	public void onMcMMOPlayerLevelUp(McMMOPlayerLevelUpEvent e)
	{
		PermissionManager pex = PermissionsEx.getPermissionManager();
		// Pull variables.
		Player player = e.getPlayer();
		PermissionUser peplayer = pex.getUser(player);
		int skill_level = e.getSkillLevel();
		String[] groups = peplayer.getGroupsNames();
		// TODO: FIX IT! ALMOST THERE!
		// HAAAAAAAAARD COOOOOODE
		// Handle it.
		// Tier1
		if (skill_level >= 100 && skill_level < 250 && (Arrays.asList(groups).contains("Tier1") || Arrays.asList(groups).contains("Tier2") || Arrays.asList(groups).contains("Tier3") || Arrays.asList(groups).contains("Tier4") || Arrays.asList(groups).contains("Tier5")))
		{
			// Promote.
			e.setLevelsGained(1);
		}
		else
		{
			// Nope.
			e.setLevelsGained(0);
			player.sendMessage("Must be at least Tier 1 to level up past 100!");
		}
		
		// Tier2
		if (skill_level == 250 && skill_level < 400 && (Arrays.asList(groups).contains("Tier2") || Arrays.asList(groups).contains("Tier3") || Arrays.asList(groups).contains("Tier4") || Arrays.asList(groups).contains("Tier5")))
		{
			// Promote.
			e.setLevelsGained(1);
		}
		else
		{
			// Nope.
			e.setLevelsGained(0);
			player.sendMessage("Must be at least Tier 2 to level up past 250!");
		}
		
		// Tier3
		if (skill_level == 400 &&  skill_level < 600 && (Arrays.asList(groups).contains("Tier3") || Arrays.asList(groups).contains("Tier4") || Arrays.asList(groups).contains("Tier5")))
		{
			// Promote.
			e.setLevelsGained(1);
		}
		else
		{
			// Nope.
			e.setLevelsGained(0);
			player.sendMessage("Must be at least Tier 3 to level up past 400!");
		}
		
		// Tier4
		if (skill_level == 600 &&  skill_level < 800 && (Arrays.asList(groups).contains("Tier4") || Arrays.asList(groups).contains("Tier5")))
		{
			// Promote.
			e.setLevelsGained(1);
		}
		else
		{
			// Nope.
			e.setLevelsGained(0);
			player.sendMessage("Must be at least Tier 4 to level up past 600!");
		}
		
		// Tier5
		if (skill_level == 800 &&  skill_level < 1000 && (Arrays.asList(groups).contains("Tier5")))
		{
			// Promote.
			e.setLevelsGained(1);
		}
		else
		{
			// Nope.
			e.setLevelsGained(0);
			player.sendMessage("Must be at least Tier 5 to level up past 800!");
		}
	}
}