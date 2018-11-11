package controller;


import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import pojo.Images;
import pojo.User;
import service.ImagesService;
import service.UserService;

@Controller
public class fontController {
	@Autowired
	private UserService userService;
	@Autowired
	private ImagesService imagesService;
	
	@RequestMapping("All.do")
	public String All(HttpServletRequest request){
		//查找所有管理员信息
		List<User> statusList = userService.selectByStatus();
		//
//			for (int i = 0; i < statusList.size(); i++) {
//				User u = new User();
//				u.setAge(i);
//				statusList.add(u);
//			}
//			for (int j = 0; j < statusList.size(); j++) {
//				System.out.println(statusList.get(j).getAge());
//			}
//		
		
		
		
		
		//
		
		
		
		
		
		request.getSession().setAttribute("statusList",statusList);
		//查找所有头像信息
		List<Images> imagesList =imagesService.selectAllImages();
		//System.out.println(imagesList.size());
		request.getSession().setAttribute("imagesList", imagesList);
		//查找所有管理员头像信息
		List<Images> imagesAdminList =imagesService.selectAdminImages();
		request.getSession().setAttribute("imagesAdminList", imagesAdminList);
		//查询所有vip用户分页
		//List<Vip> vipList = vipService.findByPage(vipPU, vip);
		
		
		
		/*
		 * 必须自登陆的同时显示这个user可以使用的menu;所有要根据id查找.
		 
		//获取所有菜单信息
		List<Menu> menuList = menuService.selectAllMenu();
		request.getSession().setAttribute("menuList", menuList);
		*/
		
		
		return "login.jsp";
	}
	
	
	
}
