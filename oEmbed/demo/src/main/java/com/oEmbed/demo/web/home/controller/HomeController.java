package com.oEmbed.demo.web.home.controller;

import com.oEmbed.demo.web.home.dto.ContentDto;
import com.oEmbed.demo.web.home.dto.UrlDto;
import com.oEmbed.demo.web.home.service.HomeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.net.URISyntaxException;

@RestController
@RequiredArgsConstructor
public class HomeController {

    private final HomeService homeService;

    @GetMapping("/")
    public ContentDto home(@RequestBody UrlDto urlDto) throws URISyntaxException {
        return homeService.getContent(urlDto.getUrl());
    }

}
