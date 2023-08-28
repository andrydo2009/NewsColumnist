package com.bestapp.newsfeed.services;

import com.bestapp.newsfeed.models.News;

import java.util.Collection;

public interface NewsService {
    News createNews(News news);
    Collection<News> findAllNews();
    News updateNews(News news);
    void deleteNewsById(Long newsId);

}
