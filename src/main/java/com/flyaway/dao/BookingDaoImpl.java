package com.flyaway.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.flyaway.bean.Booking;
import com.flyaway.util.HibernateUtil;

public class BookingDaoImpl implements BookingDao {

	@Override
	public long saveBooking(Booking booking) {
		// TODO Auto-generated method stub
		long bookingID = 0;
		try {
			SessionFactory factory = HibernateUtil.getSessionFactory();

			Session session = factory.openSession();

			Transaction transaction = session.beginTransaction();

	        bookingID = (long) session.save(booking);
			transaction.commit();

			factory.close();
		}catch (Exception e) {
			// TODO: handle exception
		}
		return bookingID;
	}

	@Override
	public boolean deleteBooking(long bookingID) {
		// TODO Auto-generated method stub
		boolean result = false;
		try {
			SessionFactory factory = HibernateUtil.getSessionFactory();

			Session session = factory.openSession();

			Transaction transaction = session.beginTransaction();

            Booking booking = session.get(Booking.class, bookingID);
            if (booking != null) {
                session.delete(booking);
                System.out.println("Booking is deleted");
            }

            // commit transaction
            transaction.commit();
            result = true;
		}catch (Exception e) {
			// TODO: handle exception
		}
		return result;
	}

	@Override
	public List<Booking> getAllBooking() {
		// TODO Auto-generated method stub
		Transaction transaction = null;
        List <Booking> listOfBookings = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            // start a transaction
            transaction = session.beginTransaction();

            listOfBookings = (ArrayList<Booking>) session.createQuery("from Booking", Booking.class).getResultList();

            // commit transaction
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return listOfBookings;
	}

	@Override
	public void updateBooking(Booking booking) {
		// TODO Auto-generated method stub
		try {
			SessionFactory factory = HibernateUtil.getSessionFactory();

			Session session = factory.openSession();

			Transaction transaction = session.beginTransaction();

	        session.update(booking);
			transaction.commit();

			factory.close();
		}catch (Exception e) {
			// TODO: handle exception
		}
	}

}
