package spring.mvc.today;

import java.util.Date;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {
	
	@GetMapping(value = "/")
	public String home(Model model) {
		//request에 저장
		model.addAttribute("msg", "HomeController로부터 포워드됨");
		model.addAttribute("today", new Date());
		
		return "home";
	}
	
	@GetMapping("/apple/list")
	public String applelist(Model model) {
		model.addAttribute("stuName","이진우");
		model.addAttribute("stuLoc","4강의장");
		
		return "stuResult1";
	}
	
	@GetMapping("/banana/insert")
	public ModelAndView banana() {
		//ModelAndView는 request에 저장하기 위해 model과 포워드를 위한 View를 합쳐놓은 클래스
		ModelAndView mview=new ModelAndView();
		
		//request에 저장
		mview.addObject("java", 88);
		mview.addObject("mysql", 77);
		
		//포워드할 jsp를 지정
		mview.setViewName("scoreResult");
		
		return mview;
	}
	
	@GetMapping("/orange/select")
	public String orange(Model model, HttpSession session) {
		//request에 저장
		model.addAttribute("s_msg", "스프링 매핑 연습중!!");
		
		//sessio에 저장
		session.setAttribute("myid", "admin");
		
		return "orangeResult";
	}
	
	@GetMapping("/shop/detail")
	public String resShop() {
		
		
		return "resResult";
	}
}
