package twitter.process;

import io.smallrye.reactive.messaging.annotations.Broadcast;

import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.eclipse.microprofile.reactive.messaging.Incoming;
import org.eclipse.microprofile.reactive.messaging.Outgoing;

import javax.enterprise.context.ApplicationScoped;
import javax.json.bind.Jsonb;
import javax.json.bind.JsonbBuilder;

import com.ibm.cloud.sdk.core.security.Authenticator;
import com.ibm.cloud.sdk.core.security.IamAuthenticator;
import com.ibm.watson.tone_analyzer.v3.*;
import com.ibm.watson.tone_analyzer.v3.model.ToneAnalysis;
import com.ibm.watson.tone_analyzer.v3.model.ToneOptions;

@ApplicationScoped
public class ProcessTweets {

    @ConfigProperty(name = "watson.url")
    String url;

    @ConfigProperty(name = "watson.token")
    String token;

    @Incoming("tweets")
    @Outgoing("tone")
    @Broadcast
    public String process(String tweet) {

        Authenticator authenticator = new IamAuthenticator(token);
        ToneAnalyzer service = new ToneAnalyzer("2017-09-21", authenticator);

        service.setServiceUrl(url);

        // Call the service and get the tone
        ToneOptions toneOptions = new ToneOptions.Builder()
        .text(tweet)
        .build();

        ToneAnalysis tone = service.tone(toneOptions).execute().getResult();
        System.out.println("The incoming tweet is: " + tweet);

        String resp = tone.toString();

        Jsonb jsonb = JsonbBuilder.create();
        ToneResponse response = jsonb.fromJson(resp, ToneResponse.class);
        
        String tweetTone = response.tone.tones[0].getTone();

        System.out.println("Tone of tweet is:  " + tweetTone);
        return tweetTone;
    }
}
