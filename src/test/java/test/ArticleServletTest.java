package test;

import com.ljw.bean.Article;
import com.ljw.service.ArticleService;
import com.ljw.service.impl.ArticleServiceImpl;
import org.junit.Test;

import static org.junit.Assert.*;

public class ArticleServletTest {
    private ArticleService articleService = new ArticleServiceImpl();


    @Test
    public void doGet() {
        articleService.deleteArticle(new Article(10, null, null, null, null));
    }

    @Test
    public void doPost() {
    }

    @Test
    public void addArticle() {
    }

    @Test
    public void alterArticle() {
    }
}