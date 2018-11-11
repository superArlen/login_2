package pojo;

import java.util.Date;

public class User {
	private Integer id;
	private String name;
	private String password;
	private Integer age;
	private Date birthday;
	private Integer status;
	private Integer index; //起始下标
	private Integer size; //长度
	
	
	
	
	
	public User(Integer index, Integer size) {
		super();
		this.index = index;
		this.size = size;
	}
	public Integer getIndex() {
		return index;
	}
	public void setIndex(Integer index) {
		this.index = index;
	}
	public Integer getSize() {
		return size;
	}
	public void setSize(Integer size) {
		this.size = size;
	}
	public User(Integer status) {
		super();
		this.status = status;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public User(){}
	public User(Integer id, String name, String password, Integer age,
			Date birthday) {
		super();
		this.id = id;
		this.name = name;
		this.password = password;
		this.age = age;
		this.birthday = birthday;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	
	
	
	
	
}
