package spring.mvc.quiz;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class QuizUploadController {
	
	@GetMapping("quiz/myshop")
	public String form() {
		return "quiz/quizUploadForm";
	}
	
	@PostMapping("quiz/shopwrite")
	public ModelAndView write(
			@RequestParam String sang,
			@RequestParam ArrayList<MultipartFile> photo,
			@RequestParam String price,
			@RequestParam String ipgo,
			HttpServletRequest request) {
		ModelAndView model=new ModelAndView();
		
		//업로드할 실제경로 구하기
		String path=request.getSession().getServletContext().getRealPath("/WEB-INF/image");
		
		//현재날짜와 시간을 이용해 파일명 저장
		SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMddHHmmss");
		
		ArrayList<String> files=new ArrayList<String>();
		
		//파일명 담기
		for(MultipartFile f:photo) {
			String fileName=sdf.format(new Date())+"_"+f.getOriginalFilename();
			files.add(fileName);
			
			//실제업로드
			try {
				f.transferTo(new File(path+"\\"+fileName));
			} catch (IllegalStateException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		model.addObject("sang", sang);
		model.addObject("files", files);
		model.addObject("price", price);
		model.addObject("ipgo", ipgo);
		
		model.setViewName("quiz/quizUploadWrite");
		
		return model;
	}
}
