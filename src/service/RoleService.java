package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pojo.Message;
import pojo.Role;

import dao.MessageDao;
import dao.RoleDao;

@Service
public class RoleService {
	@Autowired
	private RoleDao roleDao;
	
	/*
	 * 添加角色
	 */
	public int addRole(Role role){
		return roleDao.addRole(role);
	}
	/*
	 * 查找一个role用于修改
	 */
	public Role selectOneRole(int id){
		return roleDao.selectOneRole(id);
	}
	public int updateRole(Role role){
		return roleDao.updateRole(role);
	}
	
	
	
	
	/*
	 * 查找角色表
	 */
	public List<Role> selectAllRole(){
		return roleDao.selectAllRole();
	}
}
