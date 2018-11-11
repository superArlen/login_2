package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pojo.User;
import pojo.Vip;
import utils.MD5EncodingUtils;
import dao.UserDao;

@Service
public class UserService {
	@Autowired
//	@Qualifier("userDao")
	private UserDao userDao;
	
	
	
	
	public int delUser(int id){
		return userDao.delUser(id);
	}

	
	
	
	/*
	 * 用于分页
	 */
	public List<User> selectByPage(User user){
		return userDao.selectByPage(user);
	}
	
	
	
	
	/*
	 * 根据id 查找用户用于修改
	 */
	public User selectById(int id){
		return userDao.selectById(id);
	}
	public int updateAdmin(User user){
		return userDao.updateAdmin(user);
	}
	
	
	
	
	
	
	/*
	 * 用户登陆的方法
	 */
	public User userLogin(User user) throws Exception{
		//登录之前添加加密方法,匹配数据库
		user.setPassword(MD5EncodingUtils.EncodeByMD5(user.getPassword()));
//		System.out.println("admin:"+user.getPassword());
//		System.out.println("tom:"+user.getPassword());
//		System.out.println("123:"+user.getPassword());
//		System.out.println("1234:"+user.getPassword());
//		System.out.println("666666:"+user.getPassword());
//		System.out.println("111:"+user.getPassword());
		
		return userDao.findUserByNameAndPwd(user);
	}
	/*
	 * 用户注册业务
	 */
	//@Transactional
	public int userRegister(User user) throws Exception{
		user.setPassword(MD5EncodingUtils.EncodeByMD5(user.getPassword()));
		if(userDao.addUser(user)>0){
			return 1;
		}else {
			return 0 ;
		}
	}
	/*
	 * Ajax验证
	 */
	
	public int userAjax(User user){
		return userDao.ajaxName(user);
	}
	
	/*
	 * 查找所有 管理员
	 */
	
	public List<User> selectByStatus(){
		return userDao.selectByStatus();
	}
	
	
	
}
