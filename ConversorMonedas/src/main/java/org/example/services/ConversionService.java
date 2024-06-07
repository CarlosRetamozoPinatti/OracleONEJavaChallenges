package org.example.services;

import org.example.models.Currency;
/**
 * Esta clase proporciona métodos para convertir cantidades de una moneda a otra.
 */
public class ConversionService {
    /**
     * Convierte una cantidad de una moneda original a una moneda nueva.
     *
     * @param quantity La cantidad a convertir.
     * @param currencyFrom El objeto Moneda que contiene las tasas de conversión.
     * @param keyCurrencyTo La clave de la moneda a la que se desea convertir.
     * @return La cantidad convertida a la nueva moneda.
     */
    public Double convert(Double quantity, Currency currencyFrom, String keyCurrencyTo) {
        return quantity * currencyFrom.conversion_rates().get(keyCurrencyTo);
    }
}

