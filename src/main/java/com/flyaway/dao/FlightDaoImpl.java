package com.flyaway.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.flyaway.bean.Flight;
import com.flyaway.util.HibernateUtil;

public class FlightDaoImpl implements FlightDao {
	
	@Override
	public boolean saveFlight(Flight flight) {
		// TODO Auto-generated method stub
		boolean result = false;
		try {
			SessionFactory factory = HibernateUtil.getSessionFactory();

			Session session = factory.openSession();

			Transaction transaction = session.beginTransaction();

	        session.save(flight);
			transaction.commit();

			factory.close();
			result = true;
		}catch (Exception e) {
			// TODO: handle exception
		}
		return result;
	}

	@Override
	public boolean deleteFlight(long flightId) {
		// TODO Auto-generated method stub
		boolean result = false;
		Transaction transaction = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            // start a transaction
            transaction = session.beginTransaction();

            Flight flight = session.get(Flight.class, flightId);
            if (flight != null) {
                session.delete(flight);
                System.out.println("Flight is deleted");
            }

            // commit transaction
            transaction.commit();
            result = true;
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
            result = false;
        }
		return result;
}

	@SuppressWarnings("unchecked")
	@Override
	public List<Flight> getAllFlights() {
		// TODO Auto-generated method stub
		Transaction transaction = null;
        List <Flight> listOfFlights = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            // start a transaction
            transaction = session.beginTransaction();

            listOfFlights = session.createQuery("from Flight").getResultList();

            // commit transaction
            transaction.commit();
        } catch (Exception e) {
			/*
			 * if (transaction != null) { transaction.rollback(); }
			 */
            e.printStackTrace();
        }
        return listOfFlights;
	}

	@Override
	public Flight getFlight(long flightId) {
		// TODO Auto-generated method stub
		Transaction transaction = null;
        Flight flight = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            // start a transaction
            transaction = session.beginTransaction();
            // get an user object
            flight = session.get(Flight.class, flightId);
            // commit transaction
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return flight;
	}

}
