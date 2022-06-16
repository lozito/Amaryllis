package listener;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import java.awt.*;


public class AvatarClass extends ListenerAdapter {
    private String generateAvatarUrl(Member member1) {
        String avatarUrl = member1.getUser().getEffectiveAvatarUrl();
        String[] parts = avatarUrl.split("\\.");

        String extension = parts[parts.length - 1];

        return avatarUrl + "?size=1024&." + extension;
    }

    public void onGuildMessageReceived(MessageReceivedEvent event) {
        try {
            Member member = event.getMessage().getMentionedMembers().get(0);
            String avatar = generateAvatarUrl(member);
            if (event.getMessage().getContentRaw().contains("-avatar")) {
                event.getMessage().delete().queue();
                EmbedBuilder builder = new EmbedBuilder()
                        .setColor(Color.YELLOW)
                        .setAuthor(member.getUser().getName() + "'s profile picture")
                        .setImage(avatar);
                event.getChannel().sendMessage((CharSequence) builder.build()).complete();
            }
        } catch (Exception ex) {

        }
        // event.getChannel().sendMessage(avatar).queue();
    }
}
