package com.dms.dao;

import java.util.List;

import com.dms.entity.Directory;
public interface DirectoryDao {
	public List<Directory> viewAllDirectory();
	public Directory searchDirectory(Directory directory);
	public void deleteDirectory(Directory directory);
	public void saveOrUpdateDirectory(Directory directory);
}
