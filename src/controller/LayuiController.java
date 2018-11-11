package controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;

import pojo.User;

import service.UserService;
import utils.LayuiResult;
@Controller
public class LayuiController {
	@Autowired
	private UserService userService;
	
	@RequestMapping("list")
	public String list(){
		System.out.println("1111111111111");
		return "layui.jsp";
	}
	
	@RequestMapping("listData")
	public void listData(HttpServletRequest request,HttpServletResponse response, Integer page,Integer limit,User user) 
			throws Exception{
		response.setContentType("text/html;charset=UTF-8");
	//	System.out.println(page+"---"+limit);
		LayuiResult<User> result = new LayuiResult<User>();		
		
		User u = new User();
		System.out.println(u.getName()+"================");
		u.setIndex((page-1)*limit);//开始下标
		u.setSize(limit);//长度
		List<User> list = userService.selectByPage(u);
		
		//必须的四个数据
		result.setCode(0);
		result.setCount(50);
		result.setData(list);
		result.setMsg("");
		String resultJson = JSON.toJSONString(result);
		//System.out.println(resultJson);
//		return resultJson;
		response.getWriter().print(resultJson);
	}
}
