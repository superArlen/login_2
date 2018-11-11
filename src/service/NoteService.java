package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.NoteDao;

import pojo.Note;

@Service
public class NoteService {
	@Autowired
	private NoteDao noteDao;
	
	/*
	 * 查找所有note
	 */
	public List<Note> selectAllNote(Note note){
		return noteDao.selectAllNote(note);
	}
	
	/*
	 * 添加note
	 */
	public int insertNote(Note note){
		return noteDao.insertNote(note);
	}
	
}
