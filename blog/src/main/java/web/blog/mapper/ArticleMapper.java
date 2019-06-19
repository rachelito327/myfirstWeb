package web.blog.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import web.blog.entity.Article;

@Mapper
public interface  ArticleMapper {
	
	
	// 要建table ARTICLE
	@Select("SELECT * FROM ARTICLES WHERE TITLE = #{title}")
	List<Article> findArticleByTITLE(@Param("title") String title);
	
	@Insert("INSERT INTO ARTICLES(id, title, content, date) VALUES(#{id}, #{title}, #{content}, #{date}) ")
	int insert(@Param("id") String id, @Param("title") String title, @Param("content") String content, @Param("date") String date);

	@Delete("DELETE FROM ARTICLES where id = #{id}")
	int delete(@Param("id") String id);
	
	@Select("SELECT * FROM ARTICLES")
	List<Article> findAll();
	
	


}

