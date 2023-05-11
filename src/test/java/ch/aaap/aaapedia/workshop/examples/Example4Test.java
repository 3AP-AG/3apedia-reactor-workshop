package ch.aaap.aaapedia.workshop.examples;

import ch.aaap.aaapedia.workshop.domain.MutablePresentation;
import org.junit.jupiter.api.Test;
import reactor.test.StepVerifier;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Example4Test {

    @Test
    void listSize() {
        assertEquals(5, Example4.getNumbers().size());
    }

    @Test
    void mutatePresentation() {
        StepVerifier.create(Example4.getPresentations())
                .expectNext(
                        new MutablePresentation(1, "1: Very cool AI stuff", "Nikol"),
                        new MutablePresentation(2, "2: Very cool Web", "Miki")
                )
                .verifyComplete();
    }


}