package boot.guest.controller;

import java.io.File;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import boot.guest.dto.GuestDto;
import boot.guest.service.GuestService;
import jakarta.servlet.http.HttpServletRequest;

@Controller
public class GuestDeleteController {
	@Autowired
	private GuestService gService;
	
	@GetMapping("/guest/delete")
	@ResponseBody
	public HashMap<String, String> delete(@RequestParam int num, @RequestParam String pass, HttpServletRequest request)
	{
		HashMap<String, String> map=new HashMap<>();
		HashMap<String, String> msgMap=new HashMap<>();
		
		map.put("num", Integer.toString(num));
		map.put("pass", pass);
		
		int passCheck=gService.passCheck(map);
		
		if(passCheck==0)
		{
			msgMap.put("msg", "비밀번호가 틀렸습니다");
		}
		else
		{
			
			GuestDto dto=gService.getData(num);
			
			String photos=dto.getPhoto();
			
			if(photos!=null)
			{
				String[] photoArray=photos.split(",");
				String path=request.getServletContext().getRealPath("/guestphoto");
				
				for(String photo:photoArray)
				{
					File originalFile=new File(path+"/"+photo);
					
					originalFile.delete();
				}
			}
			
			gService.deleteGuest(num);
			
			msgMap.put("msg", "삭제되었습니다");
		}
		
		return msgMap;
	}
}
