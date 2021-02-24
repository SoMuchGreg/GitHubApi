package pl.somuchgreg.GitHubApi.data;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Value;

import java.time.LocalDateTime;

@Value
@JsonIgnoreProperties(ignoreUnknown=true)
@JsonPropertyOrder({"id","login","name","type","avatarUrl","createdAt","calculations"})
public class User {
    private int id;
    private String login;
    private String name;
    private String type;
    private String avatarUrl;
    private LocalDateTime createdAt;
    private int publicRepos;
    private int followers;
    private double calculations;

    public User(int id,
                String login,
                String name,
                String type,
                @JsonProperty("avatar_url") String avatarUrl,
                @JsonProperty("created_at") LocalDateTime createdAt,
                @JsonProperty("public_repos") int publicRepos,
                @JsonProperty("followers") int followers) {
        this.id = id;
        this.login = login;
        this.name = name;
        this.type = type;
        this.avatarUrl = avatarUrl;
        this.createdAt = createdAt;
        this.publicRepos = publicRepos;
        this.followers = followers;
        this.calculations = calculate(followers, publicRepos);
    }

    private double calculate(int divisionValue, int sumValue){
        return (double)6/divisionValue*(2+sumValue);
    }

    @JsonProperty("avatarUrl")
    public String getAvatarUrl() {
        return avatarUrl;
    }

    @JsonProperty("createdAt")
    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    @JsonIgnore
    public int getPublicRepos() {
        return publicRepos;
    }

    @JsonIgnore
    public int getFollowers() {
        return followers;
    }
}
