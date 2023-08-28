package com.bestapp.newsfeed.services.impl;

import com.bestapp.newsfeed.exceptions.NewsByCategoryNotFoundException;
import com.bestapp.newsfeed.exceptions.NewsByContentNotFoundException;
import com.bestapp.newsfeed.exceptions.NewsByTitleNotFoundException;
import com.bestapp.newsfeed.exceptions.NewsNotFoundException;
import com.bestapp.newsfeed.models.Category;
import com.bestapp.newsfeed.models.News;
import com.bestapp.newsfeed.repositories.NewsRepository;
import com.bestapp.newsfeed.services.NewsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

@Service
public class NewsServiceImpl implements NewsService {
    private final NewsRepository newsRepository;
    private static final Logger logger = LoggerFactory.getLogger(NewsServiceImpl.class);

    public NewsServiceImpl(NewsRepository newsRepository) {
        this.newsRepository = newsRepository;
    }

    /**
     * Creating an object of the News class and saving it to the database
     * <br>
     * Using repository method {@link org.springframework.data.jpa.repository.JpaRepository#save(Object)}
     *
     * @param news News class object can not be null
     * @return created News class object
     */
    @Override
    public News createNews(News news) {
        logger.info("Create news method was invoked");
        newsRepository.save(news);
        logger.info("News {} was created successfully", news);
        return news;
    }

    /**
     * Getting the collection of News objects from database
     * <br>
     * Using repository method {@link org.springframework.data.jpa.repository.JpaRepository#findAll()}
     *
     * @return collection of News class objects
     */
    @Override
    public Collection<News> findAllNews() {
        logger.info("Find all news method was invoked");
        Collection<News> news = newsRepository.findAll();
        logger.info("All news was successfully found");
        return news;
    }

    /**
     * Updating an object of the News class and saving it to the database
     * <br>
     * Using repository method {@link org.springframework.data.jpa.repository.JpaRepository#save(Object)}
     *
     * @param news News class object can not be null
     * @return updated News class object
     */
    @Override
    public News updateNews(News news) {
        logger.info("Update news: {} method was invoked", news);
        newsRepository.save(news);
        logger.info("News {} was updated successfully", news);
        return news;
    }

    /**
     * Deleting an object of the News class by its number
     * <br>
     * Using repository method {@link org.springframework.data.jpa.repository.JpaRepository#deleteById(Object)}
     *
     * @param newsId identification number of News class object can not be null
     */
    @Override
    public void deleteNewsById(Long newsId) {
        logger.info("Delete news by id = {} method was invoked", newsId);
        newsRepository.deleteById(newsId);
        logger.info("News with id = {} was deleted successfully", newsId);
    }

    @Override
    public List<News> getListOfNewsByPage(Integer number, Integer size) {
        PageRequest pageRequest = PageRequest.of(--number, size);
        return newsRepository.findAll(pageRequest).getContent();
    }

    @Override
    public List<News> findNewsByTitle(String title) {
        List<News> news = newsRepository.findNewsByTitle(title);
        if (news.isEmpty()) {
            throw new NewsByTitleNotFoundException("No news found for title: " + title);
        }
        return news;
    }

    @Override
    public List<News> findNewsByCategory(Category category) {
        List<News> news = newsRepository.findNewsByCategory(category);
        if (news.isEmpty()) {
            throw new NewsByCategoryNotFoundException("No news found for category: " + category.getName());
        }
        return news;
    }

    @Override
    public List<News> findNewsByContent(String content) {
        List<News> news = newsRepository.findNewsByContent(content);
        if (news.isEmpty()) {
            throw new NewsByContentNotFoundException("No news found for content: " + content);
        }
        return news;
    }

    @SuppressWarnings("OptionalGetWithoutIsPresent")
    @Override
    public void markLikedNews(Long newsId) {
        Long like;
        try {
            News news = newsRepository.findById(newsId).get();
            like = news.getPopularityRating();
            news.setPopularityRating(++like);
            newsRepository.save(news);
        } catch (NewsNotFoundException e) {
            System.out.println("Error! News doesn't exist!");
        }
    }

    @Override
    public List<News> findNewsByCategoryAndTitleAndContent(Category category, String title, String content) {
        List<News> news = newsRepository.findNewsByCategoryAndTitleAndContent(category, title, content);
        if (news.isEmpty()) {
            throw new NewsNotFoundException("No news found for - " + category.getName() + " " + title + " " + content);
        }
        return news;
    }
}
