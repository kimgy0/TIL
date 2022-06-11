package com.oEmbed.demo.web.home.service;

import com.oEmbed.demo.global.constant.BaseConst;
import com.oEmbed.demo.global.constant.DomainType;
import com.oEmbed.demo.web.home.dto.ContentDto;
import com.oEmbed.demo.web.home.feign.content.InstagramFeign;
import com.oEmbed.demo.web.home.feign.content.TwitterFeign;
import com.oEmbed.demo.web.home.feign.content.VimeoFeign;
import com.oEmbed.demo.web.home.feign.content.YoutubeFeign;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.net.URI;
import java.net.URISyntaxException;

@Service
@RequiredArgsConstructor
public class ContentFeignService {

    private final TwitterFeign twitterFeign;
    private final VimeoFeign vimeoFeign;
    private final YoutubeFeign youtubeFeign;
    private final InstagramFeign instagramFeign;

    public ContentDto getContentByFeign(DomainType domainType, String endPoint, String videoUrl) throws URISyntaxException {

        try{
            if(DomainType.YOUTUBE.equals(domainType)){
                return youtubeFeign.getContent(new URI(endPoint),videoUrl,BaseConst.JSON_FORMAT);
            }
            if(DomainType.INSTAGRAM.equals(domainType)){
                return instagramFeign.getContent(new URI(endPoint),videoUrl,"528359615659276"+ "|" +"fee20e5b0b3ee7fb4398a32d46a41667"
                );
            }
            if(DomainType.TWITTER.equals(domainType)){
                return twitterFeign.getContent(new URI(endPoint),videoUrl);
            }
            if(DomainType.VIMEO.equals(domainType)){
                return vimeoFeign.getContent(new URI(endPoint.replace("{format}", BaseConst.JSON_FORMAT)), videoUrl);
            }
            throw new IllegalArgumentException("not supported url");
        }catch (Exception e){
            e.printStackTrace();
            throw new IllegalArgumentException("not found page");
        }
    }

}


