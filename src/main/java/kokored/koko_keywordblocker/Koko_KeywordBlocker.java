package kokored.koko_keywordblocker;

import kokored.koko_keywordblocker.events.KeywordBlocker;
import org.bukkit.plugin.java.JavaPlugin;

public final class Koko_KeywordBlocker extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        getConfig().options().copyDefaults();
        saveDefaultConfig();

        getServer().getPluginManager().registerEvents(new KeywordBlocker(),this);

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
