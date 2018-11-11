package controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import pojo.Note;

import service.NoteService;

@Controller
public class NoteController {

	@Autowired
	private NoteService noteSsevice;
	
	/*
	 * 查找所有note    新增条件查询,根据user_id查询 和选择时间
	 */
	@RequestMapping("selectAllNote")
	public String selectAllNote(HttpServletRequest request){
		Note note = new Note();
		String id = request.getParameter("user_id");
		if(id!=null&&id!=""){
			note.setUser_id(Integer.parseInt(id));
		}
		String date = request.getParameter("date");
		if(date!=null&&date!=""){
			note.setDate(date);
		}
		//System.out.println(note.getDate()+note.getUser_id());
		List<Note> noteList = noteSsevice.selectAllNote(note);
		request.getSession().setAttribute("noteList", noteList);
		return "allnote.jsp";
	}
}
