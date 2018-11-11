package dao;

import java.util.List;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import pojo.Vip;
@Repository("vipDao")
public class VipDao extends SqlSessionDaoSupport {

	/*
	 * 为dao注入SqlSessionFactory组件
	 */
	@Autowired
	public void setSessionFactory(SqlSessionFactory fac){
		super.setSqlSessionFactory(fac);
	}
	
	/*
	 * 验证会员是否存在,更改vip表的余额
	 */
	public int uodateVipRemain(Vip vip){
		return getSqlSession().update("nsVip.uodateVipRemain",vip );
	}
	/*
	 * 充值会员,验证是否存在
	 */
	public Vip selByRecord(String name){
		return getSqlSession().selectOne("nsVip.selByRecord",name);
	}
	
	
	/*查询一个vip信息
	 * 修改会员信息同时插入信息到note表里
	 */
	public Vip getOneVip(int id){
		return getSqlSession().selectOne("nsVip.getOneVip", id);
	}
	public int updateVip(Vip vip){
		return getSqlSession().update("nsVip.updateVip", vip);
	}
	
	
	
	
	//分页查询
		//获取符合条件的总个数
	public int findCount(Vip vip){
		return getSqlSession().selectOne("nsVip.pageCount", vip);
	}
	public List<Vip> findByPage(Vip vip){
		return getSqlSession().selectList("nsVip.findByPage", vip);
	}
	
	
}
