package com.dms.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.dms.entity.Directory;

@Repository
@org.springframework.transaction.annotation.Transactional
public class DirectoryDaoImp implements DirectoryDao{
	@Autowired
	private SessionFactory sessionFactory;

	public List<Directory> viewAllDirectory() {
		// TODO Auto-generated method stub
		List<Directory> list_directory=sessionFactory.getCurrentSession().createCriteria(Directory.class).list();
		return list_directory;
	}

	public Directory searchDirectory(Directory directory) {
		// TODO Auto-generated method stub
		Session session=sessionFactory.getCurrentSession();
		Directory search_directory=(Directory) session.get(Directory.class, directory.getId());
		
		return search_directory;
	}

	public void deleteDirectory(Directory directory) {
		// TODO Auto-generated method stub
		Session session=sessionFactory.getCurrentSession();
		Directory delete_directory=(Directory) session.get(Directory.class,directory.getId());
		session.delete(delete_directory);
		session.flush();
	}

	public void saveOrUpdateDirectory(Directory directory) {
		// TODO Auto-generated method stub
		Session session=sessionFactory.getCurrentSession();
		session.saveOrUpdate(directory);
	}
}
