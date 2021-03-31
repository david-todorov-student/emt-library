package mk.ukim.finki.emt.library.service;

import mk.ukim.finki.emt.library.model.Category;

import java.util.List;
import java.util.Optional;

public interface CategoryService {
    List<Category> findAll();

    Optional<Category> findById(Long id);

}
