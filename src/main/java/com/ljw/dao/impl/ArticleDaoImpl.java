package com.ljw.dao.impl;

import com.ljw.dao.ArticleDao;
import com.ljw.bean.Article;

import java.util.List;

public class ArticleDaoImpl extends BaseDao implements ArticleDao {
    @Override
    public int addAricle(Article article) {
        //language=MySQL
        String sql = "insert into  `articles` (`title`,`content`,`author_id`) values (?,?,?)";
        return update(sql, article.getTitle(), article.getContent(), article.getAuthor_id());
    }

    @Override
    public int deleteArticleById(Article article) {
        //language=MySQL
        String sql = "delete from  `articles` where id = ?";
        return update(sql,article.getId());
    }

    @Override
    public int updateArticle(Article article) {
        //language=MySQL
        String sql = "update `articles` set `title`=?,`content`=? where `id`=?";
        return update(sql,article.getTitle(), article.getContent(),article.getId());
    }

    @Override
    public Article queryArticleById(Integer id) {
        //language=MySQL
        String sql = "select * from `articles` where `id` = ?";
        return queryForOne(Article.class, sql, id);
    }

    @Override
    public Article queryArticleByTitle(String title) {
        //language=MySQL
        String sql = "select * from `articles` where `title` = ?";
        return queryForOne(Article.class,sql,title);
    }

    @Override
    public List<Article> queryArticles() {
        //language=MySQL
        String sql = "select * from `articles`";
        return queryForList(Article.class, sql);
    }

    @Override
    public List<Article> queryArticlesByAuthor(Integer authorId) {
        //language=MySQL
        String sql = "select * from articles where author_id = ?";
        return queryForList(Article.class,sql,authorId);
    }

    @Override
    public List<Article> querySearch(String str) {
        //language=MySQL
        String sql = "select * from articles where title like ? or content like ? ";
        String  str1 = "%" + str +"%";
        return queryForList(Article.class,sql,str1,str1);
    }
}
