package spring.mvc.quiz;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class QuizController {
	//3���� �����ּҸ� �������� �ּҷ� ����ǰ� ����� ������� �ش� ������� jsp���Ͽ��� ��Ÿ���� �մϴ�.
	
	@GetMapping("/happy")
	public String happy() {
		return "nice";
	}
	
	@GetMapping("/hello")
	public String hello(Model model) {
		
		model.addAttribute("msg", "�ߵǳ�?");
		
		return "hello";
	}
	
	@GetMapping("/nice/like")
	public String nice(Model model) {
		
		model.addAttribute("name", "��ö��");
		model.addAttribute("hp", "010-1234-5678");
		model.addAttribute("addr", "����� ������ ���ﵿ");
		
		return "happy";
	}
}
