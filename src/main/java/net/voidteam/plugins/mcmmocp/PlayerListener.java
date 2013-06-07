package net.voidteam.plugins.mcmmocp;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

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
	//@EventHandler
	//public void onPlayerJoin(PlayerJoinEvent e)
	//{
		// May come in handy.
	//}
	
	// On mcMMO Player Level Up.
	// This will handle the skill caps for each specified group.
	@EventHandler
	public void onMcMMOPlayerLevelUp(McMMOPlayerLevelUpEvent e)
	{
		// Pull variables from the event.
		PermissionManager pex = PermissionsEx.getPermissionManager();
		Player player = e.getPlayer();
		PermissionUser peplayer = pex.getUser(player);
		String skill = e.getSkill().toString().toLowerCase();
		int skill_level = e.getSkillLevel();
		
		// Get the rank ladder the groups belong to.
		String ladder = plugin.getConfig().getString("rank-ladder");
		
		// TODO: Handle it.
		// Get group name the player is in, in the specified ladder.
		String tiergroup = peplayer.getRankLadderGroup(ladder).getName();
		// Get the cap for the current skill.
		int skillcap = plugin.getConfig().getInt("groups." + tiergroup + ".limits." + skill);
		
		
		if (skill_level < skillcap)
		{
			// Allow leveling up!
			// Maybe have something here in the future.
		}
		else
		{
			// We can't level! D:
			e.setCancelled(true);
			// TODO: Reset XP to 0 until we can think of something better to do.
			//int removexp = UserManager.getPlayer(player.getName()).getProfile().getXpToLevel(e.getSkill());
			//UserManager.getPlayer(player.getName()).getProfile().removeXp(e.getSkill(), removexp);
			//player.sendMessage(ChatColor.YELLOW + "You cannot level up. Skill cap reached.");
		}
	}
	
	// On mcMMO Player Experience Gain
	//@EventHandler
	//public void onMcMMOPlayerXpGainEvent(McMMOPlayerXpGainEvent e)
	//{
		// May come in handy.
	//}
}