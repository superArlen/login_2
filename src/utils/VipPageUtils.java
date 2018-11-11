package utils;

import java.util.List;

import pojo.Vip;

public class VipPageUtils {

	private Integer page=1;//默认当前是第几页
	private Integer size=5;//默认每页显示个数
	private Integer counts=1;//默认复合条件的数量
	private Integer pages=1;//默认共有几页
	private List<Vip> vipList;//当前页面显示的信息
	
	
	
	public VipPageUtils(){}
	public VipPageUtils(Integer page, Integer size, Integer counts,
			Integer pages, List<Vip> vipList) {
		super();
		this.page = page;
		this.size = size;
		this.counts = counts;
		this.pages = pages;
		this.vipList = vipList;
	}
	public Integer getPage() {
		return page;
	}
	public void setPage(Integer page) {
		this.page = page;
	}
	public Integer getSize() {
		return size;
	}
	public void setSize(Integer size) {
		this.size = size;
	}
	public Integer getCounts() {
		return counts;
	}
	public void setCounts(Integer counts) {
		this.counts = counts;
	}
	public Integer getPages() {
		return pages;
	}
	public void setPages(Integer pages) {
		this.pages = pages;
	}
	public List<Vip> getVipList() {
		return vipList;
	}
	public void setVipList(List<Vip> vipList) {
		this.vipList = vipList;
	}
	
	
	
	
	
}
