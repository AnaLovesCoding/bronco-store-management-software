package remoteapi.discount;

import com.google.gson.Gson;
import javafx.concurrent.Task;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class FetchDiscountApi extends Task<Discount[]> {
    private final String url = "http://localhost:8080/api/discounts";

    @Override
    protected Discount[] call() throws Exception {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .build();

        HttpResponse<String> response = client.send(request,
                HttpResponse.BodyHandlers.ofString());

        return new Gson().fromJson(response.body(), Discount[].class);
    }
}
