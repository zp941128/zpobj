package net.wn.entity;

public class PositionP {
	private int id;
	private String name;
	public PositionP(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	public PositionP() {
		super();
		// TODO Auto-generated constructor stub
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
	@Override
	public String toString() {
		return "PositionP [id=" + id + ", name=" + name + "]";
	}
	
}
