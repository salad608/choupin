import events.MessageEventListener;
import events.ReadyEventListener;
import events.*;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.requests.GatewayIntent;

import javax.security.auth.login.LoginException;

public class DiscordBot {
    public static void main(String[] args) throws LoginException {

        final String TOKEN = "";
        JDABuilder jdaBuilder = JDABuilder.createDefault(TOKEN);
        JDA jda = jdaBuilder
                .enableIntents(GatewayIntent.MESSAGE_CONTENT, GatewayIntent.GUILD_MESSAGES)
                .addEventListeners(new InteractionEventListener(), new ButtonKeys())
                .build();
    
       jda.upsertCommand("play","allows for more user input in virtual piano").setGuildOnly(true).queue();
       jda.upsertCommand("help","tutorial for using piano bot").setGuildOnly(true).queue();
    }
}
