package com.bestapp.newsfeed.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class NewsDTO {
    private Long idDTO;
    private String titleDTO;
    private String content;
    private LocalDate publicationDateDTO;
    private Long popularityRatingDTO;
    private Long categoryIdDTO;
    private CategoryDTO categoryDTO;
}

