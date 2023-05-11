package ch.aaap.aaapedia.workshop.examples;

import ch.aaap.aaapedia.workshop.domain.Presentation;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class Example5 {

    public static Flux<Presentation> zipFlux = Flux.just(new Presentation(1, "Awesome AI", ""),
                        new Presentation(2, "Machine learning", ""),
                        new Presentation(3, "Modern Web", ""))
                .zipWith(Flux.just(
                        "Nikol", "Miki"
                ))
                .map(tuple -> {
                    var presentation = tuple.getT1();
                    var speaker = tuple.getT2();
                    return new Presentation(presentation.id(), presentation.title(), speaker);
                })
                .log();

    public static void main(String[] args) {
        zipFlux.subscribe();
    }
}
