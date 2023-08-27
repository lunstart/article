package test;

import com.ljw.bean.Article;
import com.ljw.bean.User;
import com.ljw.dao.ArticleDao;
import com.ljw.dao.impl.ArticleDaoImpl;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class ArticleDaoImplTest {
    private ArticleDao articleDao = new ArticleDaoImpl();

    @Test
    public void addAricle() {
        articleDao.addAricle(new Article(null, "面朝大海，春暖花开",
                "从明天起，做一个幸福的人\n" +
                        "喂马、劈柴，周游世界\n" +
                        "从明天起，关心粮食和蔬菜\n" +
                        "我有一所房子，面朝大海，春暖花开\n" +
                        "从明天起，和每一个亲人通信\n" +
                        "告诉他们我的幸福\n" +
                        "那幸福的闪电告诉我的\n" +
                        "我将告诉每一个人\n" +
                        "给每一条河每一座山取一个温暖的名字\n" +
                        "陌生人，我也为你祝福\n" +
                        "愿你有一个灿烂的前程\n" +
                        "愿你有情人终成眷属\n" +
                        "愿你在尘世获得幸福\n" +
                        "我只愿面朝大海，春暖花开", null, 14));
    }

    @Test
    public void deleteArticleById() {

    }

    @Test
    public void updateArticle() {
        articleDao.updateArticle(new Article(2, "假如生活欺骗了你",
                "假如生活欺骗了你，\n" +
                        "不要悲伤，不要心急！\n" +
                        "忧郁的日子里须要镇静：\n" +
                        "相信吧，快乐的日子将会来临！\n" +
                        "心儿永远向往着未来；\n" +
                        "现在却常是忧郁：\n" +
                        "一切都是瞬息，一切都将会过去；\n" +
                        "而那过去了的，就会成为亲切的怀恋。", null, 2));
    }

    @Test
    public void queryArticleById() {
        Article article = articleDao.queryArticleById(1);
        System.out.println(article.toString());
    }

    @Test
    public void queryArticles() {
        List<Article> articleList = articleDao.queryArticles();
        for (Article tmp :articleList) {
            System.out.println(tmp);
        }
    }

    @Test
    public void querySearch() {
        for (Article tmp:articleDao.querySearch("你")) {
            System.out.println(tmp.toString());
        }
    }
}