package com.dms.services;

import com.dms.dto.User_registerDto;
import com.dms.entity.User_info;
import com.dms.entity.User_login;

public interface User_detailsService {
	public void saveUser(User_registerDto user_registerDto);
	public boolean checkPassword( User_login user_login );
	public User_info search_User_info(String email);
}
