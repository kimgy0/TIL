package com.oEmbed.demo.web.home.service;

import com.oEmbed.demo.global.constant.BaseConst;
import com.oEmbed.demo.global.constant.DomainType;
import com.oEmbed.demo.web.home.dto.ContentDto;
import com.oEmbed.demo.web.home.dto.ProviderDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class HomeService {

    private final ProviderFeignService providerFeignService;
    private final ContentFeignService contentFeignService;

    public ContentDto getContent(String videoUrl) {

        List<ProviderDto> providers = providerFeignService.findAllProvider();

        for (ProviderDto provider : providers) {
            String providerName = provider.getProviderName().toLowerCase();

            if(videoUrl.contains(providerName)){
                String endpoint = provider.getEndPoints().get(BaseConst.FIRST_INDEX).getUrl();
                DomainType domain = DomainType.valueOf(providerName.toUpperCase());
                try {
                    return contentFeignService.getContentByFeign(domain, endpoint, videoUrl);
                } catch (Exception e) {
                    return new ContentDto();
                }
            }
        }

        return new ContentDto();
    }
}
