package com.bestapp.newsfeed.controllers;

import com.bestapp.newsfeed.models.News;
import com.bestapp.newsfeed.services.NewsService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;

/**
 * Controller for News objects class
 * @see News
 * @see com.bestapp.newsfeed.services.impl.NewsServiceImpl
 */
@RestController
@RequestMapping("/news")
@Tag(name = "News", description = "CRUD-operations to work with the news")
public class NewsController {
private final NewsService newsService;

    public NewsController(NewsService newsService) {
        this.newsService = newsService;
    }

    @PostMapping
    @Operation(
            summary = "Create news",
            description = "Create news with its number"
    )
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "News was successfully created",
                    content = {
                            @Content(
                                    mediaType = MediaType.APPLICATION_JSON_VALUE,
                                    array = @ArraySchema(schema =
                                    @Schema(implementation = News.class))
                            )
                    }
            )
    })
    public ResponseEntity<News> createNews(@RequestBody News news) {
        News createdNews = newsService.createNews(news);
        return ResponseEntity.ok(createdNews);
    }

    @GetMapping
    @Operation(
            summary = "Find all news",
            description = "Show all news"
    )
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "News were successfully found",
                    content = {
                            @Content(
                                    mediaType = MediaType.APPLICATION_JSON_VALUE,
                                    array = @ArraySchema(schema =
                                    @Schema(implementation = News.class))
                            )
                    }
            ),
            @ApiResponse(
                    responseCode = "404",
                    description = "News were not found",
                    content = {
                            @Content(
                                    mediaType = MediaType.APPLICATION_JSON_VALUE,
                                    array = @ArraySchema(schema =
                                    @Schema(implementation = News.class))
                            )
                    }
            )
    })
    public ResponseEntity<Collection<News>> getAllNews() {
        Collection<News> news = newsService.findAllNews();
        if (news == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(news);
    }

    @PutMapping
    @Operation(
            summary = "Update news data",
            description = "Updating news data"
    )
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "News data was successfully updated",
                    content = {
                            @Content(
                                    mediaType = MediaType.APPLICATION_JSON_VALUE,
                                    array = @ArraySchema(schema =
                                    @Schema(implementation = News.class))
                            )
                    }
            ),
            @ApiResponse(
                    responseCode = "404",
                    description = "News not found",
                    content = {
                            @Content(
                                    mediaType = MediaType.APPLICATION_JSON_VALUE,
                                    array = @ArraySchema(schema =
                                    @Schema(implementation = News.class))
                            )
                    }
            )
    })
    public ResponseEntity<News> updateNews(@RequestBody News news) {
        News updatedNews = newsService.updateNews(news);
        if (updatedNews == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(updatedNews);
    }

    @DeleteMapping("/{newsId}")
    @Operation(
            summary = "Delete news by its number",
            description = "Search by news number to delete it"
    )
    @Parameters(value = {
            @Parameter(name = "newsId", example = "1")
    })
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "News was successfully deleted"
            ),
            @ApiResponse(
                    responseCode = "404",
                    description = "News not found"
            )
    })
    public ResponseEntity<Void> deleteNewsById(@PathVariable("newsId") Long newsId) {
        newsService.deleteNewsById(newsId);
        return ResponseEntity.ok().build();
    }


    @GetMapping("/newsPage")
    @Operation(
            summary = "",
            description = ""
    )
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = ""
            ),
            @ApiResponse(
                    responseCode = "404",
                    description = ""
            )
    })
    public ResponseEntity<List<News>> getListNewsPage(
            @RequestParam("page") Integer page, @RequestParam("size") Integer size) {
        List<News> news = newsService.getListOfNewsByPage ( page,size );
        if (news == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(news);
    }
}
