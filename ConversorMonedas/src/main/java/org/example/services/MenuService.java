package org.example.services;

import org.example.api.APIUtils;
import org.example.models.Currency;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Esta clase maneja la lógica del menú del usuario.
 * Proporciona opciones de conversión de monedas y permite al usuario seleccionar una opción.
 */
public class MenuService {
    private final Map<Integer, String[]> optionSwitch;
    private final Scanner scanner;
    private final APIUtils apiUtils;
    private final ConversionService currencyConversion;

    /**
     * Constructor que inicializa las opciones del menú y los componentes necesarios.
     */
    public MenuService() {
        optionSwitch = new HashMap<>();
        optionSwitch.put(1, new String[]{"USD", "ARS"});
        optionSwitch.put(2, new String[]{"ARS", "USD"});
        optionSwitch.put(3, new String[]{"USD", "BRL"});
        optionSwitch.put(4, new String[]{"BRL", "USD"});
        optionSwitch.put(5, new String[]{"USD", "COP"});
        optionSwitch.put(6, new String[]{"COP", "USD"});
        optionSwitch.put(7, new String[]{"MXN", "ARS"});
        optionSwitch.put(8, new String[]{"MXN", "USD"});

        scanner = new Scanner(System.in);
        apiUtils = new APIUtils();
        currencyConversion = new ConversionService();
    }

    /**
     * Imprime el menú de opciones para el usuario.
     */
    public void showMenu() {
        String menu = """
                    Seleccione la Conversion a realizar:
                    1) Dolar => Peso argentino
                    2) Peso Argentino => Dolar
                    3) Dolar => Real Brasileño
                    4) Real Brasileño => Dolar
                    5) Dolar => Peso Colombiano
                    6) Peso Colombiano => Dolar
                    7) Dolar => Peso Méxicano
                    8) Peso Méxicano => Dolar
                    9) Salir
                    Elija una opción:
                    """;
        System.out.println(menu);
    }

    /**
     * Ejecuta el flujo principal de la aplicación.
     */
    public void runApp() {
        int userSelect;
        do {
            showMenu();
            try {
                userSelect = Integer.parseInt(scanner.nextLine());

                if (userSelect == 9) {
                    System.out.println("ADIOS..!!");
                    break;
                }

                switch (userSelect) {
                    case 1, 2, 3, 4, 5, 6, 7, 8 -> handleOption(userSelect);
                    default -> System.out.println("ERROR!! OPCION INVALIDA");
                }
            } catch (NumberFormatException e) {
                System.out.println("ENTRADA NO VALIDA.. INGRESE UN NUMERO");
            } catch (Exception e) {
                System.out.println("ERROR INESPERADO: " + e.getMessage());
            }
        } while (true);
    }

    /**
     * Maneja la opción seleccionada por el usuario.
     *
     * @param userSelect La opción seleccionada por el usuario.
     */
    private void handleOption(int userSelect) {
        String[] monedas = getCurrencies(userSelect);
        if (monedas != null) {
            System.out.println("INGRESE EL MONTO A CONVERTIR");
            Double cantidadAConvertir = getQuantity();

            if (cantidadAConvertir != null) {
                makeConversion(monedas, cantidadAConvertir);
            } else {
                System.out.println("MONTO NO VALIDO");
            }
        } else {
            System.out.println("OPCION NO VALIDA");
        }
    }

    /**
     * Obtiene las monedas correspondientes a la opción seleccionada.
     *
     * @param option La opción seleccionada por el usuario.
     * @return Un array de cadenas con las claves de las monedas original y nueva.
     */
    private String[] getCurrencies(int option) {
        return optionSwitch.get(option);
    }

    /**
     * Obtiene la cantidad a convertir ingresada por el usuario.
     *
     * @return La cantidad a convertir, o null si la entrada es inválida.
     */
    private Double getQuantity() {
        try {
            return Double.valueOf(scanner.nextLine());
        } catch (NumberFormatException e) {
            return null;
        }
    }

    /**
     * Realiza la conversión de la cantidad especificada entre las currencies dadas.
     *
     * @param currencies Las currencies original y nueva.
     * @param qtyToConvert La cantidad a convertir.
     */
    private void makeConversion(String[] currencies, Double qtyToConvert) {
        try {
            Currency currencyToConvert = apiUtils.getCurrencyFromAPI(currencies[0]);
            Double newQty = currencyConversion.convert(qtyToConvert, currencyToConvert, currencies[1]);

            System.out.printf("CANTIDAD A CONVERTIR: %.2f %s%n", qtyToConvert, currencies[0]);
            System.out.printf("CANTIDAD CONVERTIDA: %.2f %s%n", newQty, currencies[1]);
        } catch (Exception e) {
            System.out.println("Ocurrió un error al realizar la conversión: " + e.getMessage());
        }
    }
}
