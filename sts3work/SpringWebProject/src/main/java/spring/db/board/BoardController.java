package spring.db.board;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/board")
public class BoardController {
	
	@Autowired
	BoardDaoInter dao;
	
	@GetMapping("/list")
	public ModelAndView list(@RequestParam(value="currentPage", defaultValue="1")int currentPage) {
		
		ModelAndView model=new ModelAndView();
		
		int totalCount=dao.getTotalCount();
		int perPage=5; //한페이지당 보여질 글의 갯수
		int perBlock=5; //한블럭당 보여질 페이지 갯수
		int startNum; //db에서 가져올 글의 시작번호(mysql은 첫글이0번,오라클은 1번);
		int startPage; //각블럭당 보여질 시작페이지
		int endPage; //각블럭당 보여질 끝페이지
		int totalPage; //총페이지수
		int no; //각페이지당 출력할 시작번호

		//총페이지수 구한다
		//총글갯수/한페이지당보여질갯수로 나눔(7/5=1)
		//나머지가 1이라도 있으면 무조건 1페이지 추가(1+1=2페이지가 필요)
		totalPage=totalCount/perPage+(totalCount%perPage==0?0:1);

		//각블럭당 보여질 시작페이지
		//perBlock=5일경우 현재페이지가 1~5일경우 시작페이지가1,끝페이지가 5
		//현재가 13일경우 시작:11 끝:15
		startPage=(currentPage-1)/perBlock*perBlock+1;
		endPage=startPage+perBlock-1;

		//총페이지가 23일경우 마지막블럭은 끝페이지가 25가 아니라 23
		if(endPage>totalPage)
			endPage=totalPage;

		//각페이지에서 보여질 시작번호
		//1페이지:0, 2페이지:5 3페이지: 10.....
		startNum=(currentPage-1)*perPage;

		//각페이지당 출력할 시작번호 구하기
		//총글개수가 23  , 1페이지:23 2페이지:18  3페이지:13
		no=totalCount-(currentPage-1)*perPage;

		//각페이지당 출력할 시작번호 구하기
		//총글개수가 23  , 1페이지:23 2페이지:18  3페이지:13
		no=totalCount-(currentPage-1)*perPage;

		//페이지에서 보여질 글만 가져오기
		List<BoardDto>list=dao.selectPagingBoard(startNum, perPage);
		
		model.addObject("totalCount", totalCount);
		model.addObject("list", list);
		model.addObject("no", no);
		model.addObject("startPage", startPage);
		model.addObject("endPage", endPage);
		model.addObject("currentPage", currentPage);
		model.addObject("totalPage", totalPage);
		
		model.setViewName("board/boardlist");
		
		return model;
	}
	
	@GetMapping("/addform")
	public String addfrom() {
		
		return "board/addform";
	}
	
	@PostMapping("/insert")
	public String insert(@ModelAttribute BoardDto dto,
			@RequestParam ArrayList<MultipartFile> upload,
			@RequestParam String currentPage,
			HttpSession session) {
		
		String path=session.getServletContext().getRealPath("/WEB-INF/photo");
		
		String photo="";
		
		if(upload.get(0).getOriginalFilename().equals("")) {
			
			photo="no";
		} else {
			for(MultipartFile f:upload) {
				
				String fName=f.getOriginalFilename();
				photo+=fName+",";
				
				try {
					f.transferTo(new File(path+"/"+fName));
				} catch (IllegalStateException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			photo=photo.substring(0, photo.length()-1);
		}
		
		dto.setPhoto(photo);
		
		dao.insertBoard(dto);
		
		int num=dao.getMaxNum();
		
		return "redirect:content?num="+num+"&currentPage="+currentPage+1;
	}
	
	@GetMapping("/content")
	public String content(@RequestParam int num,
			@RequestParam String currentPage,
			Model model) {
		
		dao.updateReadCount(num);
		
		BoardDto dto=dao.selectOneBoard(num);
		
		model.addAttribute("currentPage", currentPage);
		model.addAttribute("dto", dto);
		
		return "board/content";
	}

}
