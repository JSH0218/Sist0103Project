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
		int perPage=5; //���������� ������ ���� ����
		int perBlock=5; //�Ѻ��� ������ ������ ����
		int startNum; //db���� ������ ���� ���۹�ȣ(mysql�� ù����0��,����Ŭ�� 1��);
		int startPage; //������ ������ ����������
		int endPage; //������ ������ ��������
		int totalPage; //����������
		int no; //���������� ����� ���۹�ȣ

		//���������� ���Ѵ�
		//�ѱ۰���/���������纸���������� ����(7/5=1)
		//�������� 1�̶� ������ ������ 1������ �߰�(1+1=2�������� �ʿ�)
		totalPage=totalCount/perPage+(totalCount%perPage==0?0:1);

		//������ ������ ����������
		//perBlock=5�ϰ�� ������������ 1~5�ϰ�� ������������1,���������� 5
		//���簡 13�ϰ�� ����:11 ��:15
		startPage=(currentPage-1)/perBlock*perBlock+1;
		endPage=startPage+perBlock-1;

		//���������� 23�ϰ�� ���������� ���������� 25�� �ƴ϶� 23
		if(endPage>totalPage)
			endPage=totalPage;

		//������������ ������ ���۹�ȣ
		//1������:0, 2������:5 3������: 10.....
		startNum=(currentPage-1)*perPage;

		//���������� ����� ���۹�ȣ ���ϱ�
		//�ѱ۰����� 23  , 1������:23 2������:18  3������:13
		no=totalCount-(currentPage-1)*perPage;

		//���������� ����� ���۹�ȣ ���ϱ�
		//�ѱ۰����� 23  , 1������:23 2������:18  3������:13
		no=totalCount-(currentPage-1)*perPage;

		//���������� ������ �۸� ��������
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
