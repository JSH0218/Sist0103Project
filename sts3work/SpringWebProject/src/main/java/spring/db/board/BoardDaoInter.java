package spring.db.board;

import java.util.List;

public interface BoardDaoInter {

	public int getTotalCount();
	
	public int getMaxNum();
	
	public void insertBoard(BoardDto dto);
	
	public List<BoardDto> selectBoard();
	
	public BoardDto selectOneBoard(int num);
	
	public void updateReadCount(int num);
	
	public List<BoardDto> selectPagingBoard(int startNum, int perPage);
}
