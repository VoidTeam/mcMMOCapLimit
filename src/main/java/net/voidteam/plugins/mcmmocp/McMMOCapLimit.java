// Totally meant to put mcmmocl instead of mcmmocp, but too lazy to change it.
// UUUUUGGGHHHHHH
package net.voidteam.plugins.mcmmocp;

import java.io.File;

import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

// Main Class.
public class McMMOCapLimit extends JavaPlugin implements Listener
{
	// On Plugin Enable.
	@Override
	public void onEnable()
	{
		getLogger().info("Initializing...");
		
		// Create default config if it doesn't exist yet.
		if (!new File(getDataFolder(), "config.yml").exists())
		{
			saveDefaultConfig();
		}
		
		// Load configuration.
		reloadConfiguration();
		
		// Register events.
		getServer().getPluginManager().registerEvents(this, this);
		getServer().getPluginManager().registerEvents(new PlayerListener(this), this);
		
		// Register command executor.
		Commands cmdExecutor = new Commands(this);
		getCommand("mcmmocl").setExecutor(cmdExecutor);
		
		getLogger().info("Loaded!");
	}
	
	// On Plugin Disable.
	@Override
	public void onDisable()
	{
		getLogger().info("Disabling...");
		// TODO: Place any custom disable code here.
		getLogger().info("Disabled.");
	}
	
	// Reload the config.yml and associate variables/objects.
	public void reloadConfiguration()
	{
		// Standard reload.
		reloadConfig();
		// TODO: Reload other variables/objects.
	}
}