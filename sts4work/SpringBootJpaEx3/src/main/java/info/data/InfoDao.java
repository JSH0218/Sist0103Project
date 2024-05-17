package info.data;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class InfoDao {
	@Autowired
	InfoDaoInter daoInter;
	
	//save
	public void infoSave(InfoDto dto) {
		daoInter.save(dto);
	}
	
	//select
	public List<InfoDto> getAllDatas(){
		return daoInter.findAll();
	}
	
	//one select
	public InfoDto getData(Integer num) {
		return daoInter.getReferenceById(num);
	}
	
	//delete
	public void infoDelete(Integer num) {
		daoInter.deleteById(num);
	}

}
