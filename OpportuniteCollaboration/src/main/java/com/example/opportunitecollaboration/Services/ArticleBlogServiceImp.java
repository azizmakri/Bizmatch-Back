package com.example.opportunitecollaboration.Services;

import com.example.opportunitecollaboration.Entities.ArticleBlog;
import com.example.opportunitecollaboration.Repositories.ArticleBlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArticleBlogServiceImp implements ArticleBlogService {

    @Autowired
    ArticleBlogRepository articleBlogRepository;

    @Override
    public ArticleBlog addArticleBlog(ArticleBlog articleBlog) {
        return articleBlogRepository.save(articleBlog);
    }

    @Override
    public ArticleBlog updateArticleBlog(ArticleBlog articleBlog) {
        return articleBlogRepository.save(articleBlog);
    }

    @Override
    public ArticleBlog retrieveArticleBlogById(Long idArticleBlog) {
        return articleBlogRepository.findById(idArticleBlog).orElse(null);
    }

    @Override
    public List<ArticleBlog> retrieveAllArticlesBlog() {
        return articleBlogRepository.findAll();
    }

    @Override
    public Boolean deleteArticleBlog(Long idArticleBlog) {
        if (articleBlogRepository.existsById(idArticleBlog)) {
            articleBlogRepository.deleteById(idArticleBlog);
            return true;
        }
        else {
            return false;
        }
    }
}
