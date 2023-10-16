package com.example.opportunitecollaboration.Services;

import com.example.opportunitecollaboration.Entities.ArticleBlog;

import java.util.List;

public interface ArticleBlogService {

    ArticleBlog addArticleBlog(ArticleBlog articleBlog);
    ArticleBlog updateArticleBlog(ArticleBlog articleBlog);
    ArticleBlog retrieveArticleBlogById(Long idArticleBlog);
    List<ArticleBlog> retrieveAllArticlesBlog();
    Boolean deleteArticleBlog(Long idArticleBlog);
}
