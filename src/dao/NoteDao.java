package dao;

import java.util.List;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import pojo.Note;

@Repository("noteDao")
public class NoteDao extends SqlSessionDaoSupport{
	@Autowired
	public void setSessionFactory(SqlSessionFactory fac){
		super.setSqlSessionFactory(fac);
	}

	/*
	 * 查找所有note
	 */
	public List<Note> selectAllNote(Note note){
		return getSqlSession().selectList("nsNote.selectAllNote",note);
	}
	
	/*
	 * 添加note
	 */
	public int insertNote(Note note){
		return getSqlSession().insert("nsNote.insertNote",note);
	}
	
	
}
