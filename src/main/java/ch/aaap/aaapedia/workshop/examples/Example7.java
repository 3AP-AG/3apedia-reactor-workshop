package ch.aaap.aaapedia.workshop.examples;

import reactor.core.publisher.Flux;
import reactor.core.scheduler.Schedulers;
import reactor.util.retry.Retry;

import java.time.Duration;
import java.util.Random;

public class Example7 {


    public static void main(String[] args) {
        Flux<Integer> flux = Flux.just(1, 2, 3, 4)
                .flatMap(number -> performTask(number))
                .retryWhen(Retry.backoff(3, Duration.ofSeconds(2))
                        .jitter(0.75)
                )
                .log();

        flux.subscribe(
                System.out::println,
                error -> System.out.println("Error")
        );

        flux.blockLast();
    }

    private static Flux<Integer> performTask(int number) {
        // Simulating a task that fails for numbers greater than 2
        if (number > 2) {
            return Flux.error(new RuntimeException("Task failed for number: " + number));
        } else {
            return Flux.just(number);
        }
    }
}
