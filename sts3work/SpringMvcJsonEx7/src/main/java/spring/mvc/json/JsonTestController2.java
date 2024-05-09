package spring.mvc.json;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import spring.data.PhotoDto;

@RestController
public class JsonTestController2 {

	@GetMapping("/list3")
	public Map<String, Object> list3(@RequestParam String foodName){
		
		List<PhotoDto> list=new ArrayList<PhotoDto>();
		
		list.add(new PhotoDto("������ġ", "1.jpg"));
		list.add(new PhotoDto("��ġ����", "2.jpg"));
		list.add(new PhotoDto("�������", "11.jpg"));
		list.add(new PhotoDto("�������丮����", "5.jpg"));
		list.add(new PhotoDto("�丶�佺Ʃ", "7.jpg"));
		
		Map<String, Object> map=new HashMap<String, Object>();
		
		map.put("foodName", "���¸޴�");
		map.put("photo", "6.jpg");
		
		for(PhotoDto dto:list) {
			
			if(foodName.equals(dto.getFoodName())) {
				
				map.put("foodName", dto.getFoodName());
				map.put("photo", dto.getPhoto());
			}
		}
		
		return map;
	}
}
