package myshop.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import myshop.dto.ShopDto;

public interface MyShopMapper {
	public int getTotalCount();
	
	public void insertShop(ShopDto dto);
	
	@Select("select * from myshop order by num asc")
	public List<ShopDto> getAllSangpums();
	
	public ShopDto getData(int num);
	
	public void deleteShop(int num);
}
