package ru.netology.repository;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.TShirt;
import ru.netology.exceptions.NotFoundException;

import javax.swing.*;

import static org.junit.jupiter.api.Assertions.*;

class ProductRepositoryTest {
    private static Book first = new Book(1, "Dracula", 1000, "Bram Stoker", 300, 2000);
    private static Book second = new Book(2, "The Picture of Dorian Gray", 900, "Oscar Wilde", 400, 2010);
    private static Book third = new Book(3, "Three Men In a Boat", 600, "Jerome K. Jerome", 250, 2021);
    private static TShirt fourth = new TShirt(4, "Nike", 2000, "black", "M");
    private static TShirt fifth = new TShirt(5, "Adidas", 2500, "white", "S");
    private static TShirt sixth = new TShirt(6, "Puma", 1900, "red", "L");

    static ProductRepository repository = new ProductRepository();
    @BeforeAll
    public static void init(){
        repository.save(first);
        repository.save(second);
        repository.save(third);
        repository.save(fourth);
        repository.save(fifth);
        repository.save(sixth);
        System.out.println(repository);
    }


    @Test
    public void shouldDeleteById() {

        repository.removeById(2);
        Product actual = repository.findById(2);
        Product expected = null;

        assertEquals(actual,expected);
    }
    @Test
    public void shouldNotDeleteById() {

        assertThrows(NotFoundException.class, () -> {
                repository.removeById(9);
        });
    }

}