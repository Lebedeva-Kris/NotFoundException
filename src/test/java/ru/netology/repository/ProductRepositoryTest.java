package ru.netology.repository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.TShirt;
import ru.netology.exception.NotFoundException;

import static org.junit.jupiter.api.Assertions.*;

class ProductRepositoryTest {
    private ProductRepository repository = new ProductRepository();
    private Product product = new Product(1, "product", 1000);
    private Book book = new Book(2, "book", 2000, "author", 10, 2020);
    private TShirt tShirt = new TShirt(3, "tshirt", 3000, "color", "size");


    @BeforeEach
    void setUp() {
        repository.save(product);
        repository.save(book);
        repository.save(tShirt);
    }

    @Test
    public void shouldRemoveByIdIfExist(){
        repository.removeById(3);

        Product[] expected = new Product[]{product, book};
        Product[] actual = repository.findAll();

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldRemoveByIdIfNotExist(){
        assertThrows(NotFoundException.class, () -> repository.removeById(5));
    }

}