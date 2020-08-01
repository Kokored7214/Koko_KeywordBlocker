package kokored.koko_keywordblocker.events;

import kokored.koko_keywordblocker.Koko_KeywordBlocker;
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
        Player player = (Player)  event.getPlayer();
        String message = event.getMessage();

        int x = player.getLocation().getBlockX();
        int y = player.getLocation().getBlockY();
        int z = player.getLocation().getBlockZ();

        if (plugin.getConfig().getBoolean("enable")) {
            for (int i = 0 ; i < plugin.getConfig().getStringList("keyword").size() ; i++){
                if (message.contains(plugin.getConfig().getStringList("keyword").get(i))){
                    event.setCancelled(true);
                    player.sendMessage(ChatColor.RED + "該用詞遭到屏蔽 無法發出!");
                    player.sendMessage(ChatColor.RED + "The word is blocked, cannot be sent!");
                    System.out.println("[Koko_KeywordBlocker] -------------------------------------------------------------------");
                    System.out.println("[Koko_KeywordBlocker] Player " + player.getDisplayName() + " sent a blocked message!");
                    System.out.println("[Koko_KeywordBlocker] Message content: " + message);
                    System.out.println("[Koko_KeywordBlocker] Player at: " + " world:" + player.getLocation().getWorld().getName() + " X:" + x + " Y:" + y + " Z:" + z);
                    System.out.println("[Koko_KeywordBlocker] Player's login IP: " + player.getAddress());
                    System.out.println("[Koko_KeywordBlocker] -------------------------------------------------------------------");
                }
            }
        }
    }
}
