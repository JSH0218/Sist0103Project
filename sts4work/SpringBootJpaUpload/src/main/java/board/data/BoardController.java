package board.data;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import jakarta.servlet.http.HttpSession;

@Controller
public class BoardController {
	@Autowired
	BoardDao dao;
	
	@GetMapping("/")
	public String start() {
		return "redirect:board/list";
	}
	
	@GetMapping("/board/list")
	public ModelAndView list() {
		ModelAndView mview=new ModelAndView();
		
		List<BoardDto> list=dao.getAllDatas();
		
		mview.addObject("list",list);
		mview.addObject("totalCount",list.size());
		
		mview.setViewName("board/boardlist");
		
		return mview;
	}
	
	@GetMapping("/board/addform")
	public String form() {
		return "board/writeform";
	}
	
	@PostMapping("/board/save")
	public String save(@ModelAttribute BoardDto dto,
			@RequestParam MultipartFile upload,
			HttpSession session) {
		String realPath=session.getServletContext().getRealPath("/save");
		
		String uploadName=upload.getOriginalFilename();
		
		if(uploadName.isEmpty()) {
			dto.setPhoto("no");
		}else {
			dto.setPhoto(uploadName);
			
			try {
				upload.transferTo(new File(realPath+"/"+uploadName));
			} catch (IllegalStateException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		dao.saveBaord(dto);
		
		return "redirect:list";
	}
	
	@GetMapping("/board/detail")
	public ModelAndView detail(@RequestParam Long num) {
		ModelAndView mview=new ModelAndView();
		
		BoardDto dto=dao.getData(num);
		
		mview.addObject("dto",dto);
		
		mview.setViewName("board/detail");
		
		return mview;
	}
}
