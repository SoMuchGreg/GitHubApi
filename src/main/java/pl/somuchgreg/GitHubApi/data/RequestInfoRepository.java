package pl.somuchgreg.GitHubApi.data;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RequestInfoRepository extends JpaRepository<RequestInfo, Integer> {

    Optional<RequestInfo> findByLogin(String login);

}
