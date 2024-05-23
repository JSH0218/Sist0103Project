package data.controller;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import data.dto.MarketDto;
import data.mapper.MarketMapperInter;
import jakarta.servlet.http.HttpSession;

@Controller
public class MarketController {
	@Autowired
	MarketMapperInter mapper;
	
	@GetMapping("/")
	public String start() {
		return "redirect:market/list";
	}
	
	@GetMapping("/market/list")
	public ModelAndView list() {
		ModelAndView mview=new ModelAndView();
		
		int totalCount=mapper.getTatalCount();
		List<MarketDto> list=mapper.getAllDatas();
		
		mview.addObject("totalCount",totalCount);
		mview.addObject("list",list);
		
		mview.setViewName("market/marketlist");
		
		return mview;
	}
	
	@GetMapping("/market/addform")
	public String addform() {
		return "market/addform";
	}
	
	@PostMapping("/market/insert")
	public String insert(@ModelAttribute MarketDto dto,
			@RequestParam MultipartFile photo,
			HttpSession session) {
		if(!photo.isEmpty()) {
			SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMddHHmmss");
			
			String realPath=session.getServletContext().getRealPath("/photo");
			
			String fileName=sdf.format(new Date())+photo.getOriginalFilename();
			
			try {
				photo.transferTo(new File(realPath+"/"+fileName));
			} catch (IllegalStateException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			dto.setPhotoname(fileName);
		} else {
			dto.setPhotoname("no");
		}
		
		mapper.insertMarket(dto);
		
		return "redirect:list";
	}
	
	@GetMapping("/market/updateform")
	public String updateform(@RequestParam String num, Model model) {
		MarketDto dto=mapper.getData(num);
		
		model.addAttribute("dto",dto);
		
		return "market/updateform";
	}
	
	@PostMapping("/market/update")
	public String update(@ModelAttribute MarketDto dto,
			@RequestParam MultipartFile photo,
			HttpSession session) {
		String oldFileName=mapper.getData(dto.getNum()).getPhotoname();
		
		if(oldFileName.equals("no")) {
			if(!photo.isEmpty()) {
				SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMddHHmmss");
				
				String realPath=session.getServletContext().getRealPath("/photo");
				
				String fileName=sdf.format(new Date())+photo.getOriginalFilename();
				
				try {
					photo.transferTo(new File(realPath+"/"+fileName));
				} catch (IllegalStateException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				dto.setPhotoname(fileName);
			} else {
				dto.setPhotoname("no");
			}
		} else {
			if(!photo.isEmpty()) {
				SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMddHHmmss");
				
				String realPath=session.getServletContext().getRealPath("/photo");
				
				String fileName=sdf.format(new Date())+photo.getOriginalFilename();
				
				File oldFile=new File(realPath+"/"+oldFileName);
				
				oldFile.delete();
				
				try {
					photo.transferTo(new File(realPath+"/"+fileName));
				} catch (IllegalStateException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				dto.setPhotoname(fileName);
			} else {
				dto.setPhotoname(oldFileName);
			}
		}
		
		mapper.updateMarket(dto);
		
		return "redirect:list";
	}
	
	@GetMapping("/market/delete")
	public String delete(@RequestParam String num, HttpSession session) {
		String realPath=session.getServletContext().getRealPath("/photo");
		
		String oldFileName=mapper.getData(num).getPhotoname();
		
		File oldFile=new File(realPath+"/"+oldFileName);
		
		oldFile.delete();
		
		mapper.deleteMarket(num);
		
		return "redirect:list";
	}
}
