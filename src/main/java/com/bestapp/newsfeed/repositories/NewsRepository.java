package com.bestapp.newsfeed.repositories;

import com.bestapp.newsfeed.models.Category;
import com.bestapp.newsfeed.models.News;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface NewsRepository extends JpaRepository<News, Long> {
    List<News> findNewsByTitle(String title);

    List<News> findNewsByCategory(Category category);

    List<News> findNewsByContent(String content);

    List<News> findNewsByCategoryAndTitleAndContent(Category category, String title, String content);
}
