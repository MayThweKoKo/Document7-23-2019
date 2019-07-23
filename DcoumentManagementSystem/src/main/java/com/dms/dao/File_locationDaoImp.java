package com.dms.dao;

import java.io.File;
import java.util.List;

import javax.servlet.ServletContext;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.dms.entity.File_location;

@Repository
@org.springframework.transaction.annotation.Transactional
public class File_locationDaoImp implements File_locationDao{
	@Autowired private SessionFactory sessionFactory;
	@Autowired private ServletContext servletContext;
	
	public List<File_location> viewAllFile_location() {
		// TODO Auto-generated method stub
		List<File_location> list_file_location=sessionFactory.getCurrentSession().createCriteria(File_location.class).list();
		return list_file_location;
	}

	public String searchFile_location(String type) {
		// TODO Auto-generated method stub
		Session session=sessionFactory.getCurrentSession();
		Criteria cr = session.createCriteria(File_location.class);
		cr.add(Restrictions.eq("file_type", type));
		File_location file=(File_location) cr.uniqueResult();
		String path=file.getLocation();
		File rootDir = new File( servletContext.getRealPath(path) );
		String realPath=rootDir.getAbsolutePath();
		System.out.println(rootDir+realPath);
		return realPath;
	}

	public void deleteFile_location(File_location file_location) {
		// TODO Auto-generated method stub
		Session session=sessionFactory.getCurrentSession();
		File_location delete_file_location=(File_location) session.get(File_location.class,file_location.getId());
		session.delete(delete_file_location);
		session.flush();
	}

	public void saveOrUpdateFile_location(File_location file_location) {
		// TODO Auto-generated method stub
		Session session=sessionFactory.getCurrentSession();
		session.saveOrUpdate(file_location);
	}
	
}
