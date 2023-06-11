package com.p.k;

import java.util.Properties;

import org.hibernate.Session;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import com.p.k.entity.Address;
import com.p.k.entity.Guide;
//import com.p.k.entity.Message;
import com.p.k.domain.Message;
import com.p.k.entity.Person;
import com.p.k.entity.Student;

public class Main {
	
	public static void main(String[] args) {
		
		Message message = new Message("New message");
//		Address address = new Address("Khreschatyck", "Kyiv", "001026");
//		Person person = new Person("Valeriy", address);
//		Guide guide = new Guide("121212", "Kyril", 12000);
//		Student student = new Student("11111", "Valeriy", guide);
		
		
		Configuration configuration = new Configuration().configure("hibernate.xml");
		Properties properties = configuration.getProperties();
		Session session = configuration.buildSessionFactory(new StandardServiceRegistryBuilder()
				.applySettings(properties)
				.build())
				.openSession();
		
		
//		Configuration configuration = new Configuration();
//		ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
//		Session session = configuration.buildSessionFactory(serviceRegistry).openSession();
		
		
		
		
		session.beginTransaction();
		
		session.save(message);
//		session.save(person);
//		session.save(guide);
//		session.save(student);
//		session.persist(student);
		
		session.getTransaction().commit();
		
//		message = (Message) session.get(Message.class, 2L);
//		System.out.println(message);
		
		session.close();
		
		
//		EntityManagerFactory emf = Persistence.createEntityManagerFactory("test");
//		EntityManager em = emf.createEntityManager();
//		EntityTransaction txn = em.getTransaction();
//		
//		txn.begin();
//		Query query = em.createQuery("select guide from Guide as guide");
//		List<Guide> guides = query.getResultList();
//		for (Guide guide : guides)  System.out.println(guide); 
//		txn.commit();
		
		

	}

}
