package cn.aos.service;

import java.util.List;

import java.util.Map;
import cn.aos.po.Article;
import cn.aos.po.Oil;

public interface ArticleService {
	void saveArticle(Article article);

	void delete(int id);

	void update(Article article);

	Article findById(int r_id);

	void clean(int r_id);

	void restore(int r_id);

	List<Article> findAll();

	void insertarticle(String name, String phone, String date);

	public void insertarticle1(Article a);

	void updatearticle(int id, String date);

	List<Article> findid(int id);

	void delete1(int id);
}
