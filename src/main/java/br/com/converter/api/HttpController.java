package br.com.converter.api;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class HttpController {
    private ApiUrl apiUrl;
    private HttpResponse<String> response;

    public HttpController(String urlSuffix,
                          String currency,
                          String targetCurrency,
                          String amount) {

        this.apiUrl = new ApiUrl(urlSuffix,
                currency,
                targetCurrency,
                amount);

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(apiUrl.getUrl()))
                .build();

        HttpClient client = HttpClient.newHttpClient();

        try {
            this.response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());
        } catch (IOException | InterruptedException e) {
            System.out.println("Ops, tivemos um problema na requisição: " + e.getMessage());
            System.out.println("Tente novamente em alguns instantes.");
        }
    }

    public HttpResponse<String> getResponse() {
        return response;
    }

    public String getResponseBody() {
        return response.body();
    }

    public String getCurrency() {
        return apiUrl.getBaseCurrency();
    }
}