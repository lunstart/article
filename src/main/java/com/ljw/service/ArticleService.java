package com.ljw.service;

import com.ljw.bean.Article;

import java.util.List;

public interface ArticleService {
    /**
     * 上传文章
     * @param article
     */
   public void  uploadArticle(Article article);

    /**
     *修改文章
     * @param article
     */
   public void alterArticle(Article article);

    /**
     * 删除文章
     * @param Article
     * @return
     */
   public void deleteArticle(Article Article);

    /**
     *查询所有文章
     * @return
     */
   public List<Article> queryArticles();

    /**
     * 通过作者id查询文章
     * @param id
     * @return
     */
    public List<Article> queryArticlesByAuthor_id(Integer id);

    /**
     * 通过id查询文章
     * @return
     */
   public Article queryArticleById(Integer id);

    public List<Article> querySearch(String str);

}
