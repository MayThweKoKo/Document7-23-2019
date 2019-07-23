package com.dms.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
@Entity
public class File_details implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private String name;
	private long root_folder;
	
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public long getRoot_folder() {
		return root_folder;
	}
	public void setRoot_folder(long root_folder) {
		this.root_folder = root_folder;
	}
	@ManyToOne
	private File_location file_location=new File_location();
	public File_location getFile_location() {
		return file_location;
	}
	public void setFile_location(File_location file_location) {
		this.file_location = file_location;
	}
	
	
}
