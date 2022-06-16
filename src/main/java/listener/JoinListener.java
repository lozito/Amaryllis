package listener;

import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.VoiceChannel;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.managers.AudioManager;

public class JoinListener extends ListenerAdapter {

    public void onGuildMessageReceived(MessageReceivedEvent event) throws NullPointerException {
        Member member = event.getGuild().getMember(event.getMember().getUser());
        VoiceChannel channel;
        AudioManager manager = event.getGuild().getAudioManager();

        if (event.getMessage().getContentRaw().contains("-join")) {
            if (manager.isConnected()) {
                event.getChannel().sendMessage("Ya estoy en el canal.").queue();
                return;
            }
            if (event.getAuthor().isBot()) return;
            try {
                channel = (VoiceChannel) member.getVoiceState().getChannel();
                manager.openAudioConnection(channel);
                event.getChannel().sendMessage("Conectandome a `\uD83D\uDD0A " + channel.getName() + "`").queue();
            } catch (NullPointerException ex) {
                event.getChannel().sendMessage("No estás en ningún canal.").queue();
            }
        }
    }
}