package com.oEmbed.demo.global.constant;

import lombok.Getter;

@Getter
public enum DomainType {

    YOUTUBE("youtube"),
    TWITTER("twitter"),
    INSTAGRAM("instagram"),
    VIMEO("vimeo");

    DomainType(String type) {
        this.type = type;
    }

    private String type;
}
