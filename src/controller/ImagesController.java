package controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import pojo.Images;

import service.ImagesService;

@Controller
public class ImagesController {
	@Autowired
	private ImagesService imagesService;
	
	
	/*
	 * 查询所有admin头像
//	 */
//	@RequestMapping("selectAdminImahes")
//	public String selectAdminImages(HttpServletRequest request){
//		List<Images> imagesAdminList = imagesService.selectAllImages();
//		request.getSession().setAttribute("imagesAdminList", imagesAdminList);
//		return "redirect:welcome.jsp";
//	
//	}
	
	/*
	 * 查询所有images
	 */
	@RequestMapping("selectAllImages")
	public String selectAllImages(HttpServletRequest request){
		List<Images> imagesList = imagesService.selectAllImages();
		request.getSession().setAttribute("imagesList", imagesList);
		return "redirect:welcome.jsp";
	}
	
	//上传
	@RequestMapping("up.do")
	public String upload(HttpServletRequest request,
			//普通元素(desc可以不定义) 文件元素必须定义
			@RequestParam("file") MultipartFile file) throws Exception{
		//先判断是否存在文件
		if(!file.isEmpty()){
			//获取服务器保存上上传文件的目录的绝对路径
			String path = request.getSession().getServletContext().getRealPath("/images/");
			
			
			
			//获取用户上传的文件名
			String fileName = file.getOriginalFilename();
			//构建保存文件
			File saveFile = new File(path, fileName);
			//判断上传目录是否存在,不存在就创建
			if(!saveFile.getParentFile().exists()){
				//保存路径的上一级文件的文件夹
				saveFile.getParentFile().mkdirs();//创建文件夹
			}
			//上传文件(保存)
			file.transferTo(saveFile);
			//将文件名储存在request 中,用于在加多页面显示下载参数(文件名)
			request.setAttribute("fileName", fileName);
		}
		/*
		 * 正常情况下下载应该是从数据库里下载
		 */
			return "success.jsp";
	}
	
	//下载
	@RequestMapping("down.do")
	public ResponseEntity<byte[]> download(HttpServletRequest requset,String fileName) throws Exception{
	  // 获取请求中下载文件的名称（处理中文转码）
	  String newFileName = new String(fileName.getBytes("ISO-8859-1"),"UTF-8");
	  // 获取服务器下载目录的绝对路径
	  String path = requset.getSession().getServletContext().getRealPath("/uploadfiles/");
	  // 构建下载文件
	  File file = new File(path,newFileName);
	  // 读取下载文件到byte[]对象中
	  InputStream is = new FileInputStream(file);
	  byte[] body = new byte[is.available()];
	  is.read(body);
	  // 创建响应响应消息头信息对象
	  HttpHeaders headers = new HttpHeaders();
	  headers.add("Content-Disposition", "attachment;filename="+fileName);
	  HttpStatus statusCode = HttpStatus.OK;
	  // 创建响应实体对象
	  ResponseEntity<byte[]> entity = new ResponseEntity<byte[]>(body, headers, statusCode);
	  // 响应实体
	  return entity;
	}
	
	
}
