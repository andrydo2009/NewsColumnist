package com.bestapp.newsfeed.repositories;

import com.bestapp.newsfeed.dto.NewsDTO;
import com.bestapp.newsfeed.models.Category;
import com.bestapp.newsfeed.models.News;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;
import java.util.List;

public interface NewsRepository extends JpaRepository<News, Long> {
    Collection<News> findNewsByTitle(String title);

    Collection<News>  findNewsByCategory(Category category);

    Collection<News>  findNewsByContent(String content);

    Collection<News>  findNewsByCategoryAndTitleAndContent(Category category, String title, String content);
}
