package ch.aaap.aaapedia.workshop.examples;

import reactor.core.publisher.Flux;
import reactor.core.scheduler.Schedulers;

public class Example8 {

    // https://projectreactor.io/docs/core/release/reference/#advanced-parallelizing-parralelflux
    // https://projectreactor.io/docs/core/release/reference/#scheduler-factory
    public static Flux<String> numbers = Flux.range(1, 10)
            .map(i -> i * 2)
            .log()
            .publishOn(Schedulers.boundedElastic())
            .map(i -> "Result: " + i)
            .log();

    public static void main(String[] args) {
        numbers.subscribe();
    }
}
