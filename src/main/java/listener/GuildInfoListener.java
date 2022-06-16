package listener;


import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import java.awt.*;
import java.time.format.DateTimeFormatter;

public class GuildInfoListener extends ListenerAdapter {

    public void onGuildMessageReceived(MessageReceivedEvent event) throws NullPointerException {

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        Guild guild = event.getGuild();

        if (!(event.getMessage().getAuthor().getId().contains("256491425481359360"))) return;
        if (event.getMessage().getContentRaw().contains("-guild info")) {
            try {
                EmbedBuilder builder = new EmbedBuilder()
                        .setColor(Color.YELLOW)
                        .setThumbnail(guild.getIconUrl())
                        .setAuthor("Information on " + guild.getName(), guild.getIconUrl())
                        .addField("Created on:", guild.getTimeCreated().format(dtf), true)
                        .addField("Owner:", "" + guild.getOwner().getUser().getName() + "#" + guild.getOwner().getUser().getDiscriminator(), true)
                        .addField("Members:", String.valueOf(guild.getMemberCount()), true)
                        .addField("Guild ID:", guild.getId(), true)
                        .addField("Number of boosters:", String.valueOf(guild.getBoostCount()), true);
                event.getChannel().sendMessage((Message) builder.build()).complete();
            } catch (NullPointerException ex) {
                event.getChannel().sendMessage("Oops! It seems that something went wrong!\nException: " + ex).queue();
            }
        }
    }
}
