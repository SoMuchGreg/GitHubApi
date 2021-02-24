package pl.somuchgreg.GitHubApi.data;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
public class RequestInfo {

    @Id
    private String login;
    private int requestCount;

}
