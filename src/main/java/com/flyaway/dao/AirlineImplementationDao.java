package com.flyaway.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import com.flyaway.bean.Airline;
import com.flyaway.util.HibernateUtil;

public class AirlineImplementationDao implements AirlineDao{

	@Override
	public boolean addAirline(String airlineName) {
		// TODO Auto-generated method stub
		boolean result = false;
		try {
			SessionFactory factory = HibernateUtil.getSessionFactory();

			Session session = factory.openSession();

			Transaction transaction = session.beginTransaction();

			Airline airline = new Airline();
			airline.setAirlineName(airlineName);
	        session.save(airline);
			transaction.commit();

			factory.close();
			result = true;
		}catch (Exception e) {
			// TODO: handle exception
		}
		return result;
	}

	@Override
	public boolean deleteAirline(long airlineID) {
		// TODO Auto-generated method stub
		boolean result = false;
		try {
			SessionFactory factory = HibernateUtil.getSessionFactory();

			Session session = factory.openSession();

			Transaction transaction = session.beginTransaction();

            Airline airline = session.get(Airline.class, airlineID);
            if (airline != null) {
                session.delete(airline);
                System.out.println("Airline is deleted");
            }

            // commit transaction
            transaction.commit();
            result = true;
		}catch (Exception e) {
			// TODO: handle exception
		}
		return result;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Airline> getAllAirline() {
		// TODO Auto-generated method stub
		Transaction transaction = null;
        List <Airline> listOfAirlines = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            // start a transaction
            transaction = session.beginTransaction();

            listOfAirlines = session.createQuery("from Airline").getResultList();
            System.out.println(listOfAirlines);

            // commit transaction
            transaction.commit();
        } catch (Exception e) {
			/*
			 * if (transaction != null) { transaction.rollback(); }
			 */
            e.printStackTrace();
        }
        return listOfAirlines;
	}

}
