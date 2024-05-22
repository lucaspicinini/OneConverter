package br.com.converter.app;

import br.com.converter.api.HttpController;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.util.Map;

public class TwoCurrencysConversion {
    private HttpController httpController;
    private Gson gson = new Gson();
    private Map<String, Object> responseBody;

    public TwoCurrencysConversion(String currencyCode, String targetCurrency, String amount) {
        this.httpController = new HttpController("pair",
                currencyCode,
                targetCurrency,
                amount);

        this.responseBody = this.gson.fromJson(
                this.httpController.getResponseBody(),
                new TypeToken<Map<String, Object>>(){}
        );
    }

    public Map<String, Object> getResponseBody() {
        return responseBody;
    }
}