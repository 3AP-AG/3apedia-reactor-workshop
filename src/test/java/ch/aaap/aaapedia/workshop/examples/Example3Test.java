package ch.aaap.aaapedia.workshop.examples;

import ch.aaap.aaapedia.workshop.domain.Conference;
import ch.aaap.aaapedia.workshop.domain.Presentation;
import org.junit.jupiter.api.Test;
import reactor.test.StepVerifier;

import java.util.List;

class Example3Test {

    @Test
    void masterDetail() {
        StepVerifier.create(Example3.conferencesWithPresentations).expectNext(
                new Conference(1, "3apedia", List.of(
                        new Presentation(1, "Spring", "Nikol"),
                        new Presentation(1, "React", "Tom"),
                        new Presentation(1, "Chat GPT", "Michael")
                ))
        ).verifyComplete();
    }

}