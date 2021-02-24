package pl.somuchgreg.GitHubApi.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import pl.somuchgreg.GitHubApi.data.User;
import pl.somuchgreg.GitHubApi.service.UserService;

@RestController
@RequiredArgsConstructor
public class Controller {

    private final UserService userService;

    @GetMapping("/users/{login}")
    public User getUser(@PathVariable String login){
        return userService.getUser(login);
    }
}
