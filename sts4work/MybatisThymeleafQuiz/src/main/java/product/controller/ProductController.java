package product.controller;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
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
import product.dto.ProductDto;
import product.service.ProductService;

@Controller
@RequiredArgsConstructor
public class ProductController {
	private final ProductService productService;
	
	@GetMapping("/")
	public String start() {
		return "redirect:list";
	}
	
	@GetMapping("/list")
	public String list(Model model) {
		List<ProductDto> list=productService.selectProduct();
		
		model.addAttribute("list",list);
		model.addAttribute("totalCount",list.size());
		
		return "product/productlist";
	}
	
	@GetMapping("/addform")
	public String addform() {
		return "product/addform";
	}
	
	@PostMapping("insert")
	public String insert(@ModelAttribute ProductDto dto,
			@RequestParam MultipartFile upload,
			HttpSession session) {
		if(upload.isEmpty()) {
			dto.setPro_image(null);
		} else {
			SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMddHHmmss");
			
			String realPath=session.getServletContext().getRealPath("/productimage");
			String fileName=sdf.format(new Date())+upload.getOriginalFilename();
			
			File file=new File(realPath+"/"+fileName);
			
			try {
				upload.transferTo(file);
			} catch (IllegalStateException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			dto.setPro_image(fileName);
		}
		
		productService.insertProduct(dto);
		
		return "redirect:list";
	}
	
	@GetMapping("/detail")
	public String detail(@RequestParam int pro_num, Model model) {
		ProductDto dto=productService.selectOneProduct(pro_num);
		
		model.addAttribute("dto",dto);
		
		return "product/productdetail";
	}
}
