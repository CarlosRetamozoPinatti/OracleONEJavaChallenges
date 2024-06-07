package org.example.api;


import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
/**
 * Esta clase maneja las solicitudes HTTP a la API.
 * Utiliza HttpClient para enviar solicitudes y obtener respuestas.
 */
public class APIClient {
    // Cliente HTTP que se reutiliza para todas las solicitudes
    private static final HttpClient client = HttpClient.newHttpClient();
    /**
     * Envía una solicitud GET a la URL proporcionada y devuelve una APIResponse.
     *
     * @param apiUrl La URL a la que se envía la solicitud GET.
     * @return La respuesta de la API encapsulada en un objeto APIResponse.
     */
    public static APIResponse sendGETRequest(String apiUrl) {
        // Construcción de la solicitud HTTP
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(apiUrl))
                .build();

        try {
            // Envío de la solicitud y obtención de la respuesta
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            // Devolución de la respuesta envuelta en un APIResponse
            return new APIResponse(response);
        } catch (IOException | InterruptedException e) {
            // En caso de error, lanzar una RuntimeException
            throw new RuntimeException(e);
        }
    }
}
