package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import dto.Train;


public class TrainDao {

	EntityManagerFactory e=Persistence.createEntityManagerFactory("dev");
	EntityManager m=e.createEntityManager();
	EntityTransaction t=m.getTransaction();
	
	public void save(Train tr)
	{
		t.begin();
		m.persist(tr);
		t.commit();
	}
	
	public List<Train> fetchAll()
	{
		return m.createQuery("select x from Train x").getResultList();
	}
	
	public void delete(int number)
	{
		t.begin();
		m.remove(m.find(Train.class, number));
		t.commit();
	}
	
	public Train fetch(int number)
	{
		return m.find(Train.class, number);
	}
	
	public void update(Train train)
	{
		t.begin();
		m.merge(train);
		t.commit();
	}
}
