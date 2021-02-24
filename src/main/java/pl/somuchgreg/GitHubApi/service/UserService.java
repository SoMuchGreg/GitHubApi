package pl.somuchgreg.GitHubApi.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import pl.somuchgreg.GitHubApi.clients.GitHubClient;
import pl.somuchgreg.GitHubApi.data.User;

@Component
@RequiredArgsConstructor
public class UserService {

    private final GitHubClient gitHubClient;
    private final RequestInfoService requestInfoService;

    public User getUser(String login){
        requestInfoService.update(login);
        return gitHubClient.getUser(login);
    }

}
