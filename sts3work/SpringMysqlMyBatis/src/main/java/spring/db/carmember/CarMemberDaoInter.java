package spring.db.carmember;

import java.util.List;

public interface CarMemberDaoInter {

	public int getTotalCount();
	
	public List<CarMemberDto> getAllMemberDatas();
	
	public void insertMember(CarMemberDto dto);
	
	public CarMemberDto getData(String num);
	
	public void updateMember(CarMemberDto dto);
	
	public void deleteMember(String num);
}
