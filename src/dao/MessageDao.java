package dao;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import pojo.Message;

@Repository("messageDao")
public class MessageDao extends SqlSessionDaoSupport {
/*
 * 为dao注入SqlSessionFactory组件
 */
	@Autowired
	public void setSessionFactory(SqlSessionFactory s){
		super.setSqlSessionFactory(s);
	}
	
	/*
	 * 添加留言数据库
	 */
	public int insertMessage(Message message){
		return getSqlSession().insert("nsMessage.insertMessage", message);
	}
}
