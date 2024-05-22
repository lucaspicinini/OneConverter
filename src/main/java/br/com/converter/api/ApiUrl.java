package br.com.converter.api;

public class ApiUrl {
    private final String apiKey = "8d30cd2eb0bd6a40f1c9d4de";
    private final String urlPrefix = "https://v6.exchangerate-api.com/v6/";
    private String urlSuffix;
    private String url; // url == urlPrefix + apiKey + urlSuffix + currency;
    private String baseCurrency;
    private String targetCurrency;
    private String amount;

    public ApiUrl(String urlSuffix,
                  String baseCurrency,
                  String targetCurrency,
                  String amount) {

        this.urlSuffix = "/" + urlSuffix + "/";
        this.baseCurrency = baseCurrency;
        this.targetCurrency = "/" + targetCurrency + "/";
        this.amount = amount;

        if (urlSuffix.equals("latest")) {
            this.url = this.urlPrefix + this.apiKey + this.urlSuffix + this.baseCurrency;
        } else if (urlSuffix.equals("pair")) {
            this.url = this.urlPrefix + this.apiKey + this.urlSuffix + this.baseCurrency + this.targetCurrency + this.amount;
        }
    }

    public String getBaseCurrency() {
        return baseCurrency;
    }

    public void setBaseCurrency(String baseCurrency) {
        this.baseCurrency = baseCurrency;
    }

    public String getUrl() {
        return url;
    }
}