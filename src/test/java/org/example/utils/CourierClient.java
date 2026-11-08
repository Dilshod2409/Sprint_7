package org.example.utils;

import io.qameta.allure.Step;
import io.restassured.response.Response;
import org.example.endpoints.ApiEndpoints;
import org.example.model.Courier;
import org.example.model.CourierCredentials;

import static io.restassured.RestAssured.given;

public class CourierClient {

    @Step("Создание курьера")
    public Response createCourier(Courier courier) {
        return given()
                .header("Content-Type", "application/json")
                .body(courier)
                .when()
                .post(ApiEndpoints.BASE_URL + ApiEndpoints.COURIER_PATH);
    }

    @Step("Логин курьера")
    public Response loginCourier(CourierCredentials credentials) {
        return given()
                .header("Content-Type", "application/json")
                .body(credentials)
                .when()
                .post(ApiEndpoints.BASE_URL + ApiEndpoints.LOGIN_PATH);
    }

    @Step("Удаление курьера по id: {id}")
    public void deleteCourier(int id) {
        given()
                .when()
                .delete(ApiEndpoints.BASE_URL + ApiEndpoints.COURIER_PATH + "/" + id);
    }

    @Step("Получение id курьера")
    public int getCourierId(CourierCredentials credentials) {
        return loginCourier(credentials)
                .then()
                .extract()
                .path("id");
    }
}
