package com.dms.dao;

import java.util.List;

import com.dms.entity.File_location;
public interface File_locationDao {
	public List<File_location> viewAllFile_location();
	public String searchFile_location(String type);
	public void deleteFile_location(File_location file_location);
	public void saveOrUpdateFile_location(File_location file_location);
}
