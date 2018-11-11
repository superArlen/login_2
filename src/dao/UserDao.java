package dao;

import java.util.List;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import pojo.User;

@Repository("userDao")
public class UserDao extends SqlSessionDaoSupport{
	/*
	 * 为dao注入SqlSessionFactory组件
	 */
	@Autowired
	public void setSessionFactory(SqlSessionFactory fac){
		super.setSqlSessionFactory(fac);
	}
	
	
	public int delUser(int id){
		return getSqlSession().delete("nsUser.delUser", id);
	}
	
	
	
	/*
	 * 查找分页
	 */
	public List<User> selectByPage(User user){
		return getSqlSession().selectList("nsUser.ByPage",user);
	}
	
	
	
	
	
	/*
	 * 根据id 查找管理员用于修改
	 */
	public User selectById(int id){
		return getSqlSession().selectOne("nsUser.selectById",id);
	}
	public int updateAdmin(User user){
		return getSqlSession().update("nsUser.updateAdmin", user);
	}
	
	
	/*
	 * 根据用户名和密码 查询指定用户
	 */
	public User findUserByNameAndPwd(User user){
		return getSqlSession().selectOne("nsUser.findUserByLogin", user);
	}
	/*
	 * 注册方法
	 */
	
	public int addUser(User user){
		return getSqlSession().insert("nsUser.addUser", user);
	}
	
	/*
	 * Ajax验证
	 */
	public int ajaxName(User user){
		return getSqlSession().selectOne("nsUser.Ajax1", user);
	}
	/*
	 * 查找所有 管理员 集合
	 */
	public List<User> selectByStatus(){
		return getSqlSession().selectList("nsUser.findByStatus");
	}
	
	
	
}
