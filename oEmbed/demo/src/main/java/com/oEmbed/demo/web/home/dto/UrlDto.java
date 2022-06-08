package com.oEmbed.demo.web.home.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
public class UrlDto {
    @NotBlank
    private String url;
}
