package web.blog.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import web.blog.entity.User;
import web.blog.mapper.UserMapper;

@Service
public class UserService {
	
	
	@Autowired
	UserMapper userMapper;
	
	
	public boolean login(String username) {
		User user = userMapper.findUserByUsername(username);
		
		if( user == null ) {
			return false;
		}else {
			return true;
		}
	}

}
