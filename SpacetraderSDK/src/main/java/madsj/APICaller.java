package madsj;

import java.io.IOException;
import java.net.Authenticator;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class APICaller {

    private String baseURL = "https://api.spacetraders.io/";
    private String token;

    public APICaller() {
        this("");
    }

    public APICaller(String token) {
        this.token = token;
    }

    private HttpRequest.Builder createHttpRequest(String endpoint) throws URISyntaxException {
        HttpRequest.Builder request = HttpRequest.newBuilder()
                .uri(new URI(baseURL + endpoint))
                .header("Content-Type", "application/json");

        if (!token.equals("")) {
            request.header("Authorization", "Bearer " + token);
        }

        return request;
    }

    private HttpResponse<String> send(HttpRequest request) throws IOException, InterruptedException {
        return HttpClient.newHttpClient()
                .send(request, HttpResponse.BodyHandlers.ofString());
    }

    public String GET(String endpoint) throws URISyntaxException, IOException, InterruptedException {
        HttpRequest.Builder request = createHttpRequest(endpoint);
        request.GET();

        HttpResponse<String> response = send(request.build());
        return response.body();
    }

    public String POST(String endpoint, String body) throws IOException, InterruptedException, URISyntaxException {
        HttpRequest.Builder request = createHttpRequest(endpoint);
        request.POST(HttpRequest.BodyPublishers.ofString(body));

        HttpResponse<String> response = send(request.build());
        return response.body();
    }

    public String PUT(String endpoint) throws IOException, InterruptedException, URISyntaxException {
        HttpRequest.Builder request = createHttpRequest(endpoint);
        request.PUT(HttpRequest.BodyPublishers.noBody());

        HttpResponse<String> response = send(request.build());
        return response.body();
    }

    public String DELETE(String endpoint) throws IOException, InterruptedException, URISyntaxException {
        HttpRequest.Builder request = createHttpRequest(endpoint);
        request.DELETE();

        HttpResponse<String> response = send(request.build());
        return response.body();
    }
}
