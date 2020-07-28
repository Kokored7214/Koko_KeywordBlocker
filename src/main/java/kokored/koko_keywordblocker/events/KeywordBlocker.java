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

        for (int i = 0 ; i < plugin.getConfig().getStringList("keyword").size() ; i++){
            if (message.contains(plugin.getConfig().getStringList("keyword").get(i))){
                event.setCancelled(true);
                player.sendMessage(ChatColor.RED + "該用詞遭到屏蔽 無法發出!");
                player.sendMessage(ChatColor.RED + "The word is blocked, cannot be sent!");
            }
        }
    }
}
