package spring.db.carmember;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CarMemberController {

	@Autowired
	CarMemberDaoInter memInter;
	
	@GetMapping("/carmember/list")
	public String list(Model model) {
		int totalCount=memInter.getTotalCount();
		
		List<CarMemberDto> list=memInter.getAllMemberDatas();
		
		model.addAttribute("totalCount", totalCount);
		model.addAttribute("list", list);
		
		return "carmember/memberlist";
	}
	
	@GetMapping("/carmember/writeform")
	public String memform() {
		return "carmember/memberform";
	}
	
	@PostMapping("/carmember/write")
	public String insert(@ModelAttribute("dto") CarMemberDto dto) {
		memInter.insertMember(dto);
		
		return "redirect:list";
	}
	
	@GetMapping("/carmember/updateform")
	public String uform(@RequestParam String num, Model model) {
		CarMemberDto dto=memInter.getData(num);
		
		model.addAttribute("dto", dto);
		
		return "carmember/memberuform";
	}
	
	@PostMapping("/carmember/update")
	public String update(@ModelAttribute("dto") CarMemberDto dto) {
		memInter.updateMember(dto);
		
		return "redirect:list";
	}
	
	@GetMapping("/carmember/delete")
	public String delete(@RequestParam String num) {
		memInter.deleteMember(num);
		
		return "redirect:list";
	}
}
