package org.example.dao.impl;

import org.example.config.HibernateConfig;
import org.example.dao.ApartmentDao;
import org.example.entity.Apartment;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class ApartmentDaoImpl implements ApartmentDao {

    @Override
    public boolean save(Apartment apartment) {
        Transaction transaction = null;
        try (Session session = HibernateConfig.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.save(apartment);
            transaction.commit();
            return true;
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean update(Apartment apartment) {
        Transaction transaction = null;
        try (Session session = HibernateConfig.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.update(apartment);
            transaction.commit();
            return true;
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean delete(Integer apartmentId) {
        Transaction transaction = null;
        try (Session session = HibernateConfig.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();

            Apartment apartment = session.get(Apartment.class, apartmentId);
            if (apartment != null) {
                session.delete(apartment);
            }

            transaction.commit();
            return true;
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public Apartment get(Integer apartmentId) {
        Transaction transaction = null;
        Apartment apartment = null;
        try (Session session = HibernateConfig.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            apartment = session.get(Apartment.class, apartmentId);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return apartment;
    }
}
