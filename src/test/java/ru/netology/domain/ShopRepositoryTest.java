package ru.netology.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ShopRepositoryTest {

    @Test
    public void testRemoveWhenProductExist() {
        ShopRepository repo = new ShopRepository();
        Product product1 = new Product(145, "Хлеб", 45);
        Product product2 = new Product(23, "Молоко", 82);
        Product product3 = new Product(43, "Масло", 198);
        Product product4 = new Product(56, "Сыр", 230);
        Product product5 = new Product(6, "Тесто", 250);

        repo.add(product1);
        repo.add(product2);
        repo.add(product3);
        repo.add(product4);
        repo.add(product5);

        repo.removeById(56);

        Product[] actual = repo.findAll();
        Product[] expected = {product1, product2, product3, product5};

        Assertions.assertArrayEquals(expected, actual);

    }

    @Test
    public void testRemoveWhenProductNotExist() {
        ShopRepository repo = new ShopRepository();
        Product product1 = new Product(145, "Хлеб", 45);
        Product product2 = new Product(23, "Молоко", 82);
        Product product3 = new Product(43, "Масло", 198);
        Product product4 = new Product(56, "Сыр", 230);
        Product product5 = new Product(6, "Тесто", 250);

        repo.add(product1);
        repo.add(product2);
        repo.add(product3);
        repo.add(product4);
        repo.add(product5);

        Assertions.assertThrows(NotFoundException.class, () -> {
            repo.removeById(2345);
        });
    }
}




