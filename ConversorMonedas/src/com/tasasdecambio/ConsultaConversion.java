// Esta clase es responsable de realizar las consultas de la API de exchangerate-api.com
// y obtener una tasa de conversión para la moneda solicitada por el usuario.

package com.tasasdecambio;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConsultaConversion {
    // API Key asignada (pagina exchangerate-api.com)
    private final String apiKey = "73d392c0a5903f8bca0a22ae";

    // Metodo que obtiene la tasa de conversión entre dos monedas
    public double obtenerTasaDeConversion(String monedaBase, String monedaObjetivo) {
        try {
            // Crea la URI para la solicitud de la API con la clave de API y las monedas
            URI uri = URI.create("https://v6.exchangerate-api.com/v6/" + apiKey + "/pair/" +
                    monedaBase + "/" + monedaObjetivo + "/1");  // El "1" es solo para obtener la tasa de conversion

            // Crea un cliente HTTP para realizar la solicitud
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder().uri(uri).build();

            // Envia la solicitud y obtiene la respuesta en formato JSON
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            // Convierte la respuesta JSON a un objeto JSON de Gson
            JsonElement jsonElement = JsonParser.parseString(response.body());
            JsonObject jsonObject = jsonElement.getAsJsonObject();

            // Obtiene la tasa de conversión desde el objeto JSON
            return jsonObject.get("conversion_rate").getAsDouble();
        } catch (IOException | InterruptedException e) {
            System.out.println("Error al obtener la tasa de conversión: " + e.getMessage());
            return 0;  // Si ocurre un error, se devuelve 0 para indicar al usuario que no se pudo obtener la tasa de cambio
        }
    }
}
