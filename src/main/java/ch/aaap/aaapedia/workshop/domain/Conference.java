package ch.aaap.aaapedia.workshop.domain;

import java.util.List;

public record Conference(int id,
                         String title,
                         List<Presentation> presentations) {
}
