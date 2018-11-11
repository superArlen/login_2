package controller;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.alibaba.fastjson.JSON;
import pojo.Record;
import pojo.Vip;
import service.RecordService;
import service.VipService;

@Controller
public class RecordController {
	@Autowired
	private RecordService recordService;
	@Autowired
	private VipService vipService;
	/*
	 * 查询所有会员充值记录
	 */
	@RequestMapping("selectAllRecord")
	public String selectRecord(HttpServletRequest request){
		List<Record> recordList = recordService.selectRecord();
		request.getSession().setAttribute("recordList", recordList);
		return "allrecord.jsp";
	}

	
	/* Ajax
	 * 查询用户名是否存在
	 */
	@RequestMapping("ajaxRecord")
	public void ajaxRecord(HttpServletRequest request,HttpServletResponse response) throws Exception{
		request.setCharacterEncoding("UTF-8");
//		Vip vip = new Vip();
//		vip.setName(request.getParameter("name"));
		String name = request.getParameter("name");
		//System.out.println(vip.getName());
		Map<String, Object> mapJson = new HashMap<String, Object>();
		response.setContentType("text/html;charset=UTF-8");
//		PrintWriter out = response.getWriter();
		Vip vip = vipService.selByRecord(name);
		if(vip!=null){
			mapJson.put("msg", "你好:"+vip.getName()+"!    当前余额:   "+vip.getRemain()+"   元");
		}else {
			mapJson.put("msg", "非会员用户!");
		}
		String resultJson = JSON.toJSONString(mapJson);
		//System.out.println(resultJson);
		response.getWriter().print(resultJson);
	}
	/*
	 * 添加会员充值记录
	 */
	@RequestMapping("addRecord")
	public String addRecord(HttpServletRequest request, HttpServletResponse response) throws Exception{
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		int userid = Integer.parseInt(request.getParameter("recordUser"));//用户id
		String time = request.getParameter("recordTime");//记录时间
		String vipname = request.getParameter("recordVip");//vip_name
		Double amount = Double.parseDouble(request.getParameter("recordAmount"));//充值金额
		//System.out.println(userid+"++"+time+"++"+vipname+"++"+amount);
		//判断输入的用户名是不是会员
		Vip vip = vipService.selByRecord(vipname);
		if(vip!=null){
			Record record = new Record();
			record.setUser_id(userid);
			record.setAmount(amount);
			record.setTime(time);
			record.setVip_id(vip.getId());
			//System.out.println(record.getUser_id()+"++"+record.getAmount()+"++"+record.getTime()+"++"+record.getVip_id()+"record信息");
			//如果是会员, 1首先判断这个会员的余额有多少?需要把充值的金额累计 .2添加充值记录表
					//以下是第 1 步操作
			//获取这个VIP余额的信息.	更改这个vip 的余额
			//System.out.println(vip.getRemain()+"这个vip余额");
			//System.out.println(vip.getId()+"这个vip的id");
			vip.setRemain(vip.getRemain()+record.getAmount());
				if(vip.getRemain()>=1000){
					PrintWriter out = response.getWriter();
					//out.print("<script>layer.msg('充值金额不能大于1000元')</script>");
					out.print("<script>alert('充值金额不能大于1000元')</script>");
					out.print("<script>location='record.jsp'</script>");
					out.flush();
					out.close();
				}
			
			//System.out.println(vip.getRemain()+"这个值");
			vipService.uodateVipRemain(vip);
					//以下是第2步操作	
			int count = recordService.addRecord(record);
			if(count>0){
				return "selectAllRecord.do";//添加成功跳转到查找所有记录方法.
				//response.sendRedirect("selectAllRecord.do");
			}else {
				return "redirect:record.jsp";
				//response.sendRedirect("record.jsp");
			}
		}else {
			return "redirect:record.jsp";
			//response.sendRedirect("record.jsp");
		}
	}
	
}
