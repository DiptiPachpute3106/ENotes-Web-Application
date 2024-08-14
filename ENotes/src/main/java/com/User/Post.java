package com.User;

import java.sql.Timestamp;

public class Post {
	
	private int id;
	private String title;
	private String content;
	private Timestamp date;
	private UserDetails user;
	public Post(int id, String title, String content, Timestamp date, UserDetails user)
	{
		super();
		this.id = id;
		this.title = title;
		this.content = content;
		this.date = date;
		this.user = user;
	}
	public Post() {
		super();
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
	public Timestamp getDate() {
		return date;
	}
	public void setDate(Timestamp date) {
		this.date = date;
	}
	public UserDetails getUser() {
		return user;
	}
	public void setUser(UserDetails user) {
		this.user = user;
	}
	@Override
	public String toString() {
		return "Post [id=" + id + ", title=" + title + ", content=" + content + ", date=" + date + ", user=" + user
				+ "]";
	}
	
	
}
