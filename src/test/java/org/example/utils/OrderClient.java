package org.example.utils;

import io.qameta.allure.Step;
import io.restassured.response.Response;
import org.example.endpoints.ApiEndpoints;
import org.example.model.Order;

import static io.restassured.RestAssured.given;

public class OrderClient {

    @Step("Создание заказа")
    public Response createOrder(Order order) {
        return given()
                .header("Content-Type", "application/json")
                .body(order)
                .when()
                .post(ApiEndpoints.BASE_URL + ApiEndpoints.ORDER_PATH);
    }

    @Step("Получение списка заказов")
    public Response getOrdersList() {
        return given()
                .when()
                .get(ApiEndpoints.BASE_URL + ApiEndpoints.ORDER_PATH);
    }
}
