package ch.aaap.aaapedia.workshop.examples;

import ch.aaap.aaapedia.workshop.domain.MutablePresentation;
import ch.aaap.aaapedia.workshop.domain.Presentation;
import org.junit.jupiter.api.Test;
import reactor.test.StepVerifier;

import static org.junit.jupiter.api.Assertions.*;

class Example5Test {

    @Test
    void mergeFluxes() {
        StepVerifier.create(Example5.zipFlux)
                .expectNext(
                        new Presentation(1, "Awesome AI", ""),
                        new Presentation(2, "Machine learning", "Nikol"),
                        new Presentation(3, "Modern Web", "Miki")
                )
                .verifyComplete();
    }

}