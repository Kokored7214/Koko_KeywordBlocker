package kokored.koko_keywordblocker;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class KeyWordListCmd implements CommandExecutor {

    public KeyWordListCmd() {
        Bukkit.getPluginCommand("klist").setExecutor(this);
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender.hasPermission("kokokeywordblocker.list")) {


        }

        return false;
    }
}
