package mk.ukim.finki.emt.library.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import mk.ukim.finki.emt.library.model.Category;
import mk.ukim.finki.emt.library.model.exceptions.NoMoreAvailableCopiesException;

import javax.persistence.*;

@Data
@Entity
@NoArgsConstructor
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @ManyToOne
    private Author author;
    @ManyToOne
    private Category category;
    private Integer availableCopies;

    public Book(String name, Author author, Category category, Integer availableCopies) {
        this.name = name;
        this.author = author;
        this.category = category;
        this.availableCopies = availableCopies;
    }

    public void lendCopy(){
        if (this.availableCopies > 0){
            this.availableCopies--;
        } else {
            throw new NoMoreAvailableCopiesException(this.name);
        }
    }

    public void returnCopy(){
        this.availableCopies++;
    }
}
