package org.example;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.Map;
import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.stream.Collectors;

import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.stream.Collectors;

public class ECommercePlatform {
    private Map<Integer, User> users;
    private Map<Integer, Product> products;
    private Map<Integer, Order> orders;

    public ECommercePlatform() {
        this.users = new HashMap<>();
        this.products = new HashMap<>();
        this.orders = new HashMap<>();
    }

    public void addUserToPlatform(User user) {
        users.put(user.getId(), user);
    }

    public void addProductToPlatform(Product product) {
        products.put(product.getId(), product);
    }

    public void createOrder(Order order) {
        orders.put(order.getId(), order);
    }

    public List<Product> getSortedProductsByPrice() {
        return products.values()
                .stream()
                .sorted()
                .collect(Collectors.toList());
    }

    public List<Product> getSortedProductsByName() {
        return products.values()
                .stream()
                .sorted(Comparator.comparing(Product::getName))
                .collect(Collectors.toList());
    }

    public List<Product> getAvailableProducts() {
        return products.values()
                .stream()
                .filter(product -> product.getStock() > 0)
                .collect(Collectors.toList());
    }

    public void recommendProductsToUsers() {
        users.values().forEach(user -> {
            List<Product> userCartProducts = user.getCart().keySet().stream().collect(Collectors.toList());

            List<Product> recommendedProducts = products.values().stream()
                    .filter(product -> !userCartProducts.contains(product))
                    .limit(3)
                    .collect(Collectors.toList());

            System.out.println("Рекомендації для користувача " + user.getUsername() + ":");
            recommendedProducts.forEach(System.out::println);
        });
    }

    public Map<Integer, User> getUsers() {
        return users;
    }

    public Map<Integer, Product> getProducts() {
        return products;
    }

    public Map<Integer, Order> getOrders() {
        return orders;
    }
}
