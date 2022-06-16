import listener.*;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.Activity;
import tracker.ActivityTracker;

import javax.security.auth.login.LoginException;

public class Amaryllis {
    public static void main(String[] args) throws LoginException, InterruptedException {
        JDA amaryllis = JDABuilder.createDefault("ODQxMTI1NTI3OTc1NzU1ODI2.YJiNMQ.nTK4Sebelg4k_voGm5XfF8b1dMI").build();
        amaryllis.awaitReady();
        amaryllis.getPresence().setActivity(Activity.streaming("-help", "https://www.twitch.tv/laucha238"));

        //listeners
        amaryllis.addEventListener(new GuildInfoListener());
        amaryllis.addEventListener(new JoinListener());
        amaryllis.addEventListener(new AvatarClass());
        amaryllis.addEventListener(new AhegaoListener());
        amaryllis.addEventListener(new SoledadListener());
        amaryllis.addEventListener(new SpeakListener());
        amaryllis.addEventListener(new ActivityTracker());
        amaryllis.addEventListener(new SpamListener());
    }
}
