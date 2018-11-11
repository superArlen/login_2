package controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import pojo.Images;
import pojo.User;
import service.ImagesService;

@Controller
public class UpLoadController {
	@Autowired
	private ImagesService imagesService;
	
	
	/*
	 * 上传头像,更改数据库信息
	 */
	@RequestMapping("up1.do")
	public String up1(HttpServletRequest request,String desc,HttpServletResponse response,
			//普通元素(desc可以不定义) 文件元素必须定义
			@RequestParam("file") MultipartFile file) throws Exception{
		//先判断是否存在文件
		if(!file.isEmpty()){
			//获取服务器保存上上传文件的目录的绝对路径
			String path = request.getSession().getServletContext().getRealPath("/uploadfiles/");
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
			request.setAttribute("path", path);
			//System.out.println("http://localhost:6060/20180708_login/uploadfiles/"+fileName);
			//把路径储存到数据库里
			//目前只有超级管理员有头像,后期...
			//获取作用域里的管理员id
			User user =(User)request.getSession().getAttribute("u");
			//System.out.println(user.getId());
			Images img = new Images();
			img.setUser_id(user.getId());
			img.setImg_weiz("http://localhost:6060/20180708_login/uploadfiles/"+fileName);
			System.out.println(img.getImg_weiz());
			if(user.getId()==1){//超级管理员
				if(imagesService.updateWeiz(img)>0){
					return "selectAllImages.do";
				}
			}else {
				//非超级管理员待实现
			}
		}
			return "welcome.jsp";
	}
	
	
	
	
	
	
	
	
	
	
	
	

	@RequestMapping("upload.do")
	public String upload(HttpServletRequest request,String desc,
			//普通元素(desc可以不定义) 文件元素必须定义
			@RequestParam("file") MultipartFile file) throws Exception{
		//先判断是否存在文件
		if(!file.isEmpty()){
			//获取服务器保存上上传文件的目录的绝对路径
			String path = request.getSession().getServletContext().getRealPath("/uploadfiles/");
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
			request.setAttribute("path", path);
//			System.out.println("文件名:"+fileName);
//			System.out.println("文件路径:"+path);
//			System.out.println(path+"   "+fileName);
		}
		/*
		 * 正常情况下下载应该是从数据库里下载
		 * 
		 */
			return "success.jsp";
	}
	@RequestMapping("download.do")
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
