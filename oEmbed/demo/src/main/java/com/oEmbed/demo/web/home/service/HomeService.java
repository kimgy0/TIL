package com.oEmbed.demo.web.home.service;

import com.oEmbed.demo.web.home.dto.ProviderDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class HomeService {

    private final ProviderFeignService providerFeignService;

    public List<ProviderDto> getContent(String url){
        List<ProviderDto> providers = providerFeignService.findAllProvider();
        return null;

    }
}
