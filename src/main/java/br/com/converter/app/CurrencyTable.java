package br.com.converter.app;

import br.com.converter.api.HttpController;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.util.Map;

public class CurrencyTable {
    private HttpController httpController;
    private Gson gson = new Gson();
    private Map<String, Object> responseBody;
    private Map<String, Double> conversionRates;

    public CurrencyTable(String currencyCode) {
        this.httpController = new HttpController("latest",
                currencyCode,
                "",
                "");

        this.responseBody = this.gson.fromJson(
                this.httpController.getResponseBody(),
                new TypeToken<Map<String, Object>>(){}
        );

        this.conversionRates = this.gson.fromJson(
                this.responseBody.get("conversion_rates")
                        .toString(),
                new TypeToken<Map<String, Double>>(){}
        );
    }

    public void printConversionRates() {
        System.out.println("Moeda base atual: " + httpController.getCurrency());
        System.out.println();

        for (Map.Entry<String,Double> entry : conversionRates.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        };

        System.out.println();
    }
}