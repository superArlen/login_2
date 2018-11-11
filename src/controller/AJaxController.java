package controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.alibaba.fastjson.JSON;


@Controller
public class AJaxController {
	@RequestMapping("ajax.do")
	public void ajax(HttpServletRequest request,
					 HttpServletResponse response) throws Exception{
		request.setCharacterEncoding("UTF-8");
		String name = request.getParameter("name");
		List<String> nameList = new ArrayList<String>();
		nameList.add("admin");
		nameList.add("tom");
		nameList.add("张三");
		
		Map<String, Object> mapJson = new HashMap<String, Object>();
		response.setContentType("text/html;charset=UTF-8");
		//String resultJson = null;
		if(nameList.contains(name)){
			//存在
			mapJson.put("msg", "已存在");
		}else{
			//可用
			mapJson.put("msg", "可用");
		}
		String resultJson = JSON.toJSONString(mapJson);
		//System.out.println(resultJson);
		response.getWriter().print(resultJson);
	}
}
