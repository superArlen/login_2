package pojo;

public class Images {

	private Integer id;
	private Integer user_id;
	private String img_weiz;
	
	
	
	public Images(){}
	public Images(Integer id, Integer user_id, String img_weiz) {
		super();
		this.id = id;
		this.user_id = user_id;
		this.img_weiz = img_weiz;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getUser_id() {
		return user_id;
	}
	public void setUser_id(Integer user_id) {
		this.user_id = user_id;
	}
	public String getImg_weiz() {
		return img_weiz;
	}
	public void setImg_weiz(String img_weiz) {
		this.img_weiz = img_weiz;
	}
	
	
	
	
	
	
	
}
