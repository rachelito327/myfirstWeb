package web.blog.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import web.blog.entity.Article;
import web.blog.mapper.ArticleMapper;

@Service
public class ArticleService {
	
	@Autowired
	private ArticleMapper articleMapper;
	
	
	// 刪除文章
	public void delete(String id) {
		articleMapper.delete(id);
	}
	
	// 保存博客
	public void save(Article article) {
		articleMapper.insert(article.getId(), article.getTitle(), article.getContent(), article.getDate());
	}
	
	
	// 根據標題查找
	public List<Article> search(String title){
		return articleMapper.findArticleByTITLE(title);
	}
	
	// 查詢所有列表
	public List<Article> list(){
		List<Article> articles = articleMapper.findAll();
		
		return articles;
	}
	
}
