package mk.ukim.finki.emt.library.service;

import mk.ukim.finki.emt.library.model.Author;
import mk.ukim.finki.emt.library.model.Country;
import mk.ukim.finki.emt.library.model.dto.CountryDto;

import java.util.List;
import java.util.Optional;

public interface AuthorService {

    List<Author> listAll();

    Optional<Author> findById(Long id);

}
