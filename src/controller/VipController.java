package controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.jms.Session;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;

import pojo.Note;
import pojo.User;
import pojo.Vip;

import service.NoteService;
import service.VipService;
import utils.VipPageUtils;

@Controller
public class VipController {
	@Autowired
	private VipService vipService;
	@Autowired
	private NoteService noteService;
	
	/*
	 * 查询一个vip,修改 同时插入note表记录
	 */
	
	@RequestMapping("getOneVip")
	public String getOneVip(HttpServletRequest request){
		int id = Integer.parseInt(request.getParameter("id"));
		Vip vip= new Vip();
		vip = vipService.getOneVip(id);
		//request.setAttribute("vip",vip);
		request.getSession().setAttribute("vip1", vip);
		return "updatevip.jsp";
	}
	@Transactional
	@RequestMapping("updateVip")
	public String updateVip(HttpServletRequest request) throws Exception{
		request.setCharacterEncoding("utf-8");
		String handle1="";
		String handle2="";
		String handle3="";
		String handle4="";
		//得到修改后的信息	客户姓名,卡号,余额,身份
		String vipname =  request.getParameter("vipname");
		int vipnumber = Integer.parseInt(request.getParameter("vipnumber"));
		Double vipremain = Double.parseDouble(request.getParameter("vipremain"));
		int viptype = Integer.parseInt(request.getParameter("viptype"));
		//得到需要修改的原来的信息对象
		Vip vip = (Vip)request.getSession().getAttribute("vip1");
		if(!vipname.equals(vip.getName())) handle1="姓名,";
		if(vipnumber!=vip.getNumber()) handle2="卡号,";
		if(!vipremain.equals(vip.getRemain())) handle3="余额,";
		if(viptype!=vip.getType()) handle4="身份";
		request.getSession().setAttribute("handle",handle1+handle2+handle3+handle4);
		Vip v = new Vip();
		v.setId(Integer.parseInt(request.getParameter("id")));
		v.setName(vipname);
		v.setNumber(vipnumber);
		v.setRemain(vipremain);
		v.setType(viptype);
		
		
		User u1 = new User();
		u1 = (User)request.getSession().getAttribute("u");
		if(u1==null) return "welcome.jsp";
		
		//修改之后需要把记录放进note表里 ,用户id,日期,用户id,handle
		if(vipService.updateVip(v)>0){
			Note note = new Note();
			//1-------vip_id
			note.setVip_id(v.getId());
			//2-----系统时间
			Date day=new Date();    
			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd"); 
			note.setDate(df.format(day));
			//3------user_id
			note.setUser_id(u1.getId());
			//4---------handle
			note.setHandle((request.getSession().getAttribute("handle")).toString());
//			System.out.println(note.getHandle()+"=handle");
//			System.out.println(note.getVip_id()+"=vip_id");
//			System.out.println(note.getDate()+"=date");
//			System.out.println(note.getUser_id()+"=user_id");
			//调用添加note方法
			noteService.insertNote(note);
			return "findByPage.do";
		}
		return null;
	}
	
	
	
	
	
	/*
	 * 分页模糊查询
	 */
	@RequestMapping("findByPage")
	public String findByPage(HttpServletRequest request,HttpServletResponse response) throws Exception{
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=UTF-8");
		//获取查询的条件
		Vip vip = new Vip();
		String name = request.getParameter("name1");
		String numb = request.getParameter("number1");
		
		if(name!=null&&name!=""){
			// 手工转码
			if ("GET".equals(request.getMethod())) {
				name = new String(name.getBytes("ISO-8859-1"), "UTF-8");
			}
			vip.setName(name);
		}
		if(numb!=null&&numb!=""){
			vip.setNumber(Integer.parseInt(numb));
		}
		//设置回显
		// 回显 存到作用于里
		request.setAttribute("name", vip.getName());
		request.setAttribute("number", vip.getNumber());
		
		// 获取用户请求的页数
		int page = 1;
		String pageNo = request.getParameter("page");
		if (pageNo != null && !"".equals(pageNo)) {
			page = Integer.parseInt(pageNo);
		}
		// 定义每页显示长度
		int size = 5;
		// 创建分页查询工具类
		VipPageUtils vipPU = new VipPageUtils();
		vipPU.setPage(page);
		vipPU.setSize(size);
		vipPU = vipService.findByPage(vipPU, vip);
		request.getSession().setAttribute("vipPage", vipPU);
		
		
		return "allvip.jsp";
	}
	
	
}
