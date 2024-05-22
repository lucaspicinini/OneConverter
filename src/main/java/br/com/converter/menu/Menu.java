package br.com.converter.menu;

import br.com.converter.app.CurrencyTable;

public class Menu {
    public void printMenuHeader() {
        String menuHeader = """
            ------------------------------------------------------------------
            ----------------------- Conversor de Moedas ----------------------
            ------------------------------------------------------------------
            """;
        System.out.println(menuHeader);
    }

    public void printMenuWaitInput() {
        String menuWaitInput = """
            ------------------------------------------------------------------
            ---- Selecione uma opção:
            """;
        System.out.println(menuWaitInput);
    }

    public void printMenuMain() {
        this.printMenuHeader();
        String menuMain = """
            ---- Opções:
            ---- 1 - Checar cotações do mundo todo com base em uma moeda.
            ---- 2 - Checar cotações entre duas moedas.
            ---- 3 - Sair.
            """;
        System.out.println(menuMain);
        this.printMenuWaitInput();
    }

    public void printMenuAllCurrencysMain() {
        String menuAllCurrencysMain = """
            ---- Opções:
            ---- 1 - Checar cotação com base em outra moeda.
            ---- 2 - Voltar ao menu principal.
            ---- 3 - Encerrar programa.
            """;
        System.out.println(menuAllCurrencysMain);
    }

    public void printMenuTwoCurrencysConversion() {
        String menuTwoCurrencysConversion = """
            ---- Opções:
            ---- 1 - Dólar => Peso Argentino
            ---- 2 - Peso Argentino => Dólar
            ---- 3 - Dólar => Real Brasileiro
            ---- 4 - Real Brasileiro => Dólar
            ---- 5 - Dólar => Peso Colombiano
            ---- 6 - Peso Colombiano => Dólar
            ---- 7 - Personalizar conversão.
            ---- 8 - Voltar ao menu principal.
            ---- 9 - Encerrar programa.
            """;
        System.out.println(menuTwoCurrencysConversion);
    }

    public void printMenuAllCurrencys(CurrencyTable currencyTable) {
        this.printMenuHeader();
        currencyTable.printConversionRates();
        this.printMenuAllCurrencysMain();
        this.printMenuWaitInput();
    }
}