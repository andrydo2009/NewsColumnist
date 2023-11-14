package com.bestapp.newsfeed.services;

import com.bestapp.newsfeed.dto.NewsDTO;
import com.bestapp.newsfeed.models.Category;
import com.bestapp.newsfeed.models.News;

import java.util.Collection;
import java.util.List;

public interface NewsService {
    NewsDTO createNews(NewsDTO news);
    Collection<NewsDTO> findAllNews();
    NewsDTO updateNews(NewsDTO news);
    void deleteNewsById(Long newsId);
    List<News> getListOfNewsByPage(Integer number, Integer size);
    Collection<NewsDTO> findNewsByTitle(String title);
    Collection<News>  findNewsByCategory(Category category);
    Collection<News>  findNewsByContent(String content);
    void markLikedNews(Long newsId);
    Collection<News>  findNewsByCategoryAndTitleAndContent(Category category, String title, String content);
}
