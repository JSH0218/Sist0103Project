package spring.mvc.may;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class BoardController {
	
	@GetMapping("/board/form")
	public String form1() {
		return "board/writeform";
	}
	
	@PostMapping("/board/process")
	public ModelAndView process(@RequestParam String name,
			@RequestParam String date,
			@RequestParam String gender,
			@RequestParam(required = false) String msg,
			@RequestParam(name="pageNum",defaultValue = "1")int currentPage) {
		ModelAndView model=new ModelAndView();
		
		model.addObject("name", name);
		model.addObject("date", date);
		model.addObject("gender", gender);
		model.addObject("msg",msg);
		model.addObject("currentPage",currentPage);
		
		model.setViewName("board/result");
		
		return model;
	}
	
	@GetMapping("/board/result2")
	public String result2(Model model) {
		model.addAttribute("myimg1", "../image/a01.png");
		model.addAttribute("title", "내가 만든 고양이 캐릭터");
		
		return "board/result2";
	}
	
	@GetMapping("/board/list")
	public String list() {
		
		
		return "board/list";
	}
}
