package ch.aaap.aaapedia.workshop.examples;

import ch.aaap.aaapedia.workshop.services.ConferenceApi;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class Example1 {

    public static Flux<String> get3apEvents() {
        return Flux.just(
                        "3apedia",
                        "3ap days",
                        "hackaton"
                )
                .log();
    }

    public static Mono<Integer> refresh3apediaYear() {
        return Mono.just(2023)
                .flatMap(ConferenceApi::update3apediaYear)
                .then(ConferenceApi.get3apediaYear())
                .log();
    }

    public static void main(String[] args) {
        get3apEvents();
    }
}
