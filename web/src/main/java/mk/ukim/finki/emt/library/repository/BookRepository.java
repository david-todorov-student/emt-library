package mk.ukim.finki.emt.library.repository;

import mk.ukim.finki.emt.library.model.Author;
import mk.ukim.finki.emt.library.model.Book;
import mk.ukim.finki.emt.library.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
    List<Book> findAllByAuthor(Author author);

    List<Book> findAllByCategory(Category category);

    Optional<Book> findByName(String name);

    void deleteByName(String name);
}
