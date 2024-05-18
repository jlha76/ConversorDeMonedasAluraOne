import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;

public class ClienteSolicitudes {
    String key = "74aacc33ea2c347f319493b3";
    String base = "USD";
    String target = "MXN";
    int cant = 100;
    URI direccion = URI.create("https://v6.exchangerate-api.com/v6/"+ key +"/pair/"+ base + "/"+ target + "/" + cant);
    HttpClient client = HttpClient.newHttpClient();
    HttpRequest request = HttpRequest.newBuilder()
            .uri(direccion)
            .build();
}
