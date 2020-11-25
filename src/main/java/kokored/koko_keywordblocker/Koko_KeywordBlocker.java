package kokored.koko_keywordblocker;

import kokored.koko_keywordblocker.events.KeywordBlocker;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.java.JavaPlugin;

public final class Koko_KeywordBlocker extends JavaPlugin {

    @Override
    public void onEnable() {
        System.out.println("Koko_KeywordBlocker has enabled");
        getConfig().options().copyDefaults();
        saveDefaultConfig();

        getServer().getPluginManager().registerEvents(new KeywordBlocker(),this);

    }

    @Override
    public void onDisable() {
        System.out.println("Koko_KeywordBlocker has disabled");

    }

}
