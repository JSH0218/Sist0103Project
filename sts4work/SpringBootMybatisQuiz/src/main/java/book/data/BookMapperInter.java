package book.data;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface BookMapperInter {
	public int getTotalCount();
	
	public List<BookDto> getAllDatas();
	
	public void insertBook(BookDto dto);
}
