package com.oEmbed.demo.web.home.feign.provider;

import com.oEmbed.demo.global.config.FeignConfiguration;
import com.oEmbed.demo.web.home.dto.ProviderDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.cloud.openfeign.SpringQueryMap;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

@FeignClient(name = "providerFeign", url= "https://oembed.com/" , configuration = {FeignConfiguration.class})
public interface ProviderFeign {

    @GetMapping(value = "/providers.json", produces = MediaType.APPLICATION_JSON_VALUE)
    String getProviders();

}
