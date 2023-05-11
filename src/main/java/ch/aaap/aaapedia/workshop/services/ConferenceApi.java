package ch.aaap.aaapedia.workshop.services;

import ch.aaap.aaapedia.workshop.domain.Conference;
import ch.aaap.aaapedia.workshop.domain.Presentation;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

public class ConferenceApi {

    public static int conferenceYear = 2021;

    public static Mono<Conference> getConference(int id) {
        return Mono.just(new Conference(id, "Conference " + id, List.of()));
    }

    public static Mono<List<Presentation>> getPresentations(int conferenceId) {
        return Flux.just(
                new Presentation(1, "Spring", "Nikol"),
                new Presentation(1, "React", "Tom"),
                new Presentation(1, "Chat GPT", "Michael")
        ).collectList();
    }

    public static Mono<Void> update3apediaYear(int year) {
        conferenceYear = year;
        return Mono.empty();
    }

    public static Mono<Integer> get3apediaYear() {
        return Mono.just(conferenceYear);
    }
}
