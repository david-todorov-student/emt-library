package mk.ukim.finki.emt.library.service;

import mk.ukim.finki.emt.library.model.Author;
import mk.ukim.finki.emt.library.model.Book;
import mk.ukim.finki.emt.library.model.dto.BookDto;
import mk.ukim.finki.emt.library.model.Category;

import java.util.List;
import java.util.Optional;

public interface BookService {
    List<Book> findAll();

    Optional<Book> findById(Long id);

    Optional<Book> findByName(String name);

    List<Book> listAllByAuthor(Long author);

    List<Book> listAllByCategory(Category category);

    Optional<Book> save(String name, Long author, Long categoryId, Integer availableCopies);

    Optional<Book> save(BookDto bookDto);

    Optional<Book> edit(Long id, String name, Long author, Long categoryId, Integer availableCopies);

    Optional<Book> edit(Long id, BookDto bookDto);

    void deleteById(Long id);

    void lendBook(Long id);

    void returnBook(Long id);
}
