package kokored.koko_keywordblocker;

import kokored.koko_keywordblocker.events.Chat;
import org.bukkit.plugin.java.JavaPlugin;

public final class Koko_KeywordBlocker extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        getServer().getPluginManager().registerEvents(new Chat(),this);

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
