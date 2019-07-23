package com.dms.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dms.dao.DepartmentDao;
import com.dms.dao.RoleDao;
import com.dms.dao.User_loginDao;
import com.dms.dto.FileUpload;
import com.dms.dto.User_registerDto;
import com.dms.entity.User_info;
import com.dms.services.File_detailsService;
import com.dms.services.User_detailsService;
import com.dms.validator.FileUploadValidator;

@Controller
public class HomeController {
	
	@Autowired 
	private RoleDao roleDao;
	@Autowired 
	private DepartmentDao departmentDao;
	@Autowired 
	private User_detailsService user_detailsDao;
	@Autowired 
	private File_detailsService file_detailsServices;
	@Autowired 
	private FileUploadValidator fileValidator;
	@Autowired
	private User_loginDao user_loginDao;
	
	@RequestMapping(value="/user_register.htm")
	public String home(Model model) {
		model.addAttribute("user_registerDTO",new User_registerDto());
		model.addAttribute("role_list",roleDao.viewAllRole());
		model.addAttribute("department_list",departmentDao.viewAllDepartment());
		return "user_register";
	}
	@RequestMapping(value="/login.htm")
	public String welcome(){
		return "login";
		
	}
	@RequestMapping(value="/logout.htm", method=RequestMethod.GET)  
    public String logoutPage(HttpServletRequest request, HttpServletResponse response) {  
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();  
        if (auth != null){      
           new SecurityContextLogoutHandler().logout(request, response, auth);  
        }  
         return "redirect:/login.htm";  
     } 
	@RequestMapping(value="/index.htm")
	public String LoginSuccess(Model model){
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String username = ((UserDetails)principal).getUsername();
		User_info user=user_detailsDao.search_User_info(username);
		model.addAttribute("user",user);
		return "welcome";
		
	}
	@RequestMapping(value="/file_upload.htm")
	public String file_upload(Model model){
		model.addAttribute("uploaded_file",new FileUpload());
		return "fileuploadform";
		
	}
	@RequestMapping(value="/success.htm")
	public String success(Model model,@ModelAttribute("uploaded_file")FileUpload uploaded_file,BindingResult result){
		fileValidator.validate(uploaded_file, result);
		if (result.hasErrors()) {
			return "fileuploadform";
		}else {
			String fileName=file_detailsServices.upload_File(uploaded_file);
			
			model.addAttribute("fileName",fileName);
			return "fileuploadsuccess";

		}
	}
		@RequestMapping(value="/user_register.htm",method=RequestMethod.POST)
		public String successRgister(Model model,@Validated @ModelAttribute("user_registerDTO")User_registerDto user_registerDTO,BindingResult result){
			boolean error=user_loginDao.checkEmail(user_registerDTO.getEmail());
			System.out.println(error+"error");
			if(!result.hasErrors()&&error==true) {
			user_detailsDao.saveUser(user_registerDTO);
			}
			else {
				model.addAttribute("user_registerDTO",new User_registerDto());
				model.addAttribute("role_list",roleDao.viewAllRole());
				model.addAttribute("department_list",departmentDao.viewAllDepartment());
	 			return "user_register";
			}
			return "welcome";
		
	}
	
		@RequestMapping(value="/my_file.htm")
		public String My_File(Model model){
			return "share_file";
		
	}
		@RequestMapping(value="/getDepartmentList",produces = MediaType.APPLICATION_JSON_VALUE)
		public @ResponseBody String getUserRole(@RequestParam(value="user")String user,@RequestParam(value="inputUser")String inputUser){
			System.out.println(user+"from "+inputUser);
			return user+inputUser ;
		}
		@RequestMapping(value="/share_file.htm")
		public String share_File(Model model){
			return "share_file";
		}
}
