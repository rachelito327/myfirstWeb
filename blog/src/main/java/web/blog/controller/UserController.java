package web.blog.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import web.blog.entity.Article;
import web.blog.entity.User;
import web.blog.service.ArticleService;
import web.blog.service.UserService;




@Controller
@RequestMapping("/admin")
public class UserController{
	
	@Autowired
	UserService userService;
	
	@Autowired
	ArticleService articleService;
	
	private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
	
	// 後台主頁
	
	// model 物件, 為依賴注入物件, 在檔案中, 只有一個 
	// 依賴注入的物件, 由IoC 容器保管, 整個程式執行期只有一個, 想要用隨時可用
	@RequestMapping("")
	public String admin(Model model) {
		List<Article> articles = articleService.list();
		model.addAttribute("articles", articles);
		
		return "/admin/index";
	}
	
	
	// model 用來將傳送訊息送給view
	// 登入模塊
	@RequestMapping("/login")
	public String login(){
		return "admin/login";
	}
	
	
	// 使用value 可以將多個值對應到同一個方法上
	
	// method
	// 將一個請求對應到一個特定的http方法
	// method來聲明HTTP請求所用的方法類型
	@RequestMapping(value = "/dologin", method = RequestMethod.POST)
	public String doLogin(User user, Model model) {
		if( userService.login(user.getUsername()) ) {
			return "redirect:/admin";
		}else {
			model.addAttribute("error", "用戶者或密碼錯誤");
			
			return "admin/login";
		}
	}
	
	// delete blog
	@RequestMapping("/delete/{id}")
	public String delete(@PathVariable("id") String id){
		articleService.delete(id);
		
		return "redirect:/admin";
	}
	
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String save(Article article) {
		article.setDate(sdf.format(new Date()));
		articleService.save(article);
		
		return "redirect:/admin";
		
	}
	
}


