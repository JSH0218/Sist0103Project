package myshop.data;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MyShopController {
	@Autowired
	MyShopDao dao;
	
	@GetMapping("/")
	public String start() {
		return "redirect:shop/list";
	}
	
	@GetMapping("/shop/list")
	public ModelAndView list() {
		ModelAndView mview=new ModelAndView();
		
		List<MyShopDto> list=dao.getAllSangpums();
		
		mview.addObject("list",list);
		mview.addObject("totalCount",list.size());
		
		mview.setViewName("myshop/shoplist");
		
		return mview;
	}
	
	@GetMapping("/shop/writeform")
	public String writeform() {
		return "myshop/addform";
	}
	
	@PostMapping("/shop/insert")
	public String insert(@ModelAttribute MyShopDto dto) {
		dao.insertShop(dto);
		
		return "redirect:list";
	}
	
	@GetMapping("/shop/updateform")
	public ModelAndView updateform(@RequestParam Long num) {
		ModelAndView mview=new ModelAndView();
		
		MyShopDto dto=dao.getData(num);
		
		mview.addObject("dto",dto);
		
		mview.setViewName("myshop/updateform");
		
		return mview;
	}
	
	@PostMapping("/shop/update")
	public String update(@ModelAttribute MyShopDto dto) {
		dao.updateShop(dto);
		
		return "redirect:list";
	}
	
	@GetMapping("/shop/delete")
	public String delete(@RequestParam Long num) {
		dao.deleteShop(num);
		
		return "redirect:list";
	}
}
