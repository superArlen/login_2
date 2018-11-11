package controller;

import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.alibaba.fastjson.JSON;

import pojo.User;
import service.UserService;

@Controller
public class UserController {
	@Autowired
	private UserService userService;
	
	
	/*
	 * 退出方法
	 */
	@RequestMapping("exitUser")
	public String exitUser(HttpServletRequest request){
		request.getSession().removeAttribute("u");
		return "redirect:login.jsp";
	}
	
	
	
	@RequestMapping("delUser")
	public void delUser(HttpServletRequest request){
		int id = Integer.parseInt(request.getParameter("id"));
		System.out.println(id+"huoquID");
		userService.delUser(id);
	}
	
	
	
	
	
	
	
	
	@RequestMapping("getMap1")
	public void getAllAdmin1(HttpServletResponse response,HttpServletRequest request,
			@RequestParam("limit") int limit
			) throws Exception{
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		System.out.println("返回Map集合");
		System.out.println(limit);
		HashMap<String, Object> resultMap1 = new HashMap<String, Object>();
		// 获取集合
		User user = new User(1,limit);
		List<User> userlist = userService.selectByPage(user);
		// 把需要的数据放到map里
		resultMap1.put("code", 0);
		resultMap1.put("msg", "");
		resultMap1.put("count", userlist.size());
		resultMap1.put("data", userlist);
		System.out.println("resultMap1"+resultMap1);
		String resultJson = JSON.toJSONString(resultMap1);
		System.out.println("-======================");
		System.out.println("resultJson"+resultJson);
		response.getWriter().print(resultJson);
	}
	
	
	
	
	/*
	 * 把数据转化成json格式,用于渲染
	 */
	@RequestMapping("getMap")
	public void getAllAdmin(HttpServletResponse response,HttpServletRequest request,
			Integer page,Integer limit
			) throws Exception{
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		System.out.println("返回Map集合");
		System.out.println(page);
		System.out.println(limit);
		HashMap<String, Object> resultMap1 = new HashMap<String, Object>();
		// 获取集合
		List<User> userlist = userService.selectByStatus();
		// 把需要的数据放到map里
		resultMap1.put("code", 0);
		resultMap1.put("msg", "");
		resultMap1.put("count", 100);
		resultMap1.put("data", userlist);
		System.out.println("resultMap1"+resultMap1);
		String resultJson = JSON.toJSONString(resultMap1);
		System.out.println("-======================");
		System.out.println("resultJson"+resultJson);
		response.getWriter().print(resultJson);
	}

	/*
	 * 查找一个管理员用于修改信息		没用了
	 */
	@RequestMapping("selectAdmin")
	public String selectAdemin(HttpServletRequest request) {
		int id = Integer.parseInt(request.getParameter("id"));
		User user = userService.selectById(id);
		request.setAttribute("user", user);
		return "update.jsp";
	}

	@RequestMapping("updateAdmin")
	public String updateAdmin(HttpServletRequest request,HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("UTF-8");
		User user = new User();
		user.setId(Integer.parseInt(request.getParameter("id")));
		user.setName(request.getParameter("name"));
		user.setPassword(request.getParameter("password"));
		if (userService.updateAdmin(user) > 0) {
			// 修改成
			List<User> statusList = userService.selectByStatus();
			request.getSession().setAttribute("statusList", statusList);
			return "selectByStatus.do";
		} else {
			return "update.jsp";
		}
	}

	/*
	 * 用户登陆----------------------------------------------这个
	 */
	@RequestMapping("login1")
	public void login1(HttpServletRequest request, HttpServletResponse response
	// @RequestParam("loginName") String name
	) throws Exception {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		User user = new User();
		user.setName(request.getParameter("loginName"));
		user.setPassword(request.getParameter("loginPwd"));
		request.getSession().setAttribute("Name", user.getName());
		request.getSession().setAttribute("Pwd", user.getPassword());
		//user.setStatus(Integer.parseInt(request.getParameter("status")));
		user = userService.userLogin(user);
		if (user != null) {
			request.getSession().setAttribute("u", user);
			//System.out.println("user_id+"+user.getId());
			//根据登陆的id 查找菜单权限表+++++++++++++++++++++++++++++++++++++++++++++++
			//List<MenuAdmin> menuAList = menuAdminService.selectMenuAByUserId(user.getId());
			//request.getSession().setAttribute("menuAList",menuAList);
			
			
			// 登录成功
			//out.print("<script>alert('登录成功!')</script>");
							out.print("<script>location='layui_houtai.jsp'</script>");
			/*用于测试 菜单权限 */
			//out.print("<script>location='layui_houtai.jsp'</script>");
			
			
			// return "welcome.jsp";
		} else {
			// 登录失败
			out.print("<script>alert('用户名或密码错误!登录失败!')</script>");
			out.print("<script>location='login.jsp'</script>");
		}
	}

	@RequestMapping("login.do")
	public String login(HttpServletRequest request,
			@RequestParam("loginName") String name) throws Exception {
		request.setCharacterEncoding("UTF-8");
		User user = new User();
		user.setName(name);
		user.setPassword(request.getParameter("loginPwd"));
		user = userService.userLogin(user);
		if (user != null) {
			request.getSession().setAttribute("u", user);
			return "welcome.jsp";
		} else {
			// 设置控制器处理后,跳转的页面(默认转发,可以加redirect:改为重定向)
			return "redirect:login.jsp";
		}
	}

	/*
	 * 用户注册
	 */
	@RequestMapping("register")
	public String register(HttpServletRequest request) throws Exception {
		request.setCharacterEncoding("UTF-8");
		User user = new User();
		user.setName(request.getParameter("regName"));
		user.setPassword(request.getParameter("regPwd"));
		user.setAge(Integer.parseInt(request.getParameter("regAge")));
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		user.setBirthday(sdf.parse(request.getParameter("regBirthday")));
		// 调用注册的方法
		if (userService.userRegister(user) > 0) {
			request.getSession().setAttribute("ru", user);
			return "registerOK.jsp";
		} else {
			return "redirect:register.jsp";
		}

	}

	/*
	 * Ajax验证
	 */
	@RequestMapping("ajax1.do")
	public void Ajax1(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		request.setCharacterEncoding("UTF-8");
		// 获取name值
		User user = new User();
		user.setName(request.getParameter("name"));
		//System.out.println(user.getName());
		int counts = userService.userAjax(user);
		//System.out.println(counts);
		Map<String, Object> mapJson = new HashMap<String, Object>();
		response.setContentType("text/html;charset=UTF-8");
		if (counts > 0) {
			mapJson.put("msg", "用户名存在");
		} else {
			mapJson.put("msg", "用户名可用");
		}
		String resultJson = JSON.toJSONString(mapJson);
		//System.out.println(resultJson);
		response.getWriter().print(resultJson);
	}

	/*
	 * 显示所有管理员信息
	 */
	@RequestMapping("selectByStatus.do")
	public String selectByStatus(HttpServletRequest request) {
		List<User> statusList = userService.selectByStatus();
		request.getSession().setAttribute("statusList", statusList);
		return "redirect:welcome.jsp";
	}

}
