package com.oEmbed.demo.web.home.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.RuntimeJsonMappingException;
import com.oEmbed.demo.web.home.dto.ProviderDto;
import com.oEmbed.demo.web.home.feign.provider.ProviderFeign;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ProviderFeignService {

    private final ProviderFeign feign;

    @Cacheable(value = "providers")
    public List<ProviderDto> findAllProvider(){
        String providerJson = feign.getProviders();
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
            return Arrays.asList(objectMapper.readValue(providerJson, ProviderDto[].class));

        } catch (JsonProcessingException e) {
            throw new RuntimeJsonMappingException("can not mappings provider");
        }
    }
}
