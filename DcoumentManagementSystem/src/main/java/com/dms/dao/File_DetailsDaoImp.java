package com.dms.dao;


import org.apache.commons.io.FilenameUtils;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.dms.entity.File_details;
import com.dms.entity.File_location;
@Repository
@org.springframework.transaction.annotation.Transactional
public class File_DetailsDaoImp implements File_detailsDao{
	@Autowired
	private SessionFactory sessionFactory;


	public void saveOrUpdate(File_details file_details) {
		// TODO Auto-generated method stub
		Session session=sessionFactory.getCurrentSession();
		session.saveOrUpdate(file_details);
	}


	@Override
	public String searchLocation(String fileName) {
		// TODO Auto-generated method stub
		String fileType=FilenameUtils.getExtension(fileName).toLowerCase();
		String name =FilenameUtils.removeExtension(fileName);
		Session session=sessionFactory.getCurrentSession();
		Criteria cr = session.createCriteria(File_details.class);
		cr.add(Restrictions.eq("file_type", fileType));
		File_details file=(File_details) cr.uniqueResult();
		return file.getFile_location().getLocation();
	}

}
