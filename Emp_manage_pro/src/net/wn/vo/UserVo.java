package net.wn.vo;

public class UserVo {
	private int id;
	private String account;
	private String username;
	private int password;
	private int type;
	public UserVo(int id, String account, String username, int password, int type) {
		super();
		this.id = id;
		this.account = account;
		this.username = username;
		this.password = password;
		this.type = type;
	}
	public UserVo() {
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
	public int getPassword() {
		return password;
	}
	public void setPassword(int password) {
		this.password = password;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	@Override
	public String toString() {
		return "UserVo [id=" + id + ", account=" + account + ", username=" + username + ", password=" + password
				+ ", type=" + type + "]";
	}
	
}
