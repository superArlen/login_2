package service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pojo.Message;

import dao.MessageDao;

@Service
public class MessageService {
	@Autowired
	private MessageDao messageDao;
	/*
	 * 添加信息表
	 */
	public int insertMessage(Message message){
		return messageDao.insertMessage(message);
	}
}
