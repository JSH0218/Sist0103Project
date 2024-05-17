package myshop.data;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class MyShopDao {
	@Autowired
	MyShopDaoInter daoInter;
	
	//insert
	public void insertShop(MyShopDto dto) {
		daoInter.save(dto); //id타입 유무에 따라 insert 혹은 update
	}
	
	//select
	public List<MyShopDto> getAllSangpums(){
		return daoInter.findAll();
	}
	
	//num에 대한 dto반환
	public MyShopDto getData(Long num) {
		return daoInter.getReferenceById(num);
	}
	
	//update
	public void updateShop(MyShopDto dto) {
		daoInter.save(dto);
	}
	
	//delte
	public void deleteShop(Long num) {
		daoInter.deleteById(num);
	}
}
