package myshop.data;

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
}
