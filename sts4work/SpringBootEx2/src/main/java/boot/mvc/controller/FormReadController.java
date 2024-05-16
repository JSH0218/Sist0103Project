package boot.mvc.controller;

import java.util.HashMap;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import boot.data.InfoDto;

@Controller
public class FormReadController {
	@PostMapping("/sist/read1")
	public ModelAndView read1(@RequestParam String name,
			@RequestParam String java,
			@RequestParam String spring) {
		ModelAndView mview=new ModelAndView();
		
		mview.addObject("name",name);
		mview.addObject("java",java);
		mview.addObject("spring",spring);
		
		mview.setViewName("result/result1");
		
		return mview;
	}
	
	@PostMapping("/sist/show2")
	public String show2(@ModelAttribute InfoDto dto, Model model) {
		model.addAttribute("dto", dto);
		
		return "result/result2";
	}
	
	@PostMapping("/sist/write3")
	public String write3(@RequestParam String name,
			@RequestParam String blood,
			@RequestParam String buseo,
			Model model){
		HashMap<String, String> map=new HashMap<>();
		
		map.put("name", name);
		map.put("blood", blood);
		map.put("buseo", buseo);
		
		model.addAttribute("map",map);
		
		return "result/result3";
	}
}
