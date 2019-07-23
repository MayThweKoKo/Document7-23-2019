package com.dms.dao;

import com.dms.entity.File_details;

public interface File_detailsDao {
	public void saveOrUpdate(File_details file_details);
	public String searchLocation(String fileName);
}
