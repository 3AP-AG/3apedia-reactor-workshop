package ch.aaap.aaapedia.workshop.examples;

import org.junit.jupiter.api.Test;
import reactor.test.StepVerifier;

class Example1Test {

    @Test
    void evaluationExecution() {
        StepVerifier.create(Example1.refresh3apediaYear()).expectNext(
                2023
        ).verifyComplete();
    }
}