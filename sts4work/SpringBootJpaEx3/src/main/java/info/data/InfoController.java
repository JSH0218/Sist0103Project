package info.data;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class InfoController {
	@Autowired
	InfoDao dao;
	
	@GetMapping("/info/list")
	public ModelAndView list() {
		ModelAndView mview=new ModelAndView();
		
		List<InfoDto> list=dao.getAllDatas();
		
		mview.addObject("list",list);
		mview.addObject("totalCount",list.size());
		
		mview.setViewName("info/infolist");
		
		return mview;
	}
	
	@GetMapping("/info/addform")
	public String addform() {
		return "info/addform";
	}
	
	@PostMapping("/info/save")
	public String save(@ModelAttribute InfoDto dto) {
		dao.infoSave(dto);
		
		return "redirect:list";
	}
	
	@GetMapping("/info/updateform")
	public ModelAndView updateform(@RequestParam Integer num) {
		ModelAndView mview=new ModelAndView();
		
		InfoDto dto=dao.getData(num);
		
		mview.addObject("dto",dto);
		
		mview.setViewName("info/updateform");
		
		return mview;
	}
	
	@GetMapping("/info/delete")
	public String delete(@RequestParam Integer num) {
		dao.infoDelete(num);
		
		return "redirect:list";
	}
}
