package com.oEmbed.demo.global.config;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.oEmbed.demo.global.constant.BaseConst;
import com.oEmbed.demo.web.home.dto.ProviderDto;
import feign.FeignException;
import feign.Logger;
import feign.RequestInterceptor;
import feign.Response;
import feign.codec.DecodeException;
import feign.codec.Decoder;
import feign.codec.Encoder;
import feign.codec.ErrorDecoder;
import feign.form.spring.SpringFormEncoder;
import feign.optionals.OptionalDecoder;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.http.HttpMessageConverters;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.openfeign.FeignClientsConfiguration;
import org.springframework.cloud.openfeign.support.ResponseEntityDecoder;
import org.springframework.cloud.openfeign.support.SpringDecoder;
import org.springframework.cloud.openfeign.support.SpringEncoder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.http.codec.json.Jackson2JsonDecoder;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.Arrays;

@Configuration
@EnableFeignClients(basePackages = "com.oEmbed.demo")
@Import(FeignClientsConfiguration.class)
public class FeignConfiguration {
    @Bean
    Logger.Level feignLoggerLevel() {
        return Logger.Level.FULL;
    }

    @Bean
    Encoder feignFormEncoder(ObjectFactory<HttpMessageConverters> converters) {
        return new SpringFormEncoder(new SpringEncoder(converters));
    }

    @Bean
    public RequestInterceptor requestFeign() {
        return requestTemplate -> {
            requestTemplate.header(BaseConst.CONTENT_TYPE, BaseConst.CONTENT_TYPE_VALUE_OF_URL_ENCODER);
            requestTemplate.header(BaseConst.ACCEPT, BaseConst.ACCEPT_TYPE_ALL);
        };
    }

}
