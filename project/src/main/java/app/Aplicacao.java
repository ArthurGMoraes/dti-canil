package app;

import static spark.Spark.*;
import service.AppService;

public class Aplicacao {
    private static AppService appService = new AppService();
    public static void main(String[] args) {
        port(1234);
        staticFiles.location("/web");

        get("/home", (request, response) -> appService.load(request, response));
        post("/buscar", (request, response) -> appService.buscar(request, response));
    }
}