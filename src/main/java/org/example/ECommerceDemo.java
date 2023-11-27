package org.example;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ECommerceDemo {
    public static void main(String[] args) {
        // Ініціалізація ECommercePlatform
        ECommercePlatform platform = new ECommercePlatform();

        // Додавання користувачів та товарів
        User user1 = new User(1, "User1");
        User user2 = new User(2, "User2");
        platform.addUserToPlatform(user1);
        platform.addUserToPlatform(user2);

        Product product1 = new Product(101, "Laptop", 999.99, 10);
        Product product2 = new Product(102, "Smartphone", 499.99, 20);
        platform.addProductToPlatform(product1);
        platform.addProductToPlatform(product2);

        // Симуляція додавання товарів до кошика користувача
        user1.addToCart(product1, 2);
        user1.addToCart(product2, 1);
        user2.addToCart(product1, 1);

        // Симуляція створення та обробки замовлення
        Order order1 = new Order(201, user1.getId());
        order1.addProductToOrder(product1, 2);
        order1.addProductToOrder(product2, 1);
        platform.createOrder(order1);

        // Виклик методів для сортування, фільтрації та рекомендацій
        System.out.println("Список товарів, відсортованих за ціною:");
        platform.getSortedProductsByPrice().forEach(System.out::println);

        System.out.println("\nСписок товарів, відсортованих за назвою:");
        platform.getSortedProductsByName().forEach(System.out::println);

        System.out.println("\nСписок товарів, відфільтрованих за наявністю на складі:");
        platform.getAvailableProducts().forEach(System.out::println);

        // Рекомендації користувачам
        platform.recommendProductsToUsers();

        // Відображення кінцевого стану користувачів, товарів та замовлень
        System.out.println("\nКінцевий стан користувачів:");
        platform.getUsers().values().forEach(System.out::println);

        System.out.println("\nКінцевий стан товарів:");
        platform.getProducts().values().forEach(System.out::println);

        System.out.println("\nКінцевий стан замовлень:");
        platform.getOrders().values().forEach(System.out::println);
    }
}
