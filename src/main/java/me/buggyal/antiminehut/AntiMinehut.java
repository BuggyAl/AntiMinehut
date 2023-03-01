package me.buggyal.antiminehut;

import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;

public final class AntiMinehut extends JavaPlugin {

    String mhPlugin = "MinehutPlugin";
    ConsoleCommandSender console = getServer().getConsoleSender();

    @Override
    public void onEnable() {
        getServer().getScheduler().scheduleSyncDelayedTask(this, () -> {
            PluginManager pluginManager = getServer().getPluginManager();
            if (!pluginManager.isPluginEnabled(mhPlugin) || pluginManager.getPlugin(mhPlugin) == null) { return; }
            pluginManager.disablePlugin(pluginManager.getPlugin(mhPlugin));
            console.sendMessage("§4[AntiMinehut] §cDisabled plugin: " + "MinehutCosmetics");
            File minehut = new File("plugins/MinehutCosmetics.jar");
            if (!minehut.delete()) {
                console.sendMessage("§5[AntiMinehut] §dCould not delete " + minehut.getName());
            }
        });
        getServer().getPluginManager().disablePlugin(this);
    }

    @Override
    public void onDisable() {
        console.sendMessage("§2[AntiMinehut] §aAntiMinehut has been disabled!");
    }

}
