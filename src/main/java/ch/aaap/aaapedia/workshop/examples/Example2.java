package ch.aaap.aaapedia.workshop.examples;

import ch.aaap.aaapedia.workshop.domain.Conference;
import ch.aaap.aaapedia.workshop.services.ConferenceApi;
import reactor.core.publisher.Flux;

import java.util.List;

public class Example2 {

    public static List<Integer> CONFERENCE_IDS = List.of(1, 2, 3);

    // Using conference ids we are fetching conference details from the api
    public static Flux<Conference> conferences = Flux.fromIterable(CONFERENCE_IDS)
            .flatMap(ConferenceApi::getConference)
            .log();

    public static void main(String[] args) {
        conferences.subscribe();
    }
}
