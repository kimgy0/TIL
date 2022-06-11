package com.oEmbed.demo.web.home.feign.provider;

import com.oEmbed.demo.global.config.FeignConfiguration;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "providerFeign", url= "https://oembed.com/" , configuration = {FeignConfiguration.class})
public interface ProviderFeign {

    @GetMapping(value = "/providers.json", produces = MediaType.APPLICATION_JSON_VALUE)
    String getProviders();

}
