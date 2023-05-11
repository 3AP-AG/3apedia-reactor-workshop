package ch.aaap.aaapedia.workshop.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class MutablePresentation {
    private int id;
    private String title;
    private String speaker;
}
