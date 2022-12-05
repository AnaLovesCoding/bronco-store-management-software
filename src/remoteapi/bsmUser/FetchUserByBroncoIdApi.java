package remoteapi.bsmUser;

import com.google.gson.Gson;
import javafx.concurrent.Task;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class FetchUserByBroncoIdApi extends Task<BSMUser> {
    private final String url;

    public FetchUserByBroncoIdApi(String broncoId) {
        this.url = "http://localhost:8080/api/bsmUser/" + broncoId;
    }

    @Override
    protected BSMUser call() throws Exception {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .build();

        HttpResponse<String> response = client.send(request,
                HttpResponse.BodyHandlers.ofString());

        return new Gson().fromJson(response.body(), BSMUser.class);
    }
}

