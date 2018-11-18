package net.wn.vo;

import java.util.List;

import net.wn.entity.Employee;
import net.wn.entity.Empname;

public class PositionVo {
	private int id;
	private String name;
	private List<Empname> empname;
	public PositionVo(int id, String name, List<Empname> empname) {
		super();
		this.id = id;
		this.name = name;
		this.empname = empname;
	}
	public PositionVo() {
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
	public List<Empname> getEmpname() {
		return empname;
	}
	public void setEmpname(List<Empname> empname) {
		this.empname = empname;
	}
	@Override
	public String toString() {
		return "PositionVo [id=" + id + ", name=" + name + ", empname=" + empname + "]";
	}
	
	
	
}
