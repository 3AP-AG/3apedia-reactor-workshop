package ch.aaap.aaapedia.workshop.examples;

import reactor.core.publisher.Flux;

import java.time.Duration;
import java.util.Random;

public class Example6 {

    public static Flux<String> simpleGroupFlux = Flux.just("Alex","Anakin", "John",  "Bob", "Jimmy")
            .groupBy(name -> name.substring(0, 1))
            .flatMap(group -> group.collectList().map(list -> String.format("%s %s", group.key(), list)));

    public static Flux<String> groupFlux = Flux.interval(Duration.ofMillis(500))
            .take(10)
            .map(__ -> new Random().nextInt(1000))
            .groupBy(i -> i % 2 == 0 ? "even" : "odd")
            .flatMap(group -> group.map(i -> group.key() + ": " + i));

    public static void main(String[] args) throws InterruptedException {
        simpleGroupFlux.subscribe(System.out::println);
    }
}
