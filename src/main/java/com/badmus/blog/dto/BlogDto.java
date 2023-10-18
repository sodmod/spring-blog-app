package com.badmus.blog.dto;

import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Builder
@Data
public class BlogDto {
    private String id;
    private String title;
    private String description;
    private String url;
    private Date dateCreated;
}
