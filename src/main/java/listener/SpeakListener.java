package listener;

import net.dv8tion.jda.api.audio.hooks.ConnectionListener;
import net.dv8tion.jda.api.entities.GuildVoiceState;
import net.dv8tion.jda.api.entities.User;
import net.dv8tion.jda.api.entities.VoiceChannel;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.managers.AudioManager;

public class SpeakListener extends ListenerAdapter {
    public void onGuildVoiceState(GuildVoiceState event) {
        VoiceChannel channel;
        User user = event.getMember().getUser();
        AudioManager manager = event.getGuild().getAudioManager();
        ConnectionListener listener = manager.getConnectionListener();

    }
}


