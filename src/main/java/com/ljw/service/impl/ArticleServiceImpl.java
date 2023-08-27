package com.ljw.service.impl;

import com.ljw.bean.Article;
import com.ljw.dao.ArticleDao;
import com.ljw.dao.impl.ArticleDaoImpl;
import com.ljw.service.ArticleService;

import java.util.List;

public class ArticleServiceImpl implements ArticleService {

    private ArticleDao articleDao = new ArticleDaoImpl();

    @Override
    public void uploadArticle(Article article) {
        articleDao.addAricle(article);
    }

    @Override
    public void alterArticle(Article article) {
        articleDao.updateArticle(article);
    }

    @Override
    public void deleteArticle(Article article) {
        articleDao.deleteArticleById(article);
    }

    @Override
    public List<Article> queryArticles() {
        return articleDao.queryArticles();
    }

    @Override
    public List<Article> queryArticlesByAuthor_id(Integer id) {
        return articleDao.queryArticlesByAuthor(id);
    }

    @Override
    public Article queryArticleById(Integer id) {
        return articleDao.queryArticleById(id);
    }

    @Override
    public List<Article> querySearch(String str) {
        return articleDao.querySearch(str);
    }

}
