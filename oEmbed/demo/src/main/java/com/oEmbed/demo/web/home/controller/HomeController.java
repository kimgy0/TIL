package com.oEmbed.demo.web.home.controller;

import com.oEmbed.demo.web.home.dto.ContentDto;
import com.oEmbed.demo.web.home.dto.UrlDto;
import com.oEmbed.demo.web.home.service.HomeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class HomeController {

    private final HomeService homeService;

    @PostMapping("/")
    public String postUrlFromHome(@Validated @ModelAttribute UrlDto urlDto,
                       BindingResult bindingResult,
                       Model model) {
        if(bindingResult.hasErrors()){
            model.addAttribute("content",new ContentDto());
            return "home/home";
        }
        ContentDto content = homeService.getContent(urlDto.getUrl());
        model.addAttribute("urlDto", urlDto);
        model.addAttribute("content", content);

        return "home/home";
    }

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("urlDto",new UrlDto());
        model.addAttribute("content",new ContentDto());
        return "home/home";
    }

}
