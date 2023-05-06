package dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import dto.User;

public class UserDao {

	EntityManagerFactory e=Persistence.createEntityManagerFactory("dev");
	EntityManager m=e.createEntityManager();
	EntityTransaction t=m.getTransaction();
	
	public void save(User u)
	{
		t.begin();
		m.persist(u);
		t.commit();
	}
	
	public User find(int id)
	{
		return m.find(User.class, id);
	}
	
	public void update(User u)
	{
		t.begin();
		m.merge(u);
		t.commit();
	}
}
