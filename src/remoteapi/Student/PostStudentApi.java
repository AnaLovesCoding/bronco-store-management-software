package remoteapi.Student;

import com.google.gson.Gson;
import javafx.concurrent.Task;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class PostStudentApi extends Task<Void> {
    private final Gson gson = new Gson();
    private final Student student;
    private final String url;

    public PostStudentApi(Student student) {
        this.student = student;
        this.url = "http://localhost:8080/api/student";
    }

    @Override
    protected Void call() throws Exception {
        String body = gson.toJson(student);

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
