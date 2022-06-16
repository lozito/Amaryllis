package listener;

import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class SpamListener extends ListenerAdapter {

    public void onGuildMessageReceived(MessageReceivedEvent event) {
        if (event.getMessage().getAuthor().getName().contains("la concha de tu prima")) {
            if (event.getMessage().getContentRaw().contains("-delete spam")) {
                event.getMessage().delete().queue();
                event.getChannel().getHistoryBefore(event.getMessage(), 5);
            }
        }
    }
}
