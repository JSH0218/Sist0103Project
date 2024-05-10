package spring.db.member;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class MemberDao implements MemberDaoInter {
	
	@Autowired
	private SqlSession session;
	
	@Override
	public int getIdCheck(String id) {
		// TODO Auto-generated method stub
		return session.selectOne("idCheckOfMember", id);
	}

	@Override
	public void insertMember(MemberDto dto) {
		// TODO Auto-generated method stub
		session.insert("insertOfMember", dto);
	}

	@Override
	public List<MemberDto> selectMember() {
		// TODO Auto-generated method stub
		return session.selectList("selectOfMember");
	}

	@Override
	public int countMember() {
		// TODO Auto-generated method stub
		return session.selectOne("countOfMember");
	}

	@Override
	public MemberDto selectOneMember(String num) {
		// TODO Auto-generated method stub
		return session.selectOne("selectOneOfMember", num);
	}

	@Override
	public int getPassCheck(String num, String pass) {
		// TODO Auto-generated method stub
		HashMap<String, String> map=new HashMap<String, String>();
		
		map.put("num", num);
		map.put("pass", pass);
		
		return session.selectOne("passCheckOfMember", map);
	}

	@Override
	public void updateMember(MemberDto dto) {
		// TODO Auto-generated method stub
		session.update("updateOfMember", dto);
		
	}

	@Override
	public void deleteMember(String num) {
		// TODO Auto-generated method stub
		session.delete("deleteOfMember", num);
	}

}
