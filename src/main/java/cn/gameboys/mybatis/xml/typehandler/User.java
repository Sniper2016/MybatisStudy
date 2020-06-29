package cn.gameboys.mybatis.xml.typehandler;

import java.util.List;

import org.apache.ibatis.type.Alias;

@Alias(value = "user")
public class User {
    private int id;
    private String name;
    private List<String> pwd;

    public User() {
    }



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



	public List<String> getPwd() {
		return pwd;
	}



	public void setPwd(List<String> pwd) {
		this.pwd = pwd;
	}



	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", pwd=" + pwd + "]";
	}


}
