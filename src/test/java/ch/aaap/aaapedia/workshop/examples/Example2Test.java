package ch.aaap.aaapedia.workshop.examples;

import ch.aaap.aaapedia.workshop.domain.Conference;
import org.junit.jupiter.api.Test;
import reactor.test.StepVerifier;

import java.util.List;

class Example2Test {

    @Test
    void conferencesList() {
        StepVerifier.create(Example2.conferences).expectNext(
                new Conference(1, "Conference 1", List.of()),
                new Conference(2, "Conference 2", List.of()),
                new Conference(3, "Conference 3", List.of())
        ).verifyComplete();
    }
}