package spring.db.member;

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

}
