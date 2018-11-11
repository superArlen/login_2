package pojo;

public class Vip {
	private Integer id;
	private String name;
	private Integer number;
	private Double remain;
	private Integer type;
	private Integer index;
	private Integer size;
	
	
	public Vip(){}
	public Vip(Integer id, String name, Integer number, Double remain,
			Integer type, Integer index, Integer size) {
		super();
		this.id = id;
		this.name = name;
		this.number = number;
		this.remain = remain;
		this.type = type;
		this.index = index;
		this.size = size;
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
	public Integer getNumber() {
		return number;
	}
	public void setNumber(Integer number) {
		this.number = number;
	}
	public Double getRemain() {
		return remain;
	}
	public void setRemain(Double remain) {
		this.remain = remain;
	}
	public Integer getType() {
		return type;
	}
	public void setType(Integer type) {
		this.type = type;
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
	
	
	
	
}
