package dao;

import java.util.List;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import pojo.Message;
import pojo.Role;

@Repository("roleDao")
public class RoleDao extends SqlSessionDaoSupport {
/*
 * 为dao注入SqlSessionFactory组件
 */
	@Autowired
	public void setSessionFactory(SqlSessionFactory s){
		super.setSqlSessionFactory(s);
	}
	
	/*
	 * 添加角色
	 */
	public int addRole(Role role){
		return getSqlSession().insert("nsRole.addRole",role);
		
	}
	
	
	/*
	 * 查找一个role用于修改
	 */
	public Role selectOneRole(int id){
		return getSqlSession().selectOne("nsRole.selectOneRole", id);
	}
	public int updateRole(Role role){
		return getSqlSession().update("nsRole.updateRole", role);
	}
	
	
	
	
	/*
	 * 查找所有role数据库
	 */
	public List<Role> selectAllRole(){
		return getSqlSession().selectList("nsRole.selectAllRole");
	}
}
