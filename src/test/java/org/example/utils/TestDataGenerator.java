package org.example.utils;

import org.example.model.Courier;
import org.example.model.Order;

import java.util.List;
import java.util.Objects;
import java.util.Random;

public class TestDataGenerator {
    private static final Random random = new Random();

    // Методы для курьера
    public static Courier generateRandomCourier() {
        String login = "courier_" + System.currentTimeMillis() + "_" + random.nextInt(1000);
        String password = "pass_" + random.nextInt(10000);
        String firstName = "Name_" + random.nextInt(1000);
        return new Courier(login, password, firstName);
    }

    public static Courier generateCourierWithoutLogin() {
        String password = "pass_" + random.nextInt(10000);
        String firstName = "Name_" + random.nextInt(1000);
        return new Courier(null, password, firstName);
    }

    public static Courier generateCourierWithoutPassword() {
        String login = "courier_" + System.currentTimeMillis() + "_" + random.nextInt(1000);
        String firstName = "Name_" + random.nextInt(1000);
        return new Courier(login, null, firstName);
    }

    public static String generateUniqueLogin() {
        return "courier_" + System.currentTimeMillis();
    }

    // Методы для заказа
    public static Order generateOrderWithColor(String color) {
        return new Order(
                "Иван",
                "Петров",
                "ул. Ленина, 1",
                "4",
                "+79991234567",
                5,
                "2026-09-10",
                Objects.nonNull(color) ? List.of(color) : null,
                "Тестовый заказ"
        );
    }

    public static Order generateOrderWithColors(List<String> colors) {
        return new Order(
                "Иван",
                "Петров",
                "ул. Ленина, 1",
                "4",
                "+79991234567",
                5,
                "2026-09-10",
                colors,
                "Тестовый заказ"
        );
    }

    public static Order generateOrderWithoutColor() {
        return new Order(
                "Иван",
                "Петров",
                "ул. Ленина, 1",
                "4",
                "+79991234567",
                5,
                "2026-09-10",
                null,
                "Тестовый заказ"
        );
    }
}
