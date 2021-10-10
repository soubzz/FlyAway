package com.flyaway.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.flyaway.bean.Location;
import com.flyaway.bean.UserData;
import com.flyaway.util.HibernateUtil;

public class UserDataDaoImpl implements UserDataDao {

	@Override
	public boolean saveUser(UserData user) {
		// TODO Auto-generated method stub
		boolean result = false;
		try {
			SessionFactory factory = HibernateUtil.getSessionFactory();

			Session session = factory.openSession();

			Transaction transaction = session.beginTransaction();

	        session.save(user);
			transaction.commit();

			factory.close();
			result = true;
		}catch (Exception e) {
			// TODO: handle exception
		}
		return result;
	}

	@Override
	public UserData getUser(String email) {
		// TODO Auto-generated method stub
		Transaction transaction = null;
        UserData user = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            // start a transaction
            transaction = session.beginTransaction();

            user = (UserData) session.createQuery("from UserData where userType = 'admin' and email = " + email);

            // commit transaction
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<UserData> getAllUser() {
		// TODO Auto-generated method stub
		Transaction transaction = null;
        List <UserData> listOfusers = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            // start a transaction
            transaction = session.beginTransaction();

            listOfusers = session.createQuery("from UserData").getResultList();
            System.out.println(listOfusers);

            // commit transaction
            transaction.commit();
        } catch (Exception e) {
            
            e.printStackTrace();
        }
        return listOfusers;
	}

	@Override
	public void updateUser(UserData user) {
		// TODO Auto-generated method stub
		Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            // start a transaction
            transaction = session.beginTransaction();
            // save the student object
            session.update(user);
            // commit transaction
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
	}

}
