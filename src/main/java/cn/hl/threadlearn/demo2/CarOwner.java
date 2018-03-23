package cn.hl.threadlearn.demo2;

/**
 * @author HULIN
 */
public class CarOwner {

	//车主名字
	private String name;
	//车位号
	private Integer index;
	//该用户是否有车位
	private boolean flag;
	
	public CarOwner() {}
	
	public CarOwner(String name) {
		this.name = name;
		this.flag = false;
	}
	

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getIndex() {
		return index;
	}

	public void setIndex(Integer index) {
		this.index = index;
	}

	public boolean isFlag() {
		return flag;
	}

	public void setFlag(boolean flag) {
		this.flag = flag;
	}
	
}
