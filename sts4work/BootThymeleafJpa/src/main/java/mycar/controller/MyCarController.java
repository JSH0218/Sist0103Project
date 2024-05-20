package mycar.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import mycar.data.MyCarDto;
import mycar.repository.MyCarDao;

@Controller
@RequiredArgsConstructor
public class MyCarController {
	private final MyCarDao dao;
	
	@GetMapping("/")
	public String list(Model model) {
		List<MyCarDto> list=dao.getAllCars();
		
		model.addAttribute("list",list);
		model.addAttribute("totalCount",list.size());
		
		return "mycar/mycarlist";
	}
	
	@GetMapping("/writeform")
	public String form() {
		return "mycar/mycarform";
	}
	
	@PostMapping("/save")
	public String save(@ModelAttribute MyCarDto dto,
			@RequestParam MultipartFile carupload,
			HttpSession session) {
		String realPath=session.getServletContext().getRealPath("/save");
		
		String uploadName=carupload.getOriginalFilename();
		
		if(dto.getNum()!=null) {
			File oldFile= new File(realPath+"/"+dao.getData(dto.getNum()).getCarphoto());
			try {
                oldFile.delete();
            } catch (Exception e) {
                e.printStackTrace();
            }
		}
		
		dto.setCarphoto(uploadName);
		
		try {
			carupload.transferTo(new File(realPath+"/"+uploadName));
		} catch (IllegalStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		dao.saveMyCar(dto);
		
		return "redirect:/";
	}
	
	@GetMapping("/detail")
	public String detail(@RequestParam Long num, Model model) {
		MyCarDto dto=dao.getData(num);
		
		model.addAttribute("dto",dto);
		
		return "mycar/mycardetail";
	}
	
	@GetMapping("/updateform")
	public String uform(@RequestParam Long num, Model model) {
		MyCarDto dto=dao.getData(num);
		
		model.addAttribute("dto",dto);
		
		return "mycar/updateform";
	}
	
	@GetMapping("/delete")
	public String delete(@RequestParam Long num, HttpSession session) {
		String realPath=session.getServletContext().getRealPath("/save");
		
		File oldFile=new File(realPath+"/"+dao.getData(num).getCarphoto());
		
		try {
			oldFile.delete();
		} catch (Exception e) {
            e.printStackTrace();
        }
		
		dao.deleteMyCar(num);
		
		return "redirect:/";
	}
}
