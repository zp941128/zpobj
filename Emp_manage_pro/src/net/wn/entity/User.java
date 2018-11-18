package net.wn.entity;

public class User {
	private int id;
	private String account;
	private String username;
	private String password;
	private String type;
	public User(int id, String account, String username, String password, String type) {
		super();
		this.id = id;
		this.account = account;
		this.username = username;
		this.password = password;
		this.type = type;
	}
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", account=" + account + ", username=" + username + ", password=" + password
				+ ", type=" + type + "]";
	}
	
	
}
