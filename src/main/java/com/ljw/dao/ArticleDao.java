package com.ljw.dao;

import com.ljw.bean.Article;

import java.util.List;

public interface ArticleDao {
    /**
     * 上传文章
     * @param article
     * @return
     */
    public int addAricle(Article article);

    /**
     * 通过删除文章
     * @param article
     * @return
     */
    public int deleteArticleById(Article article);

    /**
     * 修改文章
     * @param article
     * @return
     */
    public int updateArticle (Article article);

    /**
     * 通过ID查询文章
     * @param id
     * @return
     */
    public Article queryArticleById(Integer id);

    /**
     * 通过标题查询文章
     * @param title
     * @return
     */
    public Article queryArticleByTitle(String title);

    /**
     * 集合遍历文章
     * @return
     */
    public List<Article> queryArticles();

    /**
     * 通过作者查询所有文章
     * @param authorId
     * @return
     */
    public List<Article> queryArticlesByAuthor(Integer authorId);

    public List<Article> querySearch(String str);
}
