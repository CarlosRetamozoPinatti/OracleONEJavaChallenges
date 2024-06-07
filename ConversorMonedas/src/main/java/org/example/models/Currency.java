package org.example.models;

import java.util.Map;

/**
 * Esta clase representa la estructura de los datos de una moneda obtenidos de la API.
 * Utiliza el record de Java para simplificar la definición de una clase inmutable.
 * base_code y conversion_rates son nombres inmutables que vienen en el cuerpo JSON de la Respuesta.
 */
public record Currency(
        // Código base de la moneda y tasas de conversión a otras monedas
        String base_code,
        Map<String, Double> conversion_rates
) {
}
