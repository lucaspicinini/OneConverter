package br.com.converter.main;

import br.com.converter.menu.Menu;
import br.com.converter.app.CurrencyTable;
import br.com.converter.app.TwoCurrencysConversion;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        boolean finished = false;
        String userInput;
        Menu menu = new Menu();

        do {
            menu.printMenuMain();
            Scanner scanner = new Scanner(System.in);
            userInput = scanner.nextLine();

            switch (userInput) {
                case "1" -> {
                    CurrencyTable currencyTable = new CurrencyTable("BRL");
                    menu.printMenuAllCurrencys(currencyTable);
                    userInput = scanner.nextLine();

                    while (userInput.equals("1")) {
                        System.out.println("Informe o código de universal da Moeda: ");
                        userInput = scanner.nextLine();
                        currencyTable = new CurrencyTable(userInput);
                        menu.printMenuAllCurrencys(currencyTable);
                        userInput = scanner.nextLine();
                    }

                    if (userInput.equals("2")) {
                        userInput = "";
                    } else if (userInput.equals("3")) {
                        finished = true;
                    }
                }
                case "2" -> {
                    String baseCurrency = "";
                    String targetCurrency = "";
                    String amount;
                    String currencyOption;
                    String finalAmount = "";

                    label:
                    while (true) {
                        menu.printMenuHeader();
                        if (!finalAmount.isEmpty()) {
                            System.out.println(finalAmount);
                            System.out.println();
                        }
                        menu.printMenuTwoCurrencysConversion();
                        menu.printMenuWaitInput();
                        currencyOption = scanner.nextLine();

                        switch (currencyOption) {
                            case "1" -> {
                                baseCurrency = "USD";
                                targetCurrency = "ARS";
                            }
                            case "2" -> {
                                baseCurrency = "ARS";
                                targetCurrency = "USD";
                            }
                            case "3" -> {
                                baseCurrency = "USD";
                                targetCurrency = "BRL";
                            }
                            case "4" -> {
                                baseCurrency = "BRL";
                                targetCurrency = "USD";
                            }
                            case "5" -> {
                                baseCurrency = "USD";
                                targetCurrency = "COP";
                            }
                            case "6" -> {
                                baseCurrency = "COP";
                                targetCurrency = "USD";
                            }
                        }

                        switch (currencyOption) {
                            case "7":
                                System.out.println("Digite o código oficial da moeda que será convertida: ");
                                baseCurrency = scanner.nextLine();
                                System.out.println("Digite o código oficial da moeda-alvo para conversão: ");
                                targetCurrency = scanner.nextLine();
                                break;
                            case "8":
                                break label;
                            case "9":
                                finished = true;
                                break label;
                        }

                        System.out.println("Digite o valor em " + baseCurrency + " para conversão: ");
                        amount = scanner.nextLine();
                        TwoCurrencysConversion twoCurrencysConversion = new TwoCurrencysConversion(baseCurrency, targetCurrency, amount);
                        finalAmount = "Valor convertido: " + twoCurrencysConversion.getResponseBody().get("conversion_result") + " " + targetCurrency;
                    }
                }
                case "3" -> {
                    finished = true;
                }
                default -> {
                    System.out.println("Digite uma opção válida!");
                }
            }
        } while(!finished);

        System.out.println("Encerrando programa... Até a próxima :)");
    }
}