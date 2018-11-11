package controller;

import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import pojo.Role;

import service.RoleService;

@Controller
public class RoleController {

	@Autowired
	private RoleService roleService;
	
	/*
	 * 执行添加或者修改
	 */
	@RequestMapping("roleUpdate_Add")
	public String roleUpdata_Add(HttpServletRequest request,HttpServletResponse response) throws Exception{
		request.setCharacterEncoding("UTF-8");
		//response.setContentType("text/html;charset=UTF-8");
		String op = request.getParameter("op");
		Role role = new Role();
		if(op.equals("update")){
			String name = request.getParameter("roleName");
			int id = Integer.parseInt(request.getParameter("id"));
			role.setId(id);
			role.setName(name);
			roleService.updateRole(role);
			List<Role> roleList = roleService.selectAllRole();
			request.getSession().setAttribute("roleList", roleList);
			return "menumanagement.jsp";
		}else if(op.equals("add")) {
			String name = request.getParameter("roleName");
			role.setName(name);
			roleService.addRole(role);
			List<Role> roleList = roleService.selectAllRole();
			request.getSession().setAttribute("roleList", roleList);
			return "menumanagement.jsp";
		}
		return null;
	}
	
	
	
	/*
	 * 添加和修改role
	 */
	@RequestMapping("addAndupdate")
	public String addAndupdate(HttpServletRequest request){
		int id=Integer.parseInt(request.getParameter("id"));
		if(id==-1){//如果id==-1-->新增
			return "role_add_update.jsp";
			
		}else {//修改
			Role role = roleService.selectOneRole(id);
			request.setAttribute("role", role);
			return "role_add_update.jsp";
		}
		
	}
	
	
	
	
	/*
	 * 查找所有role
	 */
	@RequestMapping("selectAllRole")
	public String selectAllRole(HttpServletRequest request){
		List<Role> roleList = roleService.selectAllRole();
		request.getSession().setAttribute("roleList", roleList);
		return "menumanagement.jsp";
	}
	
}
