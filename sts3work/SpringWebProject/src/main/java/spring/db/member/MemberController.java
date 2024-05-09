package spring.db.member;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/member")
public class MemberController {
	
	@Autowired
	MemberDaoInter memInter;

	@GetMapping("/list")
	public String list(Model model) {
		
		List<MemberDto> list=memInter.selectMember();
		int count=memInter.countMember();
		
		model.addAttribute("list", list);
		model.addAttribute("count", count);
		
		return "member/memberlist";
	}
	
	@GetMapping("/addform")
	public String addform() {
		
		return "member/addform";
	}
	
	@GetMapping("/idcheck")
	@ResponseBody
	public Map<String, Integer> idcheck(@RequestParam String id){
		
		Map<String, Integer> map=new HashMap<String, Integer>();
		
		int count=memInter.getIdCheck(id);
		
		map.put("count", count);
		
		return map;
	}
	
	@PostMapping("/insert")
	public String insert(@ModelAttribute("dto") MemberDto dto) {
		
		memInter.insertMember(dto);
		
		return "redirect:list";
	}
}
