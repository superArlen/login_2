package controller;

import java.io.File;
import java.util.UUID;



import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FilenameUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;



@Controller
public class Up_lxController {

	
	@RequestMapping("addStore.do")
	public String addStore(HttpServletRequest request, MultipartFile file) throws Exception{
		 //使用UUID重命名图片 避免重复
        String name = UUID.randomUUID().toString().replaceAll("-", "");
        //获取文件扩展名
        String ext = FilenameUtils.getExtension(file.getOriginalFilename());
        //设置图片上传路径
        String url = request.getSession().getServletContext().getRealPath("/images");
        //以绝对路径保存重命名后的图片
        file.transferTo(new File(url + "/" + name + "." + ext));
      //把图片路径存到数据库
      //  storeIn.setIdImgFront("http://localhost:6060/" + "upload/" + name + "." + ext);
        
        //给状态码设置默认值
       // storeIn.setStatus(0);
       // storeService.addStore(storeIn);
        return "success.jsp";
		
		
	}
}
