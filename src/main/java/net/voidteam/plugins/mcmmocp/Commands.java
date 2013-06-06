package net.voidteam.plugins.mcmmocp;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

// Command Executor Class.
public class Commands implements CommandExecutor
{
	private final McMMOCapLimit plugin;		// Plugin instance.

	// Constructor.
	Commands(McMMOCapLimit instance)
	{
		plugin = instance;
	}
	
	// On Command. Handles all commands.
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args)
	{
		// /mcmmocl
		if (cmd.getName().equalsIgnoreCase("mcmmocl"))
		{
			// /mcmmocl, /mcmmocl version, /mcmmocl info
			if (args.length == 0 || args[0].equalsIgnoreCase("version") || args[0].equalsIgnoreCase("info"))
			{
				// TODO: Display Version.

				return true;
			}
			// /mcmmocl reload
			else if (args[0].equalsIgnoreCase("reload") && sender.hasPermission("mcmmocl.reload"))
			{
				plugin.reloadConfiguration();
				sender.sendMessage(ChatColor.GREEN + "[mcMMOCapLimit] Configuration reloaded.");

				return true;
			}
		}
		
		return false;
	}
}