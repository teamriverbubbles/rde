package teamriverbubbles.rde;

import org.bstats.bukkit.Metrics;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.event.HandlerList;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.event.Listener;
import teamriverbubbles.rde.Events.Player;

import java.io.File;
import java.io.IOException;

public final class Rde extends JavaPlugin implements Listener {

    private Player player;

    @Override
    public void onEnable() {
        // Plugin startup logic
        try {
            getServer().getPluginManager().registerEvents(new Player(this), this);
        } catch (IOException e) {
            e.printStackTrace();
        }
        this.saveDefaultConfig();

        Metrics metrics = new Metrics(this, 14945);

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        HandlerList.unregisterAll();
    }
}
