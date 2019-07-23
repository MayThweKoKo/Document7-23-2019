package com.dms.services;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.BindingResult;
import org.springframework.web.multipart.MultipartFile;

import com.dms.dao.File_locationDao;
import com.dms.dao.User_infoDao;
import com.dms.dao.User_loginDao;
import com.dms.dto.FileUpload;
import com.dms.entity.User_info;
import com.dms.validator.FileUploadValidator;


@Service
@Transactional
public class File_detailsServiceImp implements File_detailsService{
	@Autowired 
	private FileUploadValidator fileValidator;
	@Autowired
	private File_locationDao file_locationDao;
	@Autowired
	private User_loginDao user_loginDao;
	@Autowired
	private User_infoDao user_infoDao;
	public boolean checkError(FileUpload uploadedFile, BindingResult result) {
		// TODO Auto-generated method stub
		fileValidator.validate(uploadedFile, result);
		if (result.hasErrors()) {
			return false;
		}
		return true;
	}

	public String upload_File(FileUpload uploadedFile) {
		// TODO Auto-generated method stub
		InputStream inputStream = null;
		OutputStream outputStream = null;
		MultipartFile file = uploadedFile.getFile();
		String fileName = file.getOriginalFilename();
		String fileType=FilenameUtils.getExtension(fileName).toLowerCase();
		String path=file_locationDao.searchFile_location(fileType);
		System.out.println(fileName+fileType+path);
		try {
			inputStream = file.getInputStream();

			File newFile = new File(path+"\\"+ fileName);
			System.out.println(newFile);
			if (!newFile.exists()) {
				newFile.createNewFile();
			}
			outputStream = new FileOutputStream(newFile);
			int read = 0;
			byte[] bytes = new byte[1024];

			while ((read = inputStream.read(bytes)) != -1) {
				outputStream.write(bytes, 0, read);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return fileName;
	}

}
