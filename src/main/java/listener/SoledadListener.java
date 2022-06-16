package listener;

import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class SoledadListener extends ListenerAdapter {

    public void onGuildMessageReceived(MessageReceivedEvent event) {

        if (event.getMessage().getContentRaw().contains("-soledad")) {
            event.getChannel().sendMessage("https://tenor.com/view/spider-man-spider-man-web-of-shadows-depressed-sad-gif-16524395").queue();
        }
    }
}
