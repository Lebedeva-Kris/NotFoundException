package ru.netology.repository;

import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.TShirt;

import static org.junit.jupiter.api.Assertions.*;

class ProductRepositoryTest {
    private ProductRepository repository = new ProductRepository();
    private Book coreJava = new Book();
    private TShirt tShirt = new TShirt();

    @Test
    public void shouldSaveOneItem(){
        repository.save(coreJava);
        repository.save(tShirt);

        Product[] expected = new Product[]{coreJava, tShirt};
        Product[] actual = repository.findAll();

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldCastFromBookClass(){
        Product product = new Book();
        if (product instanceof Book) {
            Book book = (Book) product;
        }
    }

}