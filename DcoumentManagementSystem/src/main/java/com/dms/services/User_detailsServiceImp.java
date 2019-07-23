package com.dms.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.dms.dao.User_infoDao;
import com.dms.dao.User_loginDao;
import com.dms.dto.FileUpload;
import com.dms.dto.User_registerDto;
import com.dms.entity.User_info;
import com.dms.entity.User_login;
@Service
@Transactional
public class User_detailsServiceImp implements User_detailsService{
	@Autowired 
	User_loginDao user_loginDao;
	@Autowired 
	User_infoDao user_infoDao;
	@Autowired 
	File_detailsService file_detailsDao;
	@Autowired 
	BCryptPasswordEncoder bcryptEncoder;
	
	
	public void saveUser(User_registerDto user_registerDto) {
		// TODO Auto-generated method stub
		User_login user_login = new User_login();
		String password=user_registerDto.getPassword();
		user_login.setEmail(user_registerDto.getEmail());
		user_login.setPassword(bcryptEncoder.encode(password));
		user_login.getRole().setId(user_registerDto.getRole_id());
		
		User_info user_info = new User_info();

		user_info.setId(user_registerDto.getId());
		user_info.setName(user_registerDto.getName());
		user_info.setAddress(user_registerDto.getAddress());
		user_info.setPhno(user_registerDto.getPhno());
		user_info.setNrc(user_registerDto.getNrc());
		FileUpload uploaded_file=new FileUpload();
		uploaded_file.setFile(user_registerDto.getPhoto());
		user_info.setPhoto(file_detailsDao.upload_File(uploaded_file));
		user_info.getDepartment().setId(user_registerDto.getDepartment_id());
		
		user_loginDao.saveOrUpdateUser_login(user_login);
		long login_id=user_loginDao.findUserByEmail(user_login.getEmail()).getId();
		user_info.getUser_login().setId(login_id);
		user_infoDao.saveOrUpdateUser_info(user_info);
		
	}
	
	public boolean checkPassword(User_login user_login) {
		// TODO Auto-generated method stub
		User_login search_user=user_loginDao.searchUser_login(user_login);
		if(search_user==null) {
			return false;
		}
		else {
			return true;
		}
	}
	public User_info search_User_info(String email) {
		// TODO Auto-generated method stub
				System.out.println(user_loginDao.searchId(email));
				return user_infoDao.search_User(user_loginDao.findUserByEmail(email).getId());
	}

}
