package pl.somuchgreg.GitHubApi.config;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class RestTemplateConfig {

    @Bean
    public RestTemplate transactionsHttpClient(RestTemplateBuilder restTemplateBuilder,
                                               TransactionsProperties transactionsProperties) {
        return restTemplateBuilder
                .rootUri(transactionsProperties.getRootUrl())
                .build();
    }

}
