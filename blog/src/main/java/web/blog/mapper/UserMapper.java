package web.blog.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import web.blog.entity.Article;
import web.blog.entity.User;

/// crud operation



@Mapper
public interface UserMapper {

	// 要建table USERS
	@Select( "SELECT * FROM USERS WHERE USERNAME = #{username}" )
	User findUserByUsername(@Param("username") String username);	
		
}
