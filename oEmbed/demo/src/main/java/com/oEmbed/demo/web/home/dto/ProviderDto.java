package com.oEmbed.demo.web.home.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import java.util.List;

@Getter
@NoArgsConstructor
public class ProviderDto {

    @JsonProperty(value = "provider_name")
    private String providerName;

    @JsonProperty(value = "provider_url")
    private String providerUrl;

    @JsonProperty(value = "endpoints")
    private List<EndPoint> endPoints;

    @Getter
    @NoArgsConstructor
    public static class EndPoint{
        private List<String> schemes;
        private String url;
    }
}
