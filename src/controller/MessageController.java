package controller;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import pojo.Message;

import service.MessageService;

@Controller
public class MessageController {

	@Autowired
	private MessageService messageService;
	/*
	 * 添加信息表
	 */
	@RequestMapping("insertMessage")
	public void InsertMessage(HttpServletRequest request,HttpServletResponse response)throws Exception{
		Message message = new Message();
		PrintWriter out = response.getWriter();
		message.setUser_id((Integer.parseInt(request.getParameter("id"))));
		message.setText(request.getParameter("text"));
		System.out.println(message.getText());
		if(messageService.insertMessage(message)>0){
			//ok
			out.print("<script>alert('添加成功!')</script>");
		}else {
			//no
			out.print("<script>location='http://baidu.com'</script>");
		}
	}
}
