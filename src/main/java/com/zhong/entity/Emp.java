package com.zhong.entity;

/**
 * @author zhong
 * @date 2019年7月12日 上午11:53:57
 * 
 */
public class Emp {

	private int id;
	private String realname;

	private String email;

	/**
	 * 
	 */
	private int user_id;

	/**
	 * 用户对象
	 */
	private User user;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getRealname() {
		return realname;
	}

	public void setRealname(String realname) {
		this.realname = realname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public User getUser() {
		return user;
	}

	public Emp setUser(User user) {
		this.user = user;
		return this;
	}

}
