package cn.gameboys.simplebatis;

public class Student {
	private String name;
	
	//测试一下boolean类型是否在学习
	private boolean studing;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isStuding() {
		return studing;
	}

	public void setStuding(boolean studing) {
		this.studing = studing;
	}

	@Override
	public String toString() {
		return "Student [name=" + name + ", studing=" + studing + "]";
	}
	
	
	
	

}
