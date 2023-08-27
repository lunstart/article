package test;

import com.ljw.bean.Article;
import com.ljw.service.ArticleService;
import com.ljw.service.UserService;
import com.ljw.service.impl.ArticleServiceImpl;
import com.ljw.service.impl.UserServiceImpl;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class MainServletTest {
    ArticleService articleService = new ArticleServiceImpl();
    UserService userService = new UserServiceImpl();

    @Test
    public void doGet() {
    }

    @Test
    public void queryAll() {
    }

    @Test
    public void queryArticleById() {
    }

    @Test
    public void queryArticleByAuthor_id() {
        List<Article> articles = new ArrayList<Article>();
        articles = articleService.queryArticlesByAuthor_id(14);
        for (Article tmp : articles) {
            System.out.println(tmp.toString());
        }
    }
}