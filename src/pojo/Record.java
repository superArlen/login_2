package pojo;


public class Record {

	private Integer id;
	private Integer user_id;
	private Double amount;
	private String time;
	private Integer vip_id;
	private User user;
	private Vip vip;
	public Record(){}
	public Record(Integer id, Integer user_id, Double amount, String time,
			Integer vip_id, User user, Vip vip) {
		super();
		this.id = id;
		this.user_id = user_id;
		this.amount = amount;
		this.time = time;
		this.vip_id = vip_id;
		this.user = user;
		this.vip = vip;
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
	public Double getAmount() {
		return amount;
	}
	public void setAmount(Double amount) {
		this.amount = amount;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public Integer getVip_id() {
		return vip_id;
	}
	public void setVip_id(Integer vip_id) {
		this.vip_id = vip_id;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Vip getVip() {
		return vip;
	}
	public void setVip(Vip vip) {
		this.vip = vip;
	}
	
	
	
}
