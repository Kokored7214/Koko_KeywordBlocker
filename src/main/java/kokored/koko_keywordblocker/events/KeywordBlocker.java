package kokored.koko_keywordblocker.events;

import kokored.koko_keywordblocker.Koko_KeywordBlocker;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.plugin.Plugin;

public class KeywordBlocker implements Listener {
    Plugin plugin = Koko_KeywordBlocker.getPlugin(Koko_KeywordBlocker.class);
    @EventHandler
    public void ChatEvent(AsyncPlayerChatEvent event){
        Player p = (Player)  event.getPlayer();

        int x = p.getLocation().getBlockX();
        int y = p.getLocation().getBlockY();
        int z = p.getLocation().getBlockZ();
        if (!p.hasPermission("kokokeywordblocker.bypass")) {
            if (plugin.getConfig().getBoolean("enable")) {
                for (int i = 0 ; i < plugin.getConfig().getStringList("keyword").size() ; i++){

                    String message = event.getMessage();

                    if (message.contains(plugin.getConfig().getStringList("keyword").get(i))){
                        event.setCancelled(true);
                        p.sendMessage(ChatColor.translateAlternateColorCodes('&', "" + plugin.getConfig().getString("blockmessage").toString()));
                        System.out.println("[Koko_KeywordBlocker] -------------------------------------------------------------------");
                        System.out.println("[Koko_KeywordBlocker] Player " + p.getDisplayName() + " send a blocked message!");
                        System.out.println("[Koko_KeywordBlocker] Message content: " + message);
                        System.out.println("[Koko_KeywordBlocker] Player at: " + " world:" + p.getLocation().getWorld().getName() + " X:" + x + " Y:" + y + " Z:" + z);
                        System.out.println("[Koko_KeywordBlocker] -------------------------------------------------------------------");

                        for (Player op : Bukkit.getOnlinePlayers()) {

                            if (op.isOp()) {
                                op.sendMessage(ChatColor.translateAlternateColorCodes('&', "" + plugin.getConfig().getString("adminmessage")
                                        .replace("%player%", "" + p.getName()
                                        .replace("%location%", "X:" + x + " Y:" + y + " Z:" + z))));
                                op.sendMessage(ChatColor.YELLOW + "Please check the console");

                            }
                        }

                    }
                }
            }
        }
    }
}
