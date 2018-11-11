package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.RecordDao;

import pojo.Record;

@Service
public class RecordService {
	@Autowired
	private RecordDao recordDao;
	
	/*
	 * 添加record
	 */
	public int addRecord(Record record){
		return recordDao.addRecord(record);
	}
	
	
	
	
	/*
	 * 查询所有record记录
	 */
	public List<Record> selectRecord(){
		return recordDao.selectRecord();
	}
	

}
