package pl.somuchgreg.GitHubApi.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import pl.somuchgreg.GitHubApi.data.RequestInfo;
import pl.somuchgreg.GitHubApi.data.RequestInfoRepository;

import java.util.Optional;

import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;


@ExtendWith(SpringExtension.class)
class RequestInfoServiceTest {

    @Mock
    private RequestInfoRepository requestInfoRepository;

    @Mock
    RequestInfo requestInfo;

    @InjectMocks
    private RequestInfoService requestInfoService;

    @Test
    void testServiceExistingInfoFound() {
        //given
        when(requestInfoRepository.findByLogin(anyString())).thenReturn(Optional.of(requestInfo));
        when(requestInfo.getRequestCount()).thenReturn(1);
        doNothing().when(requestInfo).setRequestCount(anyInt());

        //when
        requestInfoService.update("any");

        //then
        verify(requestInfoRepository, times(1)).save(any());
        verify(requestInfo, times(1)).setRequestCount(anyInt());
        verify(requestInfo, times(1)).getRequestCount();
        verify(requestInfo, times(0)).setLogin(any());
    }

    @Test
    void testServiceExistingInfoNotFound() {
        //given
        when(requestInfoRepository.findByLogin(anyString())).thenReturn(Optional.empty());

        //when
        requestInfoService.update("any");

        //then
        verify(requestInfoRepository, times(1)).save(any());
        verify(requestInfo, times(0)).setRequestCount(anyInt());
        verify(requestInfo, times(0)).getRequestCount();
        verify(requestInfo, times(0)).setLogin(anyString());
    }
}