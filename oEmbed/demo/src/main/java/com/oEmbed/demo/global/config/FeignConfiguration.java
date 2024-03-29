package com.oEmbed.demo.global.config;

import com.oEmbed.demo.global.constant.BaseConst;
import feign.Logger;
import feign.RequestInterceptor;
import feign.codec.Encoder;
import feign.form.spring.SpringFormEncoder;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.boot.autoconfigure.http.HttpMessageConverters;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.openfeign.FeignClientsConfiguration;
import org.springframework.cloud.openfeign.support.SpringEncoder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

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
