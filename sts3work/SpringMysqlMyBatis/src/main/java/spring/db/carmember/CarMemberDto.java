package spring.db.carmember;

import java.sql.Timestamp;

public class CarMemberDto {
	private String num;
	private String name;
	private String hp;
	private String addr;
	private Timestamp guipday;
	
	public String getNum() {
		return num;
	}
	public void setNum(String num) {
		this.num = num;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getHp() {
		return hp;
	}
	public void setHp(String hp) {
		this.hp = hp;
	}
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	public Timestamp getGuipday() {
		return guipday;
	}
	public void setGuipday(Timestamp guipday) {
		this.guipday = guipday;
	}
}
