package dao;

import java.util.List;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import pojo.Record;

@Repository("recordDao")
public class RecordDao extends SqlSessionDaoSupport {
		
	/*
	 * 为dao注入SqlSessionFactory组件
	 */
	@Autowired
	public void setSessionFactory(SqlSessionFactory fac){
		super.setSqlSessionFactory(fac);
	}
	
	/*
	 * 添加record表
	 */
	public int addRecord(Record record){
		return getSqlSession().insert("nsRecord.addRecord", record);
	}
	
	
	/*
	 * 查询所有record记录
	 */
	public List<Record> selectRecord(){
		return getSqlSession().selectList("nsRecord.selectRecord");
	}
	
	
	
}
