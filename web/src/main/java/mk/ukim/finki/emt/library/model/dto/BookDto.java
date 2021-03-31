package mk.ukim.finki.emt.library.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import mk.ukim.finki.emt.library.model.enumerations.Category;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookDto {
    private String name;

    private Long author;

    private Long category;

    private Integer availableCopies;
}
