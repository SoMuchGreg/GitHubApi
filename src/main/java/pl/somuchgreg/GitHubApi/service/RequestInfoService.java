package pl.somuchgreg.GitHubApi.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import pl.somuchgreg.GitHubApi.data.RequestInfo;
import pl.somuchgreg.GitHubApi.data.RequestInfoRepository;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class RequestInfoService {

    private final RequestInfoRepository requestInfoRepository;

    public void update(String login){
        Optional<RequestInfo> infoOptional = requestInfoRepository.findByLogin(login.toLowerCase());
        RequestInfo info;

        if(infoOptional.isPresent()){
            info = infoOptional.get();
            info.setRequestCount(info.getRequestCount()+1);
        } else{
            info = new RequestInfo();
            info.setLogin(login.toLowerCase());
            info.setRequestCount(1);
        }
        requestInfoRepository.save(info);
    }
}
