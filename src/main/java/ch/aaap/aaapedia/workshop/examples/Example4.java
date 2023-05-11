package ch.aaap.aaapedia.workshop.examples;

import ch.aaap.aaapedia.workshop.domain.MutablePresentation;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

import java.util.ArrayList;
import java.util.List;

public class Example4 {

    public static List<Integer> getNumbers() {
        List<Integer> numbers = new ArrayList<>();

        Flux.range(1, 5)
                .doOnNext(numbers::add)
                .subscribe();

        return numbers;
    }

    public static Flux<MutablePresentation> getPresentations() {
        return Flux.just(new MutablePresentation(1, "AI stuff", "Nikol"),
                        new MutablePresentation(2, "Web", "Miki")
                        )
                .map(presentation -> {
                    presentation.setTitle(presentation.getId() + ": Very cool " + presentation.getTitle());
                    return presentation;
                })
                .doOnNext(System.out::println);
    }

    public static void main(String[] args) {
        System.out.println("Numbers: " + getNumbers());
    }
}
