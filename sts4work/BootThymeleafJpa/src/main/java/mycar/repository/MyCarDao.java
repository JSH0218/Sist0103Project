package mycar.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import lombok.AllArgsConstructor;
import mycar.data.MyCarDto;

@Repository
@AllArgsConstructor
public class MyCarDao {
	MyCarDaoInter daoInter;
	
	//db저장
	public void saveMyCar(MyCarDto dto) {
		daoInter.save(dto);
	}
	
	//전체출력
	public List<MyCarDto> getAllCars(){
		return daoInter.findAll();
	}
	
	//특정데이터 출력
	public MyCarDto getData(Long num) {
		return daoInter.getReferenceById(num);
	}
	
	//데이터삭제
	public void deleteMyCar(Long num) {
		daoInter.deleteById(num);
	}
}
