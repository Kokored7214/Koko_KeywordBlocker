package kokored.koko_keywordblocker.events;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class Chat implements Listener {
    @EventHandler
    public void chat(AsyncPlayerChatEvent event){
        if (event.getMessage().contains("sb")){
            event.setCancelled(true);
            Player player = event.getPlayer();
            player.sendMessage(ChatColor.RED + "請注意用詞!");
        }
        if (event.getMessage().contains("sp")){
            event.setCancelled(true);
            Player player = event.getPlayer();
            player.sendMessage(ChatColor.RED + "請注意用詞!");
        }
        if (event.getMessage().contains("gun")){
            event.setCancelled(true);
            Player player = event.getPlayer();
            player.sendMessage(ChatColor.RED + "請注意用詞!");
        }
    }
}
