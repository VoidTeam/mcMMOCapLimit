package net.voidteam.plugins.mcmmocp;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import ru.tehkode.permissions.PermissionManager;
import ru.tehkode.permissions.PermissionUser;
import ru.tehkode.permissions.bukkit.PermissionsEx;

import com.gmail.nossr50.events.experience.McMMOPlayerLevelUpEvent;

// Player Listener Class.
public class PlayerListener implements Listener
{
	private final McMMOCapLimit plugin;		// Plugin instance.
	
	// Constructor.
	public PlayerListener(McMMOCapLimit instance)
	{
		plugin = instance;
	}
	
	// On Player Join. For Debugging.
	@EventHandler
	public void onPlayerJoin(PlayerJoinEvent e)
	{
		PermissionManager pex = PermissionsEx.getPermissionManager();
		Player player = e.getPlayer();
		PermissionUser peplayer = pex.getUser(player);
		String[] groups = peplayer.getGroupsNames();
		
		// Display player's PEX groups.
		for (String str : groups)
		{
			player.sendMessage(str);
		}
	}
	
	// On mcMMO Player Level Up.
	// This will handle the skill caps for each specified group.
	@EventHandler
	public void onMcMMOPlayerLevelUp(McMMOPlayerLevelUpEvent e)
	{
		// Pull variables.
		PermissionManager pex = PermissionsEx.getPermissionManager();
		Player player = e.getPlayer();
		PermissionUser peplayer = pex.getUser(player);
		int skill_level = e.getSkillLevel();
		String[] groups = peplayer.getGroupsNames();
		
		// TODO: Handle it.
	}
}