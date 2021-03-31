package mk.ukim.finki.emt.library.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import mk.ukim.finki.emt.library.model.Country;

import javax.persistence.ManyToOne;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AuthorDto {
    private String name;

    private String surname;

    private Long country;
}
