package pl.somuchgreg.GitHubApi.clients;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import pl.somuchgreg.GitHubApi.data.User;

@Component
@RequiredArgsConstructor
public class GitHubClient {

    private final RestTemplate restTemplate;

    public User getUser(String login){
        HttpHeaders headers = new HttpHeaders();
        headers.add("Accept", "application/vnd.github.v3+json");
        HttpEntity<String> requestEntity = new HttpEntity<>(headers);

        ResponseEntity<User> responseEntity = restTemplate.exchange(urlForTransaction(login), HttpMethod.GET, requestEntity, User.class);

        return responseEntity.getBody();
    }

    private String urlForTransaction(String variable) {
        return "/" + variable;
    }

}
