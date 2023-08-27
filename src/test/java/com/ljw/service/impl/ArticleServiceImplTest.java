package com.ljw.service.impl;

import com.ljw.bean.Article;
import com.ljw.dao.ArticleDao;
import com.ljw.dao.impl.ArticleDaoImpl;
import org.junit.Test;

import static org.junit.Assert.*;

public class ArticleServiceImplTest {
    private ArticleDao articleDao = new ArticleDaoImpl();
    @Test
    public void querySearch() {
        Article article = (Article) articleDao.querySearch("明");
        System.out.println(article.toString());
    }
}