import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ClientHttp {

    public String dataSearch(String url)  {

        try {
            URI address = URI.create(url);
            var client = HttpClient.newHttpClient(); // HttpClient
            var request = HttpRequest.newBuilder(address).GET().build(); // HttpRequest
            var response = client.send(request, HttpResponse.BodyHandlers.ofString()); // HttpResponse<String>
            return response.body();
        } catch (IOException | InterruptedException ex) {
            throw new RuntimeException(ex);
        }
    }
}
