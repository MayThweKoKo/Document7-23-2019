package com.dms.services;

import org.springframework.validation.BindingResult;

import com.dms.dto.FileUpload;
import com.dms.entity.User_info;
public interface File_detailsService {
	public boolean checkError(FileUpload uploadedFile,BindingResult result);
	public  String  upload_File(FileUpload uploadedFile);
}
