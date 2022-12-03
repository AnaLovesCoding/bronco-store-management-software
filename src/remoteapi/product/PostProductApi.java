package remoteapi.product;

import com.google.gson.Gson;
import javafx.concurrent.Task;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class PostProductApi extends Task<Void> {
    private final Gson gson = new Gson();
    private final Product product;
    private final String url;

    public PostProductApi(Product product) {
        this.product = product;
        this.url = "http://localhost:8080/api/products";
    }

    @Override
    protected Void call() throws Exception {
        String body = gson.toJson(product);

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .header("Content-Type", "application/json")
                .POST(HttpRequest.BodyPublishers.ofString(body))
                .build();

        HttpResponse<String> response = client.send(
                request,
                HttpResponse.BodyHandlers.ofString()
        );

        return null;
    }
}
