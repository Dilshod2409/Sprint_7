package org.example.model;

import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import io.restassured.response.Response;
import org.example.utils.OrderClient;
import org.example.utils.TestDataGenerator;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.hamcrest.Matchers.instanceOf;
import static org.hamcrest.Matchers.notNullValue;

@RunWith(Parameterized.class)
public class CreateOrderTest {
    private final Order order;
    private final OrderClient orderClient;

    public CreateOrderTest(Order order) {
        this.order = order;
        this.orderClient = new OrderClient();
    }

    @Parameterized.Parameters(name = "{1}")
    public static Collection<Object[]> testData() {
        return Arrays.asList(new Object[][]{
                {TestDataGenerator.generateOrderWithColor("BLACK"), "Заказ с цветом BLACK"},
                {TestDataGenerator.generateOrderWithColor("GREY"), "Заказ с цветом GREY"},
                {TestDataGenerator.generateOrderWithColors(Arrays.asList("BLACK", "GREY")), "Заказ с обоими цветами"},
                {TestDataGenerator.generateOrderWithoutColor(), "Заказ без указания цвета"}
        });
    }

    @Test
    @DisplayName("Создание заказа с разными вариантами цвета")
    @Description("Проверка создания заказа с разными вариантами цвета")
    public void createOrderTest() {
        Response response = orderClient.createOrder(order);

        response.then()
                .statusCode(201)
                .body("track", notNullValue())
                .body("track", instanceOf(Integer.class));

        System.out.println("Response: " + response.asString());
    }
}
