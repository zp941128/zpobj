package net.wn.entity;

public class Empname {
  private  String name;

@Override
public String toString() {
	return "Empname [name=" + name + "]";
}

public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}

public Empname() {
	super();
	// TODO Auto-generated constructor stub
}

public Empname(String name) {
	super();
	this.name = name;
}
}
