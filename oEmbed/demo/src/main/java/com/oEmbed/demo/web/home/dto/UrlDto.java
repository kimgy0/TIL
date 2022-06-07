package com.oEmbed.demo.web.home.dto;

import lombok.Getter;

import javax.validation.constraints.NotBlank;

@Getter
public class UrlDto {
    @NotBlank
    private String url;
}
