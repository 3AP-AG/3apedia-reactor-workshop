package ch.aaap.aaapedia.workshop.examples;

import ch.aaap.aaapedia.workshop.domain.Conference;
import reactor.core.publisher.Flux;

import java.util.List;

public class Example3 {

    // Using ConferenceApi.getPresentations return conference with updated presentations list.
    public static Flux<Conference> conferencesWithPresentations = Flux.just(new Conference(1, "3apedia", List.of()))
            .log();

    public static void main(String[] args) {
        conferencesWithPresentations.subscribe();
    }
}
