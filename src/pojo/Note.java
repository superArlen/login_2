package pojo;

import java.util.Date;

public class Note {
	
	private Integer id;
	private Integer vip_id;
	private String date;
	private Integer user_id;
	private String handle;
	
	
	
	public Note(){}
	public Note(Integer id, Integer vip_id, String date, Integer user_id,
			String handle) {
		super();
		this.id = id;
		this.vip_id = vip_id;
		this.date = date;
		this.user_id = user_id;
		this.handle = handle;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getVip_id() {
		return vip_id;
	}
	public void setVip_id(Integer vip_id) {
		this.vip_id = vip_id;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public Integer getUser_id() {
		return user_id;
	}
	public void setUser_id(Integer user_id) {
		this.user_id = user_id;
	}
	public String getHandle() {
		return handle;
	}
	public void setHandle(String handle) {
		this.handle = handle;
	}
	
	
}
