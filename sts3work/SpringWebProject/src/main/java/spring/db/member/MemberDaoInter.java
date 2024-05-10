package spring.db.member;

import java.util.List;

public interface MemberDaoInter {

	public int getIdCheck(String id);
	
	public void insertMember(MemberDto dto);
	
	public List<MemberDto> selectMember();
	
	public int countMember();
	
	public MemberDto selectOneMember(String num);
	
	public int getPassCheck(String num, String pass);
	
	public void updateMember(MemberDto dto);
	
	public void deleteMember(String num);
}
