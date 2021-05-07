package xyz.n7mn.dev.nanamibansystem.command;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.Plugin;
import xyz.n7mn.dev.api.Ban;

public class GlobalBanCommand implements CommandExecutor {

    private final Ban banSystem;
    private final Plugin plugin;
    public GlobalBanCommand(Ban banSystem, Plugin plugin){
        this.banSystem = banSystem;
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        new Thread(()->{
            BanRuntime.run(plugin, banSystem, "all", sender, args);
        }).start();

        return true;
    }
}
