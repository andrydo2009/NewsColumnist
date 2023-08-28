package com.bestapp.newsfeed.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Getter
@Setter
public class News {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String content;
    private LocalDate publicationDate;
    private Long popularityRating;
    @ManyToOne
    private Category category;

    public News() {
    }

    public News(Long id, String title, String content, LocalDate publicationDate, Category category) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.publicationDate = publicationDate;
        this.popularityRating = 0L;
        this.category = category;
    }

    public News(Long id, String title, String content, LocalDate publicationDate) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.popularityRating = 0L;
        this.publicationDate = publicationDate;
    }
}
