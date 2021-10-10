package com.flyaway.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.flyaway.bean.Location;
import com.flyaway.util.HibernateUtil;

public class LocationDaoImpl implements LocationDao {

	@Override
	public boolean saveLocation(Location location) {
		// TODO Auto-generated method stub
		boolean result = false;
		try {
			SessionFactory factory = HibernateUtil.getSessionFactory();

			Session session = factory.openSession();

			Transaction transaction = session.beginTransaction();

	        session.save(location);
			transaction.commit();

			factory.close();
			result = true;
		}catch (Exception e) {
			// TODO: handle exception
		}
		return result;
	}

	@Override
	public boolean deleteLocation(long locationId) {
		// TODO Auto-generated method stub
		boolean result = false;
		Transaction transaction = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            // start a transaction
            transaction = session.beginTransaction();

            Location location = session.get(Location.class, locationId);
            if (location != null) {
                session.delete(location);
                System.out.println("Location is deleted");
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

	@Override
	public List<Location> getAllLocations() {
		// TODO Auto-generated method stub
		Transaction transaction = null;
        List <Location> listOfLocations = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            // start a transaction
            transaction = session.beginTransaction();

            listOfLocations = (List<Location>) session.createQuery("from Location", Location.class).getResultList();

            // commit transaction
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return listOfLocations;
	}

}
