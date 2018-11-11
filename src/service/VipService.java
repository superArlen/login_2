package service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pojo.Vip;

import utils.VipPageUtils;

import dao.VipDao;
@Service
public class VipService {
	@Autowired
	private VipDao vipDao;

	
	
	/*
	 * 验证会员是否存在,更改vip表的余额
	 */
	public int uodateVipRemain(Vip vip){
		return vipDao.uodateVipRemain(vip);
	}
	/*
	 * 充值会员,验证是否存在
	 */
	public Vip selByRecord(String name){
		return vipDao.selByRecord(name);
	}
	
	
	
	
	/*
	 * 查找一个vip,修改,操作信息添加到note里
	 */
	public Vip getOneVip(int id){
		return vipDao.getOneVip(id);
	}
	public int updateVip(Vip vip){
		return vipDao.updateVip(vip);
	}
	
	
	
	
	
	
	
	
	
	
	
	/*
	 * 分页逻辑
	 */
	public VipPageUtils findByPage(VipPageUtils vipPU,Vip vip ){
		//获取符合信息的数量
		int count = vipDao.findCount(vip);
		vipPU.setCounts(count);
		//计算总页数
		if(count>0){
			//计算总页数      
			vipPU.setPages(count%vipPU.getSize()==0?(count/vipPU.getSize()):(count/vipPU.getSize()+1));
		}
		//判断当前页数的页数性
		if(vipPU.getPage()<1)vipPU.setPage(1);
		if(vipPU.getPage()>vipPU.getPages())vipPU.setPage(vipPU.getPages());
		//设置分页数据
		vip.setIndex((vipPU.getPage()-1)*vipPU.getSize());
		vip.setSize(vipPU.getSize());
		//查询当前页面集合
		vipPU.setVipList(vipDao.findByPage(vip));
		return vipPU;
	}
}
