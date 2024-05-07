package spring.mvc.test;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class InfoController {
	
	@GetMapping("/info/myform")
	public String myForm() {
		return "infoform";
	}
	
	@PostMapping("/info/result")
	public ModelAndView result(@ModelAttribute InfoDto dto) {
		ModelAndView model=new ModelAndView();
		
		ArrayList<String> hobby=dto.getHobby();
		if(hobby.size()==0) {
			hobby.add("¾øÀ½");
		}
		
		dto.setHobby(hobby);
		
		model.addObject("dto", dto);
		
		model.setViewName("infowrite");
		
		return model;
	}
}
