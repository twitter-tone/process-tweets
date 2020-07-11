package twitter.process;

import io.smallrye.reactive.messaging.annotations.Broadcast;
import org.eclipse.microprofile.reactive.messaging.Incoming;
import org.eclipse.microprofile.reactive.messaging.Outgoing;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class ProcessTweets {

    @Incoming("tweets")
    @Outgoing("tone")
    @Broadcast
    public String process(String tweet) {
        System.out.println("The incoming tweet is: " + tweet);
        return "Happy";
    }
}
