package org.example.events.command;

import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class CommandEvent extends ListenerAdapter {
    @Override
    public void onMessageReceived(MessageReceivedEvent e) {
        String[] message = e.getMessage().getContentRaw().split(" ");
        if(message.length == 1 && message[0].equalsIgnoreCase("!calculate")){
            e.getChannel().sendMessage("To use this command type(without brackets): !calculate [add/sub] [first-num] [second-num]").queue();
        }else if(message[0].equalsIgnoreCase("!calculate") && message[1].equalsIgnoreCase("add")){
            int num1 = Integer.parseInt(message[2]);
            int num2 = Integer.parseInt(message[3]);
            e.getChannel().sendMessage("The Result is: " + (num1 + num2)).queue();
        }else if(message[0].equalsIgnoreCase("!calculate") && message[1].equalsIgnoreCase("sub")){
            int num1 = Integer.parseInt(message[2]);
            int num2 = Integer.parseInt(message[3]);
            e.getChannel().sendMessage("The Result is: " + (num1 - num2)).queue();
        }
    }
}
