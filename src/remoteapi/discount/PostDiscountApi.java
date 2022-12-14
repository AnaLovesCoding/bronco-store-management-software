package remoteapi.discount;
import com.google.gson.Gson;
import javafx.concurrent.Task;
import remoteapi.product.Product;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
public class PostDiscountApi extends Task<Void> {
    private final Gson gson = new Gson();
    private final Discount discount;
    private final String url;

    public PostDiscountApi(Discount discount) {
        this.discount = discount;
        this.url = "http://localhost:8080/api/discounts";
    }
    @Override
    protected Void call() throws Exception {
        String body = gson.toJson(discount);

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
