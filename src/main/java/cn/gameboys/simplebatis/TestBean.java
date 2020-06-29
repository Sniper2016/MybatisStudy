package cn.gameboys.simplebatis;

/**
 * 
* @Description: 
* @author:www.gameboys.cn
* @date:2020年6月29日 下午3:21:19
 */
public class TestBean {
	private int id;
	private String name;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "TestBean [id=" + id + ", name=" + name + "]";
	}
	

}
