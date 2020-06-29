package cn.gameboys.mybatis.xml.iftest;

import java.util.Date;



public class Blog {
    private String id;
    private String title;
    private String author;
    private Date creatTime; //属性名和字段名不一致
    private int views;

    public Blog() {
    }

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public Date getCreatTime() {
		return creatTime;
	}

	public void setCreatTime(Date creatTime) {
		this.creatTime = creatTime;
	}

	public int getViews() {
		return views;
	}

	public void setViews(int views) {
		this.views = views;
	}

	@Override
	public String toString() {
		return "Blog [id=" + id + ", title=" + title + ", author=" + author + ", creatTime=" + creatTime + ", views=" + views + "]";
	}
    
    
    
    
}
