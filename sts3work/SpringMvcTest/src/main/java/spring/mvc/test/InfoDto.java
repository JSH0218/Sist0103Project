package spring.mvc.test;

import java.util.ArrayList;

public class InfoDto {
	private String name;
	private String color;
	private ArrayList<String> hobby=new ArrayList<String>();
	private String lan;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public ArrayList<String> getHobby() {
		return hobby;
	}
	public void setHobby(ArrayList<String> hobby) {
		this.hobby = hobby;
	}
	public String getLan() {
		return lan;
	}
	public void setLan(String lan) {
		this.lan = lan;
	}
}
