package com.bestapp.newsfeed.services;

import com.bestapp.newsfeed.models.Category;
import com.bestapp.newsfeed.models.News;

import java.util.Collection;
import java.util.List;

public interface NewsService {
    News createNews(News news);
    Collection<News> findAllNews();
    News updateNews(News news);
    void deleteNewsById(Long newsId);
    List<News> getListOfNewsByPage(Integer number, Integer size);
    List<News> findNewsByTitle(String title);
    List<News> findNewsByCategory(Category category);
    List<News> findNewsByContent(String content);
    void markLikedNews(Long newsId);
    List<News> findNewsByCategoryAndTitleAndContent(Category category, String title, String content);
}
