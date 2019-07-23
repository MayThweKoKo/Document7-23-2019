/*
 * package com.dms.datachanges;
 * 
 * import java.util.ArrayList; import java.util.List; import
 * org.springframework.stereotype.Repository; import
 * org.springframework.transaction.annotation.Transactional; import
 * com.dms.dto.User_infoDto; import com.dms.dto.User_loginDto; import
 * com.dms.entity.User_info; import com.dms.entity.User_login;
 * 
 * @Repository
 * 
 * @Transactional public class Data_ChangerImp implements Data_Changer{
 * 
 * 
 * public User_info data_User_infoDto(User_infoDto user_infoDto) { // TODO
 * Auto-generated method stub User_info user_info=new User_info();
 * user_info.setId(user_infoDto.getId());
 * user_info.setName(user_infoDto.getName());
 * user_info.setAddress(user_infoDto.getAddress());
 * user_info.setPhno(user_infoDto.getPhno());
 * user_info.setNrc(user_infoDto.getNrc());
 * user_info.setPhoto(user_infoDto.getPhoto());
 * user_info.getDepartment().setId(user_infoDto.getDepartment_id());
 * user_info.getOwn_location().setId(user_infoDto.getOwn_location_id());
 * user_info.getUser_login().setId(user_infoDto.getUser_login_id()); return
 * user_info; }
 * 
 * 
 * public List<User_infoDto> array_User_info(List<User_info> user_info) { //
 * TODO Auto-generated method stub List<User_infoDto> user_infoDto=new
 * ArrayList<User_infoDto>(); for(User_info change:user_info) { User_infoDto
 * a=new User_infoDto(); a.setId(change.getId()); a.setName(change.getName());
 * a.setAddress(change.getAddress()); a.setPhno(change.getPhno());
 * a.setNrc(change.getNrc()); a.setPhoto(change.getPhoto());
 * a.setDepartment_id(change.getDepartment().getId());
 * a.setOwn_location_id(change.getOwn_location().getId());
 * a.setUser_login_id(change.getUser_login().getId()); user_infoDto.add(a); }
 * return user_infoDto;
 * 
 * }
 * 
 * 
 * public User_login data_User_loginDto(User_loginDto user_loginDto) { // TODO
 * Auto-generated method stub User_login user_login=new User_login();
 * user_login.setId(user_loginDto.getId());
 * user_login.setEmail(user_loginDto.getEmail());
 * user_login.setPassword(user_loginDto.getPassword());
 * user_login.getRole().setId(user_loginDto.getRole_id()); return user_login; }
 * 
 * 
 * public List<User_loginDto> array_User_login(List<User_login> user_login) { //
 * TODO Auto-generated method stub List<User_loginDto> user_loginDto=new
 * ArrayList<User_loginDto>(); for(User_login change:user_login) { User_loginDto
 * a=new User_loginDto(); a.setId(change.getId());
 * a.setEmail(change.getEmail()); a.setPassword(change.getPassword());
 * a.setRole_id(change.getRole().getId()); user_loginDto.add(a); } return
 * user_loginDto; } }
 */