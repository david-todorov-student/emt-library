package mk.ukim.finki.emt.library.service.impl;

import mk.ukim.finki.emt.library.model.Author;
import mk.ukim.finki.emt.library.model.Book;
import mk.ukim.finki.emt.library.model.dto.BookDto;
import mk.ukim.finki.emt.library.model.Category;
import mk.ukim.finki.emt.library.model.exceptions.AuthorNotFoundException;
import mk.ukim.finki.emt.library.model.exceptions.BookNotFoundException;
import mk.ukim.finki.emt.library.model.exceptions.CategoryDoesNotExistException;
import mk.ukim.finki.emt.library.repository.AuthorRepository;
import mk.ukim.finki.emt.library.repository.BookRepository;
import mk.ukim.finki.emt.library.repository.CategoryRepository;
import mk.ukim.finki.emt.library.service.BookService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;
    private final CategoryRepository categoryRepository;

    public BookServiceImpl(BookRepository bookRepository, AuthorRepository authorRepository, CategoryRepository categoryRepository) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
        this.categoryRepository = categoryRepository;
    }

    @Override
    public List<Book> findAll() {
        return this.bookRepository.findAll();
    }

    @Override
    public Optional<Book> findById(Long id) {
        return this.bookRepository.findById(id);
    }

    @Override
    public Optional<Book> findByName(String name) {
        return this.bookRepository.findByName(name);
    }

    @Override
    public List<Book> listAllByAuthor(Long authorId) {
        Author author = this.authorRepository.findById(authorId)
                .orElseThrow(AuthorNotFoundException::new);

        return this.bookRepository.findAllByAuthor(author);
    }

    @Override
    public List<Book> listAllByCategory(Category category) {
        return this.bookRepository.findAllByCategory(category);
    }

    @Override
    @Transactional
    public Optional<Book> save(String name, Long authorId, Long categoryId, Integer availableCopies) {
        Author author = this.authorRepository.findById(authorId)
                .orElseThrow(AuthorNotFoundException::new);
        Category category = this.categoryRepository.findById(categoryId)
                .orElseThrow(CategoryDoesNotExistException::new);

        this.bookRepository.deleteByName(name);
        Book book = new Book(name, author, category, availableCopies);
        this.bookRepository.save(book);
        return Optional.of(book);
    }

    @Override
    public Optional<Book> save(BookDto bookDto) {
        Author author = this.authorRepository.findById(bookDto.getAuthor())
                .orElseThrow(AuthorNotFoundException::new);

        Category category = this.categoryRepository.findById(bookDto.getCategory())
                .orElseThrow(CategoryDoesNotExistException::new);

        this.bookRepository.deleteByName(bookDto.getName());
        Book book = new Book(bookDto.getName(), author, category, bookDto.getAvailableCopies());
        this.bookRepository.save(book);
        return Optional.of(book);
    }

    @Override
    @Transactional
    public Optional<Book> edit(Long id, String name, Long authorId, Long categoryId, Integer availableCopies) {
        Author author = this.authorRepository.findById(authorId)
                .orElseThrow(AuthorNotFoundException::new);

        Book book = this.bookRepository.findById(id)
                .orElseThrow(BookNotFoundException::new);

        Category category = this.categoryRepository.findById(categoryId)
                .orElseThrow(CategoryDoesNotExistException::new);

        book.setName(name);
        book.setAuthor(author);
        book.setCategory(category);
        book.setAvailableCopies(availableCopies);

        this.bookRepository.save(book);

        return Optional.of(book);
    }

    @Override
    public Optional<Book> edit(Long id, BookDto bookDto) {
        Author author = this.authorRepository.findById(bookDto.getAuthor())
                .orElseThrow(AuthorNotFoundException::new);

        Book book = this.bookRepository.findById(id)
                .orElseThrow(BookNotFoundException::new);

        Category category = this.categoryRepository.findById(bookDto.getCategory())
                .orElseThrow(CategoryDoesNotExistException::new);

        book.setName(bookDto.getName());
        book.setAuthor(author);
        book.setCategory(category);
        book.setAvailableCopies(bookDto.getAvailableCopies());

        this.bookRepository.save(book);

        return Optional.of(book);    }

    @Override
    public void deleteById(Long id) {
        this.bookRepository.deleteById(id);
    }

    @Override
    @Transactional
    public void lendBook(Long id) {
        Book book = this.findById(id).orElseThrow(BookNotFoundException::new);
        book.lendCopy();
        this.bookRepository.save(book);
    }

    @Override
    @Transactional
    public void returnBook(Long id) {
        Book book = this.findById(id).orElseThrow(BookNotFoundException::new);
        book.returnCopy();
        this.bookRepository.save(book);
    }
}
