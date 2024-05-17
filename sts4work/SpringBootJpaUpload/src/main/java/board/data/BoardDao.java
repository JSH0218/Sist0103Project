package board.data;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;

@Repository
public class BoardDao {
	@Autowired
	BoardDaoInter daoInter;
	
	public void saveBaord(BoardDto dto) {
		daoInter.save(dto);
	}
	
	public List<BoardDto> getAllDatas(){
		return daoInter.findAll(Sort.by(Sort.Direction.DESC,"num"));
	}
	
	public void deleteBoard(Long num) {
		daoInter.deleteById(num);
	}
	
	public BoardDto getData(Long num) {
		return daoInter.getReferenceById(num);
	}
	
}
