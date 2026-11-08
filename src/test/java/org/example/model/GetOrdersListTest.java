package org.example.model;

import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import io.restassured.response.Response;
import org.example.utils.OrderClient;
import org.junit.Test;

import static org.hamcrest.Matchers.instanceOf;
import static org.hamcrest.Matchers.notNullValue;

public class GetOrdersListTest {
    private final OrderClient orderClient = new OrderClient();

    @Test
    @DisplayName("Получение списка заказов")
    @Description("Проверка, что список заказов возвращается и содержит данные")
    public void getOrdersListTest() {
        Response response = orderClient.getOrdersList();

        response.then()
                .statusCode(200)
                .body("orders", notNullValue())
                .body("orders", instanceOf(java.util.List.class));
    }

    @Test
    @DisplayName("Получение списка заказов - проверка структуры")
    @Description("Проверка, что в ответе есть список заказов с корректной структурой")
    public void getOrdersListStructureTest() {
        Response response = orderClient.getOrdersList();

        response.then()
                .statusCode(200)
                .body("orders", notNullValue());

        java.util.List<?> orders = response.path("orders");
        if (orders != null && !orders.isEmpty()) {
            for (int i = 0; i < Math.min(orders.size(), 3); i++) {
                response.then()
                        .body("orders[" + i + "]", notNullValue());
            }
        }
    }
}
