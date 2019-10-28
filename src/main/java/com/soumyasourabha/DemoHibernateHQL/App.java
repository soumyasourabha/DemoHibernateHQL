package com.soumyasourabha.DemoHibernateHQL;

import java.util.List;
import java.util.Random;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class App 
{
    public static void main( String[] args )
    {
    	Configuration con = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(student.class);

		SessionFactory sf = con.buildSessionFactory();

		Session session = sf.openSession();
		
		Transaction tr = session.beginTransaction();
		
		int b = 3;
		
		student student= new student();
		
		Query q = session.createQuery("select rollno,name,mark from student where mark = :b");
		q.setParameter("b", b);
		
		List<Object[]> s = (List<Object[]>) q.list();
		
		for(Object[] std : s) {
			
			System.out.println(std[0]+" : "+std[1]+" : "+std[2]);
		}
	
		
		tr.commit();
		
    }
}
