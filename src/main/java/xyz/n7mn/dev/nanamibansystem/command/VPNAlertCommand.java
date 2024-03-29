package xyz.n7mn.dev.nanamibansystem.command;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import xyz.n7mn.dev.nanamibansystem.util.VPNAlertData;

public class VPNAlertCommand implements CommandExecutor {


    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (sender instanceof Player){
            Player player = (Player) sender;
            if (!player.isOp()){
                return true;
            }

            if (VPNAlertData.get(player.getUniqueId())){
                VPNAlertData.set(player.getUniqueId(), false);
                player.sendMessage(ChatColor.YELLOW + "[ななみ鯖] "+ChatColor.RESET+"Proxy/VPN接続試行通知をオフにしました。");
                return true;
            }

            VPNAlertData.set(player.getUniqueId(), true);
            player.sendMessage(ChatColor.YELLOW + "[ななみ鯖] "+ChatColor.RESET+"Proxy/VPN接続試行通知をオンにしました。");
        }

        return true;
    }
}
