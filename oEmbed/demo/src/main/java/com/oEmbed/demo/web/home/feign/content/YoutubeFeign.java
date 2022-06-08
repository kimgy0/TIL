package com.oEmbed.demo.web.home.feign.content;

import com.oEmbed.demo.global.config.FeignConfiguration;
import com.oEmbed.demo.web.home.dto.ContentDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.net.URI;

@FeignClient(name = "youtubeFeign", url= "dynamic_uri" , configuration = {FeignConfiguration.class})
public interface YoutubeFeign{

    @GetMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    ContentDto getContent(URI uri,
                            @RequestParam("url") String url,
                            @RequestParam("format") String format);

}