package niit.com.Proj2.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import niit.com.Proj2.Model.User;

@RestController
public class FileUploadController {
	
	@Autowired
	private 
	
@RequestMapping( value="/doUpload", method=RequestMethod.POST)
public String handleFileUpload(HttpServletRequest request,HttpSession session,
		@RequestParam CommonsMultipartFile[] fileUpload) throws Exception{
		
		User user=(User) session.getAttribute("user");
				if(user==null)
					throw new RuntimeException("Not logged In");
				System.out.println("USER is"+user.getUsername());
		
			return null;
	
}
	
	
	
	
	
}
