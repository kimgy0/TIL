package com.oEmbed.demo.web.home.service;

import com.oEmbed.demo.global.constant.BaseConst;
import com.oEmbed.demo.global.constant.DomainType;
import com.oEmbed.demo.web.home.dto.ContentDto;
import com.oEmbed.demo.web.home.dto.ProviderDto;
import com.oEmbed.demo.web.home.feign.content.InstagramFeign;
import com.oEmbed.demo.web.home.feign.content.TwitterFeign;
import com.oEmbed.demo.web.home.feign.content.VimeoFeign;
import com.oEmbed.demo.web.home.feign.content.YoutubeFeign;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class ContentFeignService {

    private final TwitterFeign twitterFeign;
    private final VimeoFeign vimeoFeign;
    private final YoutubeFeign youtubeFeign;

    public ContentDto getContentByFeign(DomainType domainType, String endPoint, String videoUrl) throws URISyntaxException {

        if(DomainType.YOUTUBE.equals(domainType)){
            return youtubeFeign.getContent(new URI(endPoint),videoUrl,BaseConst.JSON_FORMAT);
        }
        if(DomainType.INSTAGRAM.equals(domainType)){
            return null;
        }
        if(DomainType.TWITTER.equals(domainType)){
            return twitterFeign.getContent(new URI(endPoint),videoUrl);
        }
        if(DomainType.VIMEO.equals(domainType)){
            return vimeoFeign.getContent(new URI(endPoint.replace("{format}",BaseConst.JSON_FORMAT)),videoUrl);
        }

        throw new IllegalArgumentException("not supported url");
    }

}


