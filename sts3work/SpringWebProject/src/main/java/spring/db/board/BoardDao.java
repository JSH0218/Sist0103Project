package spring.db.board;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class BoardDao implements BoardDaoInter {
	
	@Autowired
	private SqlSession session;

	@Override
	public int getTotalCount() {
		// TODO Auto-generated method stub
		return session.selectOne("totalCountOfBoard", session);
	}

	@Override
	public int getMaxNum() {
		// TODO Auto-generated method stub
		return session.selectOne("maxNumOfBoard", session);
	}

	@Override
	public void insertBoard(BoardDto dto) {
		// TODO Auto-generated method stub
		session.insert("insertOfBoard", dto);
	}

	@Override
	public List<BoardDto> selectBoard() {
		// TODO Auto-generated method stub
		return session.selectList("selectOfBoard", session);
	}

	@Override
	public BoardDto selectOneBoard(int num) {
		// TODO Auto-generated method stub
		return session.selectOne("selectOneOfBoard", num);
	}

	@Override
	public void updateReadCount(int num) {
		// TODO Auto-generated method stub
		session.update("updateReadCountOfBoard", num);
	}

	@Override
	public List<BoardDto> selectPagingBoard(int startNum, int perPage) {
		// TODO Auto-generated method stub
		HashMap<String, Integer> map=new HashMap<String, Integer>();
		
		map.put("startNum", startNum);
		map.put("perPage", perPage);
		
		return session.selectList("selectPagingListOfMember", map);
	}

}
