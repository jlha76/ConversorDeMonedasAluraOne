import com.google.gson.Gson;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConsultaMoneda {
    public Moneda buscaMoneda (String base, String target, int cant){
        String key = "74aacc33ea2c347f319493b3";

        URI direccion = URI.create("https://v6.exchangerate-api.com/v6/"+ key +"/pair/"+ base + "/"+ target + "/" + cant);
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(direccion)
                .build();
        try {
            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());
            return new Gson().fromJson(response.body(), Moneda.class);
        } catch (Exception e) {
            throw new RuntimeException("No se encontro la Moneda.");
        }
    }
}
