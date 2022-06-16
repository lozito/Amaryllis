package tracker;

import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.events.user.UserActivityStartEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class ActivityTracker extends ListenerAdapter {

    public void onUserActivityStart(UserActivityStartEvent event) {
        if (event.getUser().getName().contains("la concha de tu prima")) {
            if (event.getNewActivity().getType().equals(Activity.ActivityType.LISTENING)) {
                event.getUser().openPrivateChannel().queue();

            }
        }
    }
}
