package cn.aos.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.aos.mapper.ArticleMapper;
import cn.aos.po.Article;
import cn.aos.service.ArticleService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service(value = "articleService")
public class ArticleServiceImpl implements ArticleService {
	@Autowired
	private ArticleMapper articleMapper;

	/**
	 * 添加文章信息
	 * 
	 * @param article
	 *            前台传来的文章数据
	 */
	public void saveArticle(Article article) {
		articleMapper.saveArticle(article);
	}

	/**
	 * 删除功能
	 * 
	 * @param r_id
	 *            要删除字段的ID值
	 */
	public void delete(int r_id) {
		articleMapper.delete(r_id);
	}

	/**
	 * 更新用户信息的功能
	 * 
	 * @param article
	 *            需要更新的数据
	 */
	public void update(Article article) {
		articleMapper.update(article);
	}

	/**
	 * 根据ID查询信息
	 * 
	 * @param r_id
	 *            要查询的ID
	 * @return 返回查询到的数据
	 */
	public Article findById(int r_id) {
		return articleMapper.findById(r_id);
	}

	/**
	 * 删除文章的功能（仅把文章放入到回收站中）
	 * 
	 * @param r_id
	 *            需要删除的文章的ID值
	 */
	public void clean(int r_id) {
		articleMapper.clean(r_id);
	}

	/**
	 * 恢复文章的功能（即将文章从回收站中移除）
	 * 
	 * @param r_id
	 *            要恢复的文章的ID值
	 */
	public void restore(int r_id) {
		articleMapper.restore(r_id);
	}

	public List<Article> findAll() {
		// TODO Auto-generated method stub
		return articleMapper.findAll();
	}

	public void insertarticle(String name, String phone, String date) {
		// TODO Auto-generated method stub
		articleMapper.insertarticle(name, phone, date);
	}

	public void updatearticle(int id, String date) {
		// TODO Auto-generated method stub
		articleMapper.updatearticle(id, date);
	}

	public List<Article> findid(int id) {
		// TODO Auto-generated method stub
		return articleMapper.findid(id);
	}

	public void insertarticle1(Article a) {
		// TODO Auto-generated method stub
		articleMapper.insertarticle1(a);

	}

	public void delete1(int id) {
		// TODO Auto-generated method stub
		articleMapper.delete1(id);
	}

}
