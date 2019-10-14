package com.neu.controller;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.logging.log4j.core.config.plugins.validation.constraints.Required;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageInfo;
import com.neu.entity.LoginResponse;
import com.neu.entity.Role;
import com.neu.entity.User;
import com.neu.service.UserService;

@Controller
@RequestMapping("user")
public class UserController {

	@Autowired
	private UserService userService;
	
	@RequestMapping("login")
	@ResponseBody
	public LoginResponse login(String username,String password,String code,HttpSession session) {
		User user = userService.login(username, password);
		LoginResponse loginResponse = new LoginResponse();
		if(user != null) {
			loginResponse.setUser(user);
			loginResponse.setStatus("success");
			session.setAttribute("user", user);
			return loginResponse;
		}else {
			return null;
		}
	}
	
	@RequestMapping("exit")
	@ResponseBody
	public int exit(@Required HttpSession session){
		session.invalidate();
		return 1;
	}
	
	@RequestMapping("updatePassword")
	@ResponseBody
	public int updatePassword(@RequestBody User user, @Required HttpSession session){
		int i = userService.update(user);
		session.setAttribute("user", user);
		return i;
	}
	
	@RequestMapping("getPaged")
	@ResponseBody
	public PageInfo<User> getPaged(
			@RequestParam(defaultValue = "1") int pageNum,
			@RequestParam(defaultValue = "7") int pageSize, 
			@RequestBody Role role,
			@Required HttpSession session){
		User user = (User)session.getAttribute("user");
		return userService.getPaged(pageNum, pageSize, role, user);
	}
	
	@RequestMapping("delete")
	@ResponseBody
	public int delete(User user){
		return userService.delete(user.getId());
	}
	
	@RequestMapping("getUserId")
	public String getUserId(String username) {
		User user = userService.getUserId(username);
		if(user == null) {
			return "redirect:/securityquestion/noUserSQInfo";
		}
		return "redirect:/securityquestion/getByUserName?userId="+user.getId();
	}
	
	
	@RequestMapping("visitor")
	@ResponseBody
	public LoginResponse visitor(HttpSession session) {
	
		LoginResponse loginResponse = new LoginResponse();
		Integer visitorId = (Integer)session.getAttribute("visitorId");
		if(visitorId == null) {
			Date date = new Date();
			SimpleDateFormat f = new SimpleDateFormat("yyyyMMdd");
			String dateStr = f.format(date);
			
			visitorId = Integer.parseInt(dateStr.concat("00"));
		}
		User user = new User();
		user.setUsername("游客"+visitorId.toString());
		userService.insert(user);
		
		user = userService.getById(user.getId());
		
		session.setAttribute("visitorId", visitorId+1);
		session.setAttribute("user", user);
		
		loginResponse.setUser(user);
		loginResponse.setStatus("success");
		return loginResponse;
		
	}
	
	@RequestMapping("userMenu")
	@ResponseBody
	public LoginResponse getUserMenu(String username,String password,String Code){
		User user = userService.login("root", "111");
		LoginResponse loginResponse = new LoginResponse();
		if(user != null) {
			loginResponse.setUser(user);
			
			return loginResponse;
		}else {
			return null;
		}
	}
	
	@RequestMapping("code")
	@ResponseBody
	public void getCode(HttpServletResponse response,HttpSession session) throws IOException {
		//创建图片，设置图片大小和类型
		BufferedImage buffImg = new BufferedImage(50, 30, BufferedImage.TYPE_INT_RGB);
		//得到画布
		Graphics g = buffImg.getGraphics();
		//创建字体
		Font font = new Font("宋体", Font.BOLD, 16);
		//为画布设置字体
		g.setFont(font);
		
		String code = "";
		Random r = new Random();
		for(int i = 1;i <= 4;i++) {
			code += r.nextInt(10);
		}	
		session.setAttribute("code", code);
		System.out.println(session.getAttribute("code"));
		//向画布从写入字符串
		g.drawString(code,10,25);
		//设置响应类型为：图片
		response.setContentType("image/jpeg");
		
		ServletOutputStream stream = response.getOutputStream();
		//使用ImageIO工具类，把图片按照指定的格式写入到响应流中
		ImageIO.write(buffImg, "jpeg", stream);
		//关闭响应流
		stream.close();
	}
}
