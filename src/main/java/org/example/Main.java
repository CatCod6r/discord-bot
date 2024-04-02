package org.example;


import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import io.github.cdimascio.dotenv.Dotenv;
import net.dv8tion.jda.api.OnlineStatus;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.requests.GatewayIntent;
import org.example.events.PingEvent;

public class Main {
    public static void main(String[] arguments)throws InterruptedException{
        Dotenv dotenv = Dotenv.configure()
                .filename("env")
                .load();

       JDA api = JDABuilder.createDefault(dotenv.get("BOT_TOKEN"), GatewayIntent.GUILD_MESSAGES, GatewayIntent.MESSAGE_CONTENT, GatewayIntent.GUILD_MEMBERS)
               .setStatus(OnlineStatus.ONLINE)
               .setActivity(Activity.playing("IntelliJ IDEA"))
               .build().awaitReady();
        api.addEventListener(new PingEvent());
//        api.addEventListener(new CommandEvent());
    }
}
