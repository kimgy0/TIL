package com.oEmbed.demo.web.home.controller;

import com.oEmbed.demo.web.home.dto.UrlDto;
import com.oEmbed.demo.web.home.service.HomeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class HomeController {

    private final HomeService homeService;

    @PostMapping("/")
    public void home(UrlDto urlDto){

    }

}
