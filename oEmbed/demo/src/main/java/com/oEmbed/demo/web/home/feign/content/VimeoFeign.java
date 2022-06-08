package com.oEmbed.demo.web.home.feign.content;

import com.oEmbed.demo.global.config.FeignConfiguration;
import com.oEmbed.demo.web.home.dto.ContentDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.net.URI;

@FeignClient(name = "vimeoFeign", url= "dynamic_uri" , configuration = {FeignConfiguration.class})
public interface VimeoFeign{

    @GetMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    ContentDto getContent(URI uri,
                          @RequestParam("url") String url);

}