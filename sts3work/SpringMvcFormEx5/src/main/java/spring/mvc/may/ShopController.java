package spring.mvc.may;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ShopController {
	
	@GetMapping("/shop/dtoform")
	public String formdto() {
		return "shop/formdto";
	}
	
	@GetMapping("/shop/mapform")
	public String formmap() {
		return "shop/formmap";
	}
	
	@PostMapping("/shop/process1")
	public ModelAndView process1(@ModelAttribute ShopDto dto) {
		ModelAndView model=new ModelAndView();
		
		model.addObject("dto", dto);
		
		model.setViewName("shop/dtoresult");
		
		return model;
	}
	
	@PostMapping("shop/process2")
	public ModelAndView process2(@RequestParam Map<String, String> map) {
		ModelAndView model=new ModelAndView();
		
		model.addObject("name", map.get("name"));
		model.addObject("count", map.get("count"));
		model.addObject("price", map.get("price"));
		model.addObject("color", map.get("color"));
		
		model.setViewName("shop/mapresult");
		
		return model;
	}
}
