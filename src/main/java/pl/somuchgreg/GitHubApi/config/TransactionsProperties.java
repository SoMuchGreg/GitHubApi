package pl.somuchgreg.GitHubApi.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@Component
@ConfigurationProperties("transaction.api")
public class TransactionsProperties {
    private String rootUrl;
}
