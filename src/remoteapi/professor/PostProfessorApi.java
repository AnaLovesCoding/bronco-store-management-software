package remoteapi.professor;
import com.google.gson.Gson;
import javafx.concurrent.Task;
import remoteapi.student.Student;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
public class PostProfessorApi extends Task<Void> {
    private final Gson gson = new Gson();
    private final Professor professor;
    private final String url;

    public PostProfessorApi(Professor professor) {
        this.professor = professor;
        this.url = "http://localhost:8080/api/professor";
    }

    @Override
    protected Void call() throws Exception {
        String body = gson.toJson(professor);

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
