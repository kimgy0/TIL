package com.oEmbed.demo.web.home.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class ContentDto {
    private String title;

    @JsonProperty(value = "author_name")
    private String authorName;

    @JsonProperty(value = "author_url")
    private String authorUrl;

    private String type;

    private int width;

    private int height;

    private int duration;

    private String description;

    private String version;

    @JsonProperty(value = "provider_name")
    private String providerName;

    @JsonProperty(value = "provider_url")
    private String providerUrl;

    @JsonProperty(value = "thumbnail_height")
    private int thumbnailHeight;

    @JsonProperty(value = "thumbnail_width")
    private int thumbnailWidth;

    @JsonProperty(value = "thumbnail_url")
    private String thumbnailUrl;

    @JsonProperty(value = "thumbnail_url_with_play_button")
    private String thumbnailUrlWithPlayButton;

    @JsonProperty(value = "upload_date")
    private String uploadDate;

    private String uri;

    @JsonProperty(value = "video_id")
    private String videoId;

    @JsonProperty(value = "is_plus")
    private int isPlus;


    @JsonProperty(value = "html")
    private String html;
}
