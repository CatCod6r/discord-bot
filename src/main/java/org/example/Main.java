package org.example;


import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import io.github.cdimascio.dotenv.Dotenv;
import io.github.cdimascio.dotenv.DotenvException;

public class Main {
    public static void main(String[] arguments) throws Exception {
        Dotenv dotenv = Dotenv.configure()
                .filename("env")
                .load();
       JDA api = JDABuilder.createDefault(dotenv.get("BOT_TOKEN")).build();

    }
}